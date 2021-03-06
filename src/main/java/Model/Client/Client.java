package Model.Client;


import Model.Utils.Adress;
import Model.Utils.JpaUtil;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.List;

@Entity

public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String name;
    private String document;
    private Integer documentType;
    private String phone;
    private boolean status;
    @OneToOne (cascade= CascadeType.ALL, orphanRemoval = true)
    private Adress adress;

    public Client(){

    }

    public Client(String name, String document,Integer documentType, String phone, boolean status, Adress adress) {
        this.name = name;
        this.document = document;
        this.documentType = documentType;
        this.phone = phone;
        this.status = status;
        this.adress = adress;
    }

    public Long getId(long l) {
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
        cliente = entityManager.merge(cliente);
        clientDao.creat(cliente);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void createAdress(Adress adress){
        EntityManager entityManager = JpaUtil.getEntityManager();
        AdressDao adressDao = new AdressDao(entityManager);
        entityManager.getTransaction().begin();
        adress = entityManager.merge(adress);
        adressDao.createAdress(adress);
        entityManager.getTransaction().commit();
        entityManager.close();

    }


    public List<Client> listClients() {
        EntityManager entityManager = JpaUtil.getEntityManager();
        String jpql = "SELECT c FROM Client c";
        return entityManager.createQuery(jpql, Client.class).getResultList();

    }
    public void deleteClient(Long id){
        EntityManager entityManager = JpaUtil.getEntityManager();
        Client c = entityManager.find(Client.class, id);
        if (c != null) {
            ClientDao clientDao = new ClientDao(entityManager);
            entityManager.getTransaction().begin();
            clientDao.delete(c);
            entityManager.getTransaction().commit();
            System.out.println("Registro Excluido");
        }else {
            System.out.println("Registro n??o encontrado");
        }
        entityManager.close();







    }
}



