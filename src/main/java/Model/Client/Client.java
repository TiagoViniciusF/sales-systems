package Model.Client;


import Model.Utils.Adress;
import Model.Utils.JpaUtil;

import javax.persistence.*;

@Entity

public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String document;
    private Integer documentType;
    private String phone;
    private boolean status;
    @OneToOne
    private Adress adress;

    public Client(String name, String document,Integer documentType, String phone, boolean status, Adress adress) {
        this.name = name;
        this.document = document;
        this.phone = phone;
        this.status = status;
        this.adress = adress;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocument() {
        return document;
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    //TODO PASSAR METODOS PARA CAMADA DE SERVICE
    public void create(Client cliente){

        EntityManager entityManager = JpaUtil.getEntityManager();
        ClientDao clientDao = new ClientDao(entityManager);
        entityManager.getTransaction().begin();
        clientDao.creat(cliente);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void createAdress(Adress adress){
        EntityManager entityManager = JpaUtil.getEntityManager();
        AdressDao adressDao = new AdressDao(entityManager);
        entityManager.getTransaction().begin();
        adressDao.createAdress(adress);
        entityManager.getTransaction().commit();
        entityManager.close();

    }


}



