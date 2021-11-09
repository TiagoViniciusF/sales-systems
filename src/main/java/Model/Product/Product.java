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
    private BigDecimal price;
    private String nome;
    @ManyToOne
    private Category category;



    public Product(BigDecimal price, String nome, Category category){
        this.price = price;
        this.nome = nome;
        this.category = category;

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
