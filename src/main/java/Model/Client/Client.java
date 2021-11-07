package Model.Client;


import Model.Utils.JpaUtil;

import javax.persistence.*;

@Entity

public class Client {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String document;
    private String phone;
    private boolean status;



    public void create(Client cliente){




       EntityManager entityManager = JpaUtil.getEntityManager();
        ClientDao clientDao = new ClientDao(entityManager);
        entityManager.getTransaction().begin();
        clientDao.creat(cliente);
        entityManager.getTransaction().commit();
        entityManager.close();

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

    public void setDocument(String document) {
        this.document = document;
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




}



