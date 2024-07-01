
public class ContaCorrente extends Conta{
    public ContaCorrente(int numero, Cliente dono, double saldo, double limite){
        super(numero,dono,saldo,limite);
        this.setLimite(limite);
    }
    @Override
    public void setLimite(double limite) {
        if (limite < -100)
            limite = -100;
        this.limite = limite;
    }
    @Override
    public double calculaTaxas(){
        return this.dono.calculaTaxas();
    }
}



