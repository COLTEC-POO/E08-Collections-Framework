import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public abstract class Conta implements ITaxas{

    //Conteudo class conta

    private Cliente memoryCliente;
    private int memoryId;
    private double memorySaldo;
    private double memoryLimite;
    static int totalContas = 0;
    private int a;


    List<Operacao> operacoes;

    //-----------------------------------------------------------------------------------------------------//
    public Conta (){
        this.memoryId = -1;
        this.memoryCliente = null;
        this.memoryLimite = 0;
        this.memorySaldo = 0;

        this.operacoes = new ArrayList<>();

        totalContas++;
    }

    //-----------------------------------------------------------------------------------------------------//
    //Getters
    //-----------------------------------------------------------------------------------------------------//
    public int getMemoryId(){
        return this.memoryId;
    }

    public int getA(){
        return this.a;
    }

    public Cliente getMemoryCliente(){
        return this.memoryCliente;
    }

    public double getMemorySaldo(){
        return this.memorySaldo;
    }

    public double getMemoryLimite(){
        return this.memoryLimite;
    }

    //-----------------------------------------------------------------------------------------------------//
    //Setters
    //-----------------------------------------------------------------------------------------------------//
    public void setMemoryCliente(Cliente memoryCliente){
        this.memoryCliente = memoryCliente;
    }

    public void setMemoryId(int memoryId){
        this.memoryId = memoryId;
    }

    public void setA(int a){
        this.a = a;
    }

    public void setLimite(int limite) {
        if (limite < 0) {
            this.memoryLimite = 0;
        } else {
            this.memoryLimite = limite;
        }
    }



    //-----------------------------------------------------------------------------------------------------//
    //Métodos
    //-----------------------------------------------------------------------------------------------------//
    boolean sacar(double valor) {
        if (valor <= this.memorySaldo) {
            this.memorySaldo -= valor;
            this.operacoes.add(new OperacaoSaque(valor));
            return true;
        } else {
            return false;
        }
    }

    void depositar(double valor) {
        this.memorySaldo += valor;
        this.operacoes.add(new OperacaoDeposito(valor));
    }

    boolean transferir(Conta destino, double valor) {
        boolean saqueRealizado;
        saqueRealizado = this.sacar(valor);
        if (saqueRealizado) {
            destino.depositar(valor);
            return true;
        } else {
            return false;
        }
    }

    public boolean equals(Object obj){
        Conta that = (Conta) obj;

        return (this.memoryId == that.memoryId);
    }

    void imprimirExtrato (int a){
        if(a == 1){
            for(Operacao atual : this.operacoes)
                System.out.println(atual);
        }
        if(a == 2){
            Collections.sort(operacoes);
            for(Operacao atual : this.operacoes)
                System.out.println(atual);
        }
        else if((a >= 3) || (a <= 0)){
            throw new IllegalArgumentException("Error ao imprimir extrato: Escolha 1 para padrão ou 2 ordenados pelo seu tipo");

        }
    }

    void ImprimeTaxas(){
        System.out.println("Manutenção da Conta\t$:\t" + this.calculaTaxas());
        for(Operacao atual : this.operacoes)
            System.out.println(atual.getDataOperacao() + "\tTaxa paga por realizar essa operação:\t" + atual.calculaTaxas() + "\t"+ "Tipo:\t" + atual.getTipo() + "\t");
        }

    public String toString(){
        return String.format("%s \nID: %d\nSaldo: %f \nLimite: %f", this.memoryCliente.toString(), this.memoryId, this.memorySaldo, this.memoryLimite);
    }

    //-----------------------------------------------------------------------------------------------------//

}
