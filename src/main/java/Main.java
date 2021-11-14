import Model.Client.Client;
import Model.Client.PersonalClient;
import Model.Product.Category;
import Model.Product.Product;
import Model.Utils.Adress;
import Model.Utils.Document;


import java.math.BigDecimal;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("O que deseja fazer?");
        System.out.println("Digite 1 para cadastrar clientes, 2 para cadastrar Produtos");
        int option = scanner.nextInt();


        if (option == 1) {
            System.out.println("Digite o nome do cliente");
            var name = scanner.nextLine();

            System.out.println("Digite 1 para pessoa fisica e 2 para Juridica");
            int documentType = scanner.nextInt();

            boolean controleValidacaoDocument = false;
            while (controleValidacaoDocument == false){
                try{
                    System.out.println("Digite o CPF ou CNPJ");
                    var documentNumber = scanner.nextLine();
                    Document document = new Document(documentNumber,documentType);
                    controleValidacaoDocument = true;
                }catch (IllegalArgumentException e){
                    System.out.println(e.getMessage());
                }

            }
            System.out.println("Digite o numero do telefone");
            var phone = scanner.nextLine();

            System.out.println("Digite o endereço do cliente");
            var street = scanner.nextLine();
            System.out.println("Informe o numero");
            var number = scanner.nextLine();
            System.out.println("Informe a UF");
            var state = scanner.nextLine();
            System.out.println("Informe a Cidade");
            var city = scanner.nextLine();
            Adress adress = new Adress(street, number, state, city);
            Client client = new Client(name, number, documentType, phone,true, adress);
            client.create(client);
        }

        if(option == 2 ){
            System.out.println("Qual o nome do produto?");
            var name = scanner.nextLine();
            System.out.println("Informe a quantidade que quer adicionar ao estoque");
            var quantity = scanner.nextBigDecimal();
            System.out.println("Informe um valor de revenda");
            var price = scanner.nextBigDecimal();
        }






//       // Category category = new Category();
//        category.setNome("Notebooks");
//        Product product = new Product(new BigDecimal("2000"), "Notebook Acer Aspire Core i5", category, new BigDecimal("250"));
//        category.createCategory(category);
//        product.createProduct(product);



        scanner.close();

    }



}
