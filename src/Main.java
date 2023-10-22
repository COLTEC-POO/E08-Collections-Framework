// Importação das subclasses de Cliente do pacote Cliente
import Cliente.Cliente;
import Cliente.PessoaFisica;
import Cliente.PessoaJuridica;

// Importação das subclasses de Conta do pacote Conta
import Conta.ContaCorrente;
import Conta.ContaPoupanca;
import Conta.ContaUniversitaria;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // Inicialização de dados
        PessoaFisica pF = new PessoaFisica("João", "Rua A", "12345678900", 30, 'M');
        ContaCorrente contaC = new ContaCorrente(1, "123", 20000, "João", 1000, pF);

        PessoaJuridica pJ = new PessoaJuridica("Nestlé", "Rua B", "Alimentos", "302", 3);
        ContaPoupanca contaP = new ContaPoupanca(1, "321", 200, "Nestlé", 200, pJ);


        List<Cliente> listaClientes = new ArrayList<>();
        listaClientes.add(pF);
        listaClientes.add(pJ);

        System.out.println("======Sistema Bancário======");
        System.out.println("Donos registrados:");
        for(Cliente c: listaClientes) {
            System.out.println(c.nome);
        }

        contaC.sacar(300);
        contaC.sacar(200);
        contaC.depositar(3000);

        contaP.sacar(200);
        contaP.depositar(3000);

        // Impressão no Terminal
        System.out.println();

        // Imprimindo Extrato de acordo com tipo inserido
        contaC.imprimirExtrato(2);
        System.out.println();
        contaC.imprimirExtratoTaxas();

        contaP.imprimirExtrato(1);
        System.out.println();
        contaP.imprimirExtratoTaxas();
    }
}