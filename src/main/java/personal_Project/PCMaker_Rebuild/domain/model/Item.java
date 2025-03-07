package personal_Project.PCMaker_Rebuild.domain.model;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity(name = "tb_item-build")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private Integer quantity;
    private double subTotal;
    private Integer indexOfMarketplace;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Product> products;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public Integer getIndexOfMarketplace() {
        return indexOfMarketplace;
    }

    public void setIndexOfMarketplace(Integer indexOfMarketplace) {
        this.indexOfMarketplace = indexOfMarketplace;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

}
