package Model.Product;
import Model.Utils.JpaUtil;
import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private BigDecimal quantity;
    private BigDecimal price;
    @ManyToOne
    private Category category;


    public Product(String nome, BigDecimal quantity, BigDecimal price, Category category) {
        this.nome = nome;
        this.quantity = quantity;
        this.price = price;
        this.category = category;


    }

    public void createProduct(Product product) {
        EntityManager entityManager = JpaUtil.getEntityManager();
        ProductDao productDao = new ProductDao(entityManager);
        entityManager.getTransaction().begin();
        productDao.creatProduct(product);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
