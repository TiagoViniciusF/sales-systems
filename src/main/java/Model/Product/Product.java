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



    public Product(String nome,BigDecimal quantity, BigDecimal price, Category category){
        this.price = price;
        this.nome = nome;
        this.category = category;
        this.quantity = quantity;

    }

    public void createProduct(Product product){
        EntityManager entityManager = JpaUtil.getEntityManager();
        ProductDao productDao = new ProductDao(entityManager);
        entityManager.getTransaction().begin();
        productDao.creatProduct(product);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

}
