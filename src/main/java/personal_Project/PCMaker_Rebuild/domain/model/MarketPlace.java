package personal_Project.PCMaker_Rebuild.domain.model;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "tb_marketplace")
public class MarketPlace {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private double price;
    private String linkProduct;
    private String store;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getLinkProduct() {
        return linkProduct;
    }

    public void setLinkProduct(String linkProduct) {
        this.linkProduct = linkProduct;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

}
