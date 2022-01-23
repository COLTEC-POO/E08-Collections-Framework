import java.util.ArrayList;
import java.util.Date;
import java.util.Collections;

/**
 * Classe responsável por registrar operações de saque e depósitos realizados em contas correntes.
 */
public abstract class Operacao {

    /* Valor da operação */
    private double valor;

    /* Data de realização da operação */
    private Date data;

    private char tipo;

    public Operacao() {
        this.valor = valor;
        this.tipo= 'n';
        data = new Date();
    }

    //metodos
    //-getters e setters:
    public Date getData(){
        return this.data;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor){
        this.valor=valor;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }


    /*//-imprimirExtrato() - padrão:ordenado por data
    public static void extrato(Conta conta){
        ArrayList <Operacao>extratoconta=conta.getOperacoes();//recebe o array da conta e guarda em uma variavel para manipular
        System.out.println("====Extrato de Operações de: "+ conta.getDono()+" ====");
        for(Operacao var: extratoconta){
            System.out.println(var.data+" "+var.tipo+" "+var.valor);

        }

    }*/

    //-imprimirExtrato(int)`- padrão:ordenado ordenados pelo seu tipo (primeiro os depósitos, depois os saques).

    /*public static void imprimirExtrato(int){
        System.out.println("Extrato: "+ conta.getDono());
        ArrayList <Operacao>extratoconta=conta.getOperacoes();//recebe o array da conta e guarda em uma variavel para manipular

        for(Operacao var: extratoconta){
            System.out.println(var.data+" "+var.tipo+" "+var.valor);

        }

    }*/


}
