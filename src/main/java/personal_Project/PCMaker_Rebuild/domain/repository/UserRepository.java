package personal_Project.PCMaker_Rebuild.domain.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import personal_Project.PCMaker_Rebuild.domain.model.User;

public interface UserRepository extends JpaRepository<User, UUID> {

}
