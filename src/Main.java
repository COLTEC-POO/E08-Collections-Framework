import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        Scanner entrada = new Scanner(System.in);

        System.out.println("Sistema Bancario");
        System.out.println("\n");

        PessoaFisica pf1 = new PessoaFisica(

                "Leandro",
                "Concordia, BH - MG",
                "222222",
                27,
                'M'
        );


        System.out.println(pf1.toString());

        PessoaFisica pf2 = new PessoaFisica(

                "Xavier",
                "Renascença, BH - MG",
                "12345667",
                72,
                'M'
        );

        System.out.println(pf2.toString());

        if (pf1.equals(pf2)) {
            System.out.println("São iguais\n");
        }
        else {
            System.out.println("São diferentes!\n");
        }

        PessoaJuridica pj1 = new PessoaJuridica(

                "Araujo",
                "Savassi, BH - MG",
                "11111",
                6,
                "Distribuidora"

        );


        System.out.println(pj1.toString());

        PessoaJuridica pj2 = new PessoaJuridica(

                "Alves",
                "Carlos Prates, BH - MG",
                "11111",
                9,
                "Marketing"

        );

        System.out.println(pj2.toString());

        if (pj1.equals(pj2)) {
            System.out.println("São iguais\n");
        }
        else {
            System.out.println("São diferentes!\n");
        }


        Cliente[] clientes = new Cliente[4];

        clientes[0] = pf1;
        clientes[1] = pf2;
        clientes[2] = pj1;
        clientes[3] = pj2;



        System.out.println("Historico Conta");
        System.out.println("\n");


        Conta c1 = new Conta(
                444,
                "22234",
                879,
                pf1,
                1000
        );

        System.out.println(c1.toString());

        Conta c2 = new Conta(
                888,
                "43222",
                978,
                pf2,
                3000
        );

        System.out.println(c2.toString());

        if (c1.equals(c2)) {
            System.out.println("São iguais\n");
        }
        else {
            System.out.println("São diferentes!\n");
        }

        if(pj1.autenticar("11111")) {
            System.out.println("Esta autenticada\n");
        } else {
            System.out.println("Nao esta autenticada\n");
        }

        if(pf1.autenticar("12345667")) {
            System.out.println("Esta autenticada\n");
        } else {
            System.out.println("Nao esta autenticada\n");
        }

        c1.depositar(1234);
        c1.depositar(4321);
        c1.sacar(920);
        c1.sacar(2129);
        c1.depositar(777);
        c1.sacar(878);

        c1.imprimirExtrato();

        int totalContas = Conta.getTotalContas();
        int totalOperacoes = Operacao.getTotalOperacoes();

        double media = totalOperacoes / totalContas;


        System.out.println("contas no sistema: "+ totalContas);
        System.out.println("operacoes no sistema: " + totalOperacoes);
        System.out.println("media: "+ media);

    }

}