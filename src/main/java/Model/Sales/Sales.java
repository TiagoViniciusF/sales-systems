package Model.Sales;

import Model.Client.Client;
import Model.Product.Product;
import com.sun.istack.NotNull;
import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Sales {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private BigDecimal amount;  //quantidade
    private LocalDate date = LocalDate.now();
    @ManyToOne (cascade= CascadeType.ALL)
    private Client client;

    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "sales")
    private List<ItemSales> itemSales = new ArrayList<>();

    public Sales(){
    }

    public Sales(BigDecimal amount, Client client, Product product) {
        this.amount = amount;
        this.client = client;
        this.itemSales = (List<ItemSales>) product;
    }

    public void addItem(ItemSales item){
        item.setSales(this);
        this.itemSales.add(item);

    }




    public void setProduct(List<ItemSales> product) {
        this.itemSales = product;
    }

    public List<ItemSales> getProduct() {
        return itemSales;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }





}
