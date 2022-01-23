import java.util.ArrayList;

public abstract class Conta {

    //atributos da classe Conta
    protected Cliente dono;
    private String numero;//transformei em string para usar o equals

    private double saldo;

    private ArrayList <Operacao> operacoes=new ArrayList<>();//- ver tela do video tempo 39:40

    private double taxas;

    //variavel para controlar o indice do vetor de operações
    public int numeroOp;

    //numero de contas criadas durante a execução do sistema
    public static int totalContas=0;

    public int numSaques;//armazena o número de saques feito por essa conta

    //metodos da classe conta:
    //-construtor:
    //metodo para criar
    public Conta(Cliente dono,int numConta){
        this.saldo=0;
        this.numero="0";
        this.dono=dono;
        //this.operacoes=new Operacao[1000];
        this.operacoes=new ArrayList();
        numeroOp=0;
        Conta.totalContas++;
        this.numSaques=0;
        this.taxas=0;
    }

    //-getters e setters:
    public String getDono(){
        return dono.getNome();
    }

    public void setDono(String nome){
        dono.setNome(nome);
    }

    public String getNumero(){
        return this.numero;
    }

    public void setNumero(String numero){
        this.numero=numero;
    }

    public double getSaldo(){
        return this.saldo;
    }

    public ArrayList getOperacoes() {
        return operacoes;
    }

    public void setOperacoes(ArrayList operacoes) {
        this.operacoes = operacoes;
    }
    public double getTaxas() {
        return taxas;
    }
    public void setTaxas(double taxas) {
        this.taxas = taxas;
    }

    public abstract void setLimite(double limite);

    //-saque
    public boolean sacar(double valor){
        if(valor<=this.saldo){
            operacoes.add(new OperacaoSaque(valor));
            this.saldo-=valor;
            numeroOp++;
            numSaques++;
            return true;
        } else{
            return false;
        }
    }

    //- depositar
    public void depositar(double valor){
        operacoes.add(new OperacaoDeposito(valor));
        this.saldo=this.saldo+valor;
        numeroOp++;
    }

    public String toString(){
        String contaStr= "Número:"+this.numero+"\n"+
                "Nome:"+this.dono.getNome()+"\n"+
                "Saldo:"+this.saldo+"\n";
        return contaStr;
    }

    public boolean equals(Object obj){

        if(obj instanceof Conta){
            Conta objConta=(Conta)obj;
            if(this.numero.equals(objConta.numero)){
                return true;
            }
            else{
                return false;
            }
        }else{
            return false;
        }

    }

    public void imprimirExtratoTaxas(){
        System.out.println("===Extrato de Taxas===");
        System.out.println("Manutenção de Conta:"+getTaxas());
        for(int i=0;i<numSaques;i++){
            System.out.println("Saque:0.05");
        }
        double tot= (taxas+(numSaques*0.05));
        System.out.println("Total:"+tot);
    }

}
