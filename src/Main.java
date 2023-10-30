public class Main {
    public static void main (String [] args){
        System.out.println("============== \tSistema Bancário ================");

        // Criando um Cliente que é Pessoa Física
        Cliente pf1 = new PessoaFisica(
                "Filipe Ret",
                "Avenida Princesa Isabel 130, RJ, BRA",
                "123.123.123",
                28,
                'M');

        // Criando um Cliente que é Pessoa Jurídica
        Cliente pj1 = new PessoaJuridica(
                "Apple Inc",
                "Cupertino, California, EUA",
                "222.222.222",
                130579,
                "Tecnologia");

        System.out.println(pf1);              // imprime dados de Pessoa Fisica pf1 por meio do toString()
        System.out.println(pj1);             // imprime dados de Pessoa Juridica pj1 por meio do toString()
    }

    private static void imprimirExtrato() {
    }
}

