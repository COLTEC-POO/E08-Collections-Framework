import java.util.Date;
public abstract class Operacao implements ITaxas {
    protected double valor;
    protected Date data;
    protected char tipo;
    private static int totalOperacoes = 0;

    public Operacao(char tipo, double valor) {
        this.tipo = tipo;
        this.valor = valor;
        data = new Date();
        totalOperacoes += 1;
    }

    public abstract char getTipo();
    public void setTipo(char tipo){
        if(tipo == 'd'){
            this.tipo = 'd';
        }
        else if(tipo == 's'){
            this.tipo = 's';
        }
    }

    public double getValor() {
        return this.valor;
    }
    public Date getData() {
        return this.data;
    }
    public void setData(){
        this.data = new Date();
    }
    public static double getTotalOperacoes() {
        return Operacao.totalOperacoes;
    }

    public void imprimirExtrato(Operacao operacoes){
        System.out.println(operacoes.getData() + " " + operacoes.getTipo() + " " + operacoes.getValor() );
    }

    public String toString(){
        return this.getData() + "  \t " + this.getTipo() + "  \t " + this.getValor();
    }

    public int compareTo(Operacao outraOperacao){
        return this.data.compareTo(outraOperacao.data);
    }

}
