package Model.Product;
import javax.persistence.EntityManager;

public class ProductDao {

        private EntityManager entityManager;

        public ProductDao(EntityManager entityManager){
            this.entityManager = entityManager;
        }
        public void creatProduct(Product product){
            this.entityManager.persist(product);
        }
}

