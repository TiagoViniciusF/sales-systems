package Model.Sales;

import Model.Product.Product;

import javax.persistence.*;
import java.math.BigDecimal;

@Table(name = "item_sales")
@Entity
public class ItemSales {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal unitPrice;
    private int quantity;

    @ManyToOne
    private Sales sales;
    @ManyToOne
    private Product product;

    public ItemSales() {
    }

    public ItemSales(int quantity, Sales sales, Product product) {
        this.quantity = quantity;
        this.sales = sales;
        this.unitPrice = product.getPrice();
        this.product = product;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Sales getSales() {
        return sales;
    }

    public void setSales(Sales sales) {
        this.sales = sales;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}