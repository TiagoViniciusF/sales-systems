package Model.Client;

import Model.Utils.Adress;

import javax.persistence.EntityManager;

public class AdressDao {
    private EntityManager entityManager;

    public AdressDao(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    public void createAdress(Adress adress) {this.entityManager.persist(adress);
    }
}
