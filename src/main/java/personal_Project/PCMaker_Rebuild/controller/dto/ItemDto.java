package personal_Project.PCMaker_Rebuild.controller.dto;

import java.util.List;
import java.util.UUID;

import personal_Project.PCMaker_Rebuild.domain.model.Item;

import static java.util.Collections.emptyList;
import static java.util.Optional.ofNullable;
import static java.util.stream.Collectors.toList;

public record ItemDto(UUID id,
        Integer quantity,
        double subTotal,
        Integer indexOfMarketplace,
        List<ProductDto> products) {

    public ItemDto(Item model) {
        this(
                model.getId(),
                model.getQuantity(),
                model.getSubTotal(),
                model.getIndexOfMarketplace(),
                ofNullable(model.getProducts()).orElse(emptyList()).stream().map(ProductDto::new)
                        .collect(toList()));
    }

    public Item toModel() {
        var model = new Item();
        model.setId(this.id);
        model.setQuantity(this.quantity);
        model.setSubTotal(this.subTotal);
        model.setIndexOfMarketplace(this.indexOfMarketplace);
        model.setProducts(ofNullable(this.products)
                .orElse(emptyList())
                .stream()
                .map(ProductDto::toModel)
                .collect(toList()));
        return model;
    }

}
