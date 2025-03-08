package personal_Project.PCMaker_Rebuild.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import personal_Project.PCMaker_Rebuild.service.exception.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import personal_Project.PCMaker_Rebuild.domain.model.User;
import personal_Project.PCMaker_Rebuild.domain.repository.UserRepository;
import personal_Project.PCMaker_Rebuild.service.UserService;
import personal_Project.PCMaker_Rebuild.service.exception.BusinessException;

import static java.util.Optional.ofNullable;

@Service
public class UserServiceImpl implements UserService {

    private static final UUID UNCHANGEABLE_USER_ID = new UUID(0L, 1L); // Exemplo de UUID fixo

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private void validateChangeableId(UUID id, String operation) {
        if (UNCHANGEABLE_USER_ID.equals(id)) {
            throw new BusinessException("User with ID %d can not be %s.".formatted(UNCHANGEABLE_USER_ID, operation));
        }
    }

    @Transactional(readOnly = true)
    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    @Transactional(readOnly = true)
    public User findById(UUID id) {
        return this.userRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    @Transactional
    public User create(User userToCreate) {
        ofNullable(userToCreate).orElseThrow(() -> new BusinessException("User to create must not be null."));

        ZonedDateTime now = ZonedDateTime.now(ZoneId.of("UTC"));

        userToCreate.setCreatedAt(now);
        userToCreate.setUpdatedAt(now);

        this.validateChangeableId(userToCreate.getId(), "created");

        return this.userRepository.save(userToCreate);
    }

    @Transactional
    public User update(UUID id, User userToUpdate) {
        this.validateChangeableId(id, "updated");

        User dbUser = this.findById(id);
        if (!dbUser.getId().equals(userToUpdate.getId())) {
            throw new BusinessException("Update IDs must be the same.");
        }

        // Desta forma não apaga o valor do campo caso o valor passado seja nulo
        Optional.ofNullable(userToUpdate.getName()).ifPresent(dbUser::setName);
        Optional.ofNullable(userToUpdate.getEmail()).ifPresent(dbUser::setEmail);

        if (userToUpdate.getBuilds() != null && !userToUpdate.getBuilds().isEmpty()) {
            dbUser.setBuilds(userToUpdate.getBuilds());
        }

        dbUser.setUpdatedAt(ZonedDateTime.now(ZoneId.of("UTC")));

        return this.userRepository.save(dbUser);
    }

    @Transactional
    public void delete(UUID id) {
        this.validateChangeableId(id, "deleted");
        User dbUser = this.findById(id);
        this.userRepository.delete(dbUser);
    }

}
