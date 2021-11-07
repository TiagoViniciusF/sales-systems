package Model.Client;

public class TestaCnpj {
    public static void main(String[] args) {
        String cnpj = "03778130000108";


        if (BusinessClient.validaCnpj(cnpj) == true)
            System.out.printf("%s\n", BusinessClient.imprimeCNPJ(cnpj));
        else System.out.printf("Erro, CNPJ inválido !!!\n");


        String cpf = "09388000000";

        if (PersonalClient.validaCpf(cpf) == true)
            System.out.printf("%s\n", PersonalClient.imprimeCPF(cpf));
        else System.out.printf("Erro, CPF inválido !!!\n");
    }
}
