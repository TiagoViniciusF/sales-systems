package Model.Client;




public class RegisteringClients {

    public static void main(String[] args) {

        Client client = new Client();
        client.setName("Tiago Vinicius Ferreira");
        client.setPhone("3313-0315");
        client.setDocument("093.881.126.60");
        client.setStatus(true);




        client.create(client);
    }



}
