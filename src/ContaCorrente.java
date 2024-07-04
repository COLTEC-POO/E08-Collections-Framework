
public class ContaCorrente extends Conta{

    public ContaCorrente(int numero, Cliente dono, double saldo, double limiteMin, double limiteMax){
        super(numero, dono, saldo, limiteMin, limiteMax);
        setLimite();
    }

    @Override //Conta()
    void setLimite() {
        if (limiteMin < -100) limiteMin = -100;
    }

    @Override //ITaxas()
    public double calculaTaxas(){
        return this.dono.getClass() == PessoaFisica.class ? 10:20;
    }

}