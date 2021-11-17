package Model.Client;

import javax.persistence.EntityManager;


public class ClientDao {
    private EntityManager entityManager;

    public ClientDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void creat(Client cliente) {
        this.entityManager.persist(cliente);
    }
}


