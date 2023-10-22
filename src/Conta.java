import java.util.ArrayList;
import java.util.Collections;
public class Conta {
    private static int totalContas = 0;

    public int numero;
    String senha;
    private double saldo;
    private String Dono;
    private double limite;
    private ArrayList<Operacao> operacoes;

    public Conta(int numero, String senha, double saldo,Cliente dono,double limite){

        this.numero = numero;
        this.senha = senha;
        this.saldo = saldo;
        this.Dono = Dono;
        this.limite = limite;
        operacoes = new ArrayList<>();
    }


    public boolean depositar(double valor) {
        if (valor >= 0) {
            this.saldo += valor;

            this.operacoes.add(new OperacaoDeposito(valor));

            return true;
        }
        else{
            return false;
        }
    }

    public boolean sacar(double valor){

        if(valor >= 0 && valor <= this.saldo) {
            this.saldo -= valor;

            this.operacoes.add(new OperacaoSaque(valor));

            return true;
        }
        else{
            return false;
        }
    }

    public boolean transferir(double valor, Conta destino){
        if(this.sacar(valor)){
            destino.depositar(valor);
            return true;
        }
        else{
            return false;
        }
    }

    public String toString() {
        String ContaStr = "ID: " + this.numero + "\n" +
                "" + this.Dono +
                "LIMITE: " + this.limite + "\n";

        return ContaStr;
    }



    public void imprimirExtrato() {
        System.out.println("Extrato: \n");

        for(Operacao operacaoAtual : this.operacoes){
            System.out.println(operacaoAtual.getData() + "\t" + operacaoAtual.getTipo() + "\t" + operacaoAtual.getValor());
        }

        System.out.println("\n");
        System.out.println("Extrato 2: ");
        System.out.println("\n");
        Collections.sort(operacoes);
        for(Operacao operacaoAtual : this.operacoes){
            System.out.println(operacaoAtual.getData() + "\t" + operacaoAtual.getTipo() + "\t" + operacaoAtual.getValor());
        }
    }


    public String getDono(){
        return this.Dono;
    }
    public void setDono(){
        Dono = Dono;
    }

    public int getNumero(){
        return this.numero;
    }
    public int setNumero(){
        return this.numero;
    }

    public double getSaldo(){
        return this.saldo;
    }

    public double getLimite(double limite){

        return this.limite;
    }

    public double setLimite(double limite){
        if(numero >= 0){
            this.limite = limite;
        }
        return this.limite = 0;
    }

    public static int getTotalContas(){
        return totalContas;
    }

}
