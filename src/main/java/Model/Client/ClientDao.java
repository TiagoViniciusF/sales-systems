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

    public void update(Client client){
        this.entityManager.persist(client);
    }

    public void delete(Client client){
        client = entityManager.merge(client);
        this.entityManager.remove(client);
    }
}


