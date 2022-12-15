import java.util.Date;
import java.util.Collections;
import java.util.List;
import java.lang.Comparable;



/**
 * Classe responsável por registrar operações de saque e depósitos realizados em contas correntes.
 */
public abstract class Operacao implements ITaxas, Comparable<Operacao> {

    /* Data de realização da operação */
    private  Date data;

    /* Tipo da operação */
    private char tipo;

    /* Valor da operação */
    private double valor;
    public static int totalOperacoes = 0;

    public Date getData() {
        return data;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }


    public Operacao(char tipo, double valor) {
        this.tipo = tipo;
        this.valor = valor;
        data = new Date();

        Operacao.totalOperacoes++;
    }
    public String toString() {
        String operacao = "Operação inválida";

        return operacao;
    }
    public abstract double calculaTaxa();

    public void imprimirExtratoTaxas() {
        double taxa;

        taxa = this.calculaTaxa();
        System.out.println("....OPERAÇÃO: " + this.tipo);
        System.out.println("....DATA: " + this.data);
        System.out.println("....VALOR: " + this.valor);
        System.out.println("....TAXA: " + taxa);

    }

    public int compareTo(Operacao obj){
        if(this.getTipo() == 'd'&& obj.getTipo() == 's')
            return -1;

        if(this.getTipo() == 's'&& obj.getTipo() == 'd')
            return 1;

        return 0;
    }
}