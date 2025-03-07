package personal_Project.PCMaker_Rebuild.controller.dto;

import java.util.List;
import java.util.UUID;

import personal_Project.PCMaker_Rebuild.domain.model.Build;

import static java.util.Collections.emptyList;
import static java.util.Optional.ofNullable;
import static java.util.stream.Collectors.toList;

public record BuildDto(
        UUID id,
        String name,
        String total,
        String description,
        List<ItemDto> itens) {

    public BuildDto(Build model) {
        this(
                model.getId(),
                model.getName(),
                model.getTotal(),
                model.getDescription(),
                ofNullable(model.getItens()).orElse(emptyList()).stream().map(ItemDto::new).collect(toList()));
    }
}
