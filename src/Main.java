public class Main {
    public static void main(String[] args) {

        // inicialização Cliente

        PessoaFisica jessica = new PessoaFisica();
        jessica.setNome("Jéssica Alves");
        jessica.setCpf("123.455.789-11");
        jessica.setEndereco("Rua Laranjeiras");
        jessica.setIdade(21);
        jessica.setSexo('f');

        PessoaFisica mateus = new PessoaFisica();
        mateus.setCpf("121.555.999-10");

        PessoaJuridica empresa = new PessoaJuridica();
        empresa.setNome("Banco X");
        empresa.setCnpj("10.510.789/0001-12");
        empresa.setEndereco("Avenida Raja Gabaglia, 822");
        empresa.setSetor("Financeiro");
        empresa.setNumFuncionarios(52);

        PessoaJuridica empresa2 = new PessoaJuridica();
        empresa2.setCnpj("10.510.789/0001-12");

        // inicialização Conta

        Conta minhaConta = new ContaCorrente();
        Conta suaConta = new ContaPoupanca();
        Conta suaEmpresa = new ContaCorrente();

        minhaConta.setDono(jessica);
        minhaConta.setNumConta(1013);
        minhaConta.setSaldo(0);

        suaConta.setNumConta(1111);

        suaEmpresa.setDono(empresa);
        suaEmpresa.setNumConta(1212);
        suaEmpresa.setSaldo(0);

        // impressão dados da conta

        System.out.println("--------------------- Dados Pessoa Física ----------------------");

        minhaConta.setLimite(80);
        System.out.println(jessica.toString());

        System.out.println("--------------------- Extrato ----------------------");

        minhaConta.depositar(3000);
        minhaConta.sacar(250);
        minhaConta.depositar(500);
        minhaConta.sacar(1500);
        minhaConta.imprimirExtrato(1); // por inserção
        minhaConta.imprimirExtratoTaxas();

        System.out.println("--------------------- Dados Pessoa Jurídica ----------------------");

        suaEmpresa.setLimite(3000);
        System.out.println(empresa.toString());

        System.out.println("--------------------- Extrato ----------------------");

        suaEmpresa.depositar(1000);
        suaEmpresa.sacar(100);
        suaEmpresa.depositar(700);
        suaEmpresa.sacar(200);
        suaEmpresa.imprimirExtrato(2); // ordenado por tipo
        suaEmpresa.imprimirExtratoTaxas();
    }
}