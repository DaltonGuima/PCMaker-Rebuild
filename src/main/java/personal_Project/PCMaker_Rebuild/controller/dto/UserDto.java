package personal_Project.PCMaker_Rebuild.controller.dto;

import java.util.List;
import java.util.UUID;

import personal_Project.PCMaker_Rebuild.domain.model.User;

import static java.util.Collections.emptyList;
import static java.util.Optional.ofNullable;
import static java.util.stream.Collectors.toList;

public record UserDto(
        UUID id,
        String name,
        String email,
        List<BuildDto> builds) {

    public UserDto(User model) {
        this(
                model.getId(),
                model.getName(),
                model.getEmail(),
                ofNullable(model.getBuilds()).orElse(emptyList()).stream().map(BuildDto::new)
                        .collect(toList()));
    }

    public User toModel() {
        var model = new User();
        model.setId(this.id);
        model.setName(this.name);
        model.setEmail(this.email);
        model.setBuilds(ofNullable(this.builds)
                .orElse(emptyList())
                .stream()
                .map(BuildDto::toModel)
                .collect(toList()));
        return model;
    }
}
