package Model.Product;
import javax.persistence.EntityManager;

public class CategoryDao {

    private EntityManager entityManager;

    public CategoryDao(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    public void creatCategory(Category category){
        this.entityManager.persist(category);
    }

}
