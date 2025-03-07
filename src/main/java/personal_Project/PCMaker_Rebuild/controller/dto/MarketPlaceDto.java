package personal_Project.PCMaker_Rebuild.controller.dto;

import java.util.UUID;

import personal_Project.PCMaker_Rebuild.domain.model.MarketPlace;

public record MarketPlaceDto(
        UUID id,
        double price,
        String linkProduct,
        String store) {

    public MarketPlaceDto(MarketPlace model) {
        this(
                model.getId(),
                model.getPrice(),
                model.getLinkProduct(),
                model.getStore());
    }

    public MarketPlace toModel() {
        var model = new MarketPlace();
        model.setId(this.id);
        model.setPrice(this.price);
        model.setLinkProduct(this.linkProduct);
        model.setStore(this.store);
        return model;
    }

}
