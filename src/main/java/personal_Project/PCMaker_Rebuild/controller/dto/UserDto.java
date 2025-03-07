package personal_Project.PCMaker_Rebuild.controller.dto;

import java.util.List;
import java.util.UUID;

import personal_Project.PCMaker_Rebuild.domain.model.Build;

import static java.util.Collections.emptyList;
import static java.util.Optional.ofNullable;
import static java.util.stream.Collectors.toList;

public record UserDtO(
        UUID id,
        String name,
        String email,
        List<Build> builds) {

    public UserDtO(User model) {
        this(
                model.getId(),
                model.getName(),
                ofNullable(model.getEmail()),
                model.getBuilds());
    }
}
