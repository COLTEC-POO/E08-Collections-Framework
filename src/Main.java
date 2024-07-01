import java.util.Date;

public class Main {
    public static void main(String[] args) {
        // Criando um cliente que é uma pessoa física
        Cliente pessoa = new PessoaFisica("João", "Av. Antonio Carlos, 6627",new Date(), "111.111.111-11", 36, 'm');
        
        // Criando uma conta corrente para esse cliente
        Conta cc = new ContaCorrente(1000,pessoa,100,100);
        cc.setDono(pessoa);
        
        //Fazendo operações de saques e depósitos
        cc.depositar(1000);
        cc.depositar(2000);
        cc.sacar(100);
        cc.depositar(3000);
        cc.sacar(10);
        cc.sacar(15);
        
        cc.imprimirExtrato(1);
        cc.imprimirExtrato(0);
        cc.imprimirExtratoTaxas();
    }
}