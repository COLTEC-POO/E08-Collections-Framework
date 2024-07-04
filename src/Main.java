public class Main {
    public static void main(String[] args) {

        PessoaFisica junia = new PessoaFisica("Junia", "Av. Antonio Carlos, 662", "010.065.376.20", 20, 'f');
        PessoaFisica joao = new PessoaFisica("Joao", "R. Planalto, 69", "090.957.646.43", 40, 'm');

        PessoaJuridica loja1 = new PessoaJuridica("Brecho", "Av. Antonio Carlos, 112", "555669864", 95, "Shipping");
        PessoaJuridica loja2 = new PessoaJuridica("Americanas", "Av. Fleming, 111", "555669296", 38, "Retail");

        Conta conta1 = new ContaUniversitaria(1021, joao, 565, -500, 3500);
        Conta conta2 = new ContaCorrente(1234, junia, 1000, -300, 1500); //
        conta1.setDono(loja2);

        System.out.println(conta2);

        conta1.depositar(3000);
        conta1.sacar(500); //

        conta2.transferir(conta1, 666); //
        conta2.depositar(234);
        conta2.sacar(350); //
        conta2.sacar(25);

        System.out.println(conta2);

        System.out.println(junia);
        System.out.println(loja1);

        int media = Operacao.getTotalOperacoes() / Conta.getTotalContas();
        System.out.println("\nMédia de operações por conta aberta: " + media);

        System.out.println("conta1 == conta2 ? " + conta1.equals(conta2));
        System.out.println("junia == joao ? " + junia.equals(joao));
        System.out.println("loja1 == loja2 ? " + loja1.equals(loja2));

        System.out.println("authenticator: " + loja2.autenticar("555669296"));

        conta2.imprimirExtratoTaxas();
        conta2.imprimirExtratoConta(1);
        conta2.imprimirExtratoConta(0);

    }

}