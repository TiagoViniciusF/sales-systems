package Model.Client;


import Model.Product.Category;
import Model.Product.Product;
import Model.Utils.Adress;

import java.math.BigDecimal;

public class RegisteringClients {

    public static void main(String[] args) {

        Client client = new Client();
        client.setName("Paulo Rodrigues");
        client.setPhone("3713-0395");
        client.setDocument("000.881.126.60");
        client.setStatus(true);
        client.create(client);

        Adress adress = new Adress();
        adress.setStreet("Rua Benicio de Souza");
        adress.setNumber("40");
        adress.setCity("Belo Horizonte");
        adress.setState("MG");
        client.createAdress(adress);

        Category category = new Category();
        category.setNome("Notebooks");
        Product product = new Product(new BigDecimal("2000"), "Notabook Acer Aspire Core i5", category);
        category.createCategory(category);
        product.createProduct(product);


    }



}
