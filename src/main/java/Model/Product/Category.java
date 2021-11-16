package Model.Product;

import Model.Utils.JpaUtil;

import javax.persistence.*;

@Entity
@Table(name = "categorias")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    public Category(String nome){
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
