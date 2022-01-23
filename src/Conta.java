import java.util.List;
import java.util.ArrayList;

public abstract class Conta implements ITaxas {

    //atributos da classe Conta
    protected Cliente dono;
    private String numero;//transformei em string para usar o equals

    private double saldo;

    private List<Operacao> operacoes;//- ver tela do video tempo 39:40

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
        this.operacoes=new ArrayList<>();
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

    public ArrayList<Operacao> getOperacoes() {
        return (ArrayList<Operacao>) operacoes;
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

     //-imprimirExtrato() - padrão:ordenado por data
    public void extrato(){
        System.out.println("====Extrato de Operações ====");
        for(Operacao atual: this.operacoes){
            System.out.println(atual.getData()+" "+atual.getTipo()+" "+atual.getValor());
        }
    }

    public void imprimirExtratoTaxas(){
        double totalTaxas=this.calculaTaxas();
        System.out.println("===Extrato de Taxas===");
        System.out.println();
        System.out.println("Manutenção de Conta:"+this.calculaTaxas());
        System.out.println();
        System.out.println("Operações:");
        for(Operacao atual:this.operacoes){
            if(atual instanceof OperacaoSaque){
                totalTaxas+=((OperacaoSaque) atual).calculaTaxas();
                System.out.println("Saque:"+((OperacaoSaque) atual).calculaTaxas());
            }
        }
        System.out.println("Saque:"+totalTaxas);
    }

}
