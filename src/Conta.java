import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public abstract class Conta implements ITaxas {
    Scanner entrada = new Scanner(System.in);
    public static int iNumContas = 0;


    private Cliente nome;
    private int numConta;
    private double saldo;
    private double limite;
    private List<Operacao> operacoes;
    public int nOperacoes = 0;
    private double minLimite;
    private double maxLimite;


    public Conta(int numConta, Cliente nome){
        this.numConta = numConta;
        this.saldo = saldo;
        this.limite = saldo*2;
        this.nome = nome;

        Conta.iNumContas ++;
        operacoes = new ArrayList<>();
    }

    void imprimir(){
        System.out.println("....Número da conta: " + numConta);
        System.out.println("....Nome: " + this.nome.getNome());
        System.out.println("....CPF: " + this.nome.getEndereco());
        System.out.println("....Saldo: " + saldo);
        System.out.println("....Limite: " +limite);
    }

    public boolean sacar(double valor){
        if(valor > this.saldo || valor < 0){
            return false;
        } else {
            this.saldo -= valor;
            this.saldo -= valor; {
                this.operacoes.add(new OperacaoSaque(valor));
                this.nOperacoes++;
            }
            return true;
        }
    }

    public boolean depositar(double valor) {
        if (valor < 0) {
            return false;
        } else {
            this.saldo += valor;
            this.operacoes.add(new OperacaoDeposito(valor));
            this.nOperacoes++;
        }
        return true;
    }

    public boolean transferir(Conta destino, double valor){

        if(this.sacar(valor)){
            destino.depositar(valor);
            return true;
        } else {
            return  false;
        }
    }

    public void extrato(int opcao) {
        int i;
        System.out.println("Extrato");
        for (Operacao operacao : this.operacoes) {
            System.out.println(operacao.getData()+"\t"+operacao.getTipo()+"\t"+operacao.getValor());
        }
    }

    public String toString(){
        return nome.toString() + "Dados do Cliente\t: " + "Número da conta: " + this.getNumConta() +"\nLimite: " +this.getLimite()
                + "\nSaldo: " +this.getSaldo() +"\nOperações realizadas: " +this.nOperacoes;
    }


    public boolean equals(Object obj){
        if(obj instanceof Conta){
            Conta conta = (Conta) obj;
            if(this.numConta == conta.numConta);
            return true;
        }else{
            return false;
        }
    }
    public double calculaTaxa(){
        return 0.0;
    }
    public void imprimirExtratoTaxas() {
        double anuidade, soma = 0;

        anuidade = this.calculaTaxa();
        System.out.println("------ TAXAS BANCARIAS ------");
        System.out.println("MANUTENÇÃO CONTA: R$ " + anuidade);

        double totalTaxas = this.calculaTaxa();
        for (Operacao operacao : this.operacoes) {
            if (operacao == null) {
                break;
            }
            double taxaOperacao = operacao.calculaTaxa();
            if(operacao.calculaTaxa() > 0) {
                if (operacao.getTipo() == 's') {
                    System.out.println("Saque: " + operacao.calculaTaxa());
                } else {
                    System.out.println("Deposito: " + operacao.calculaTaxa());
                }
            }
            totalTaxas += taxaOperacao;
        }
        System.out.printf("\nTotal: " + totalTaxas);
    }


    public int getNumConta() {
        return numConta;
    }

    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getLimite(){
        return limite;
    }

    public boolean setLimite(double maxLimite){
        this.limite = limite;
        return false;
    }

    public Cliente getNome() {
        return nome;
    }

    public void setNome(Cliente nome) {
        this.nome = nome;
    }

    public double getMinLimite() {
        return minLimite;
    }

    public void setMinLimite(double minLimite) {
        this.minLimite = minLimite;
    }

    public double getMaxLimite() {
        return maxLimite;
    }

    public void setMaxLimite(double maxLimite) {
        this.maxLimite = maxLimite;
    }
}