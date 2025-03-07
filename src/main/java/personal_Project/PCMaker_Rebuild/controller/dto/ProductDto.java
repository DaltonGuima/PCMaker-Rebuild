package personal_Project.PCMaker_Rebuild.controller.dto;

import java.util.List;
import java.util.UUID;

import personal_Project.PCMaker_Rebuild.domain.model.Product;

import static java.util.Collections.emptyList;
import static java.util.Optional.ofNullable;
import static java.util.stream.Collectors.toList;

public record ProductDto(
        UUID id,
        String name,
        String madeBy,
        String model,
        String category,
        List<MarketPlaceDto> marketplaces) {

    public ProductDto(Product model) {
        this(
                model.getId(),
                model.getName(),
                model.getMadeBy(),
                model.getModel(),
                model.getCategory(),
                ofNullable(model.getMarketplaces()).orElse(emptyList()).stream().map(MarketPlaceDto::new)
                        .collect(toList()));
    }

    public Product toModel() {
        var model = new Product();
        model.setId(this.id);
        model.setName(this.name);
        model.setMadeBy(this.madeBy);
        model.setModel(this.model);
        model.setCategory(this.category);
        model.setMarketplaces(
                ofNullable(this.marketplaces)
                        .orElse(emptyList())
                        .stream()
                        .map(MarketPlaceDto::toModel)
                        .collect(toList()));
        return model;
    }

}