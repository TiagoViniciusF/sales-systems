package Model.Product;

import Model.Utils.JpaUtil;

import javax.persistence.*;

@Entity
@Table(name = "categorias")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Category(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void createCategory(Category category){
        EntityManager entityManager = JpaUtil.getEntityManager();
        CategoryDao categoryDao = new CategoryDao(entityManager);
        entityManager.getTransaction().begin();
        categoryDao.creatCategory(category);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
