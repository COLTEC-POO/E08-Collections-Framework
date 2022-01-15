public class ContaCorrente extends Conta  {

    public void setLimite(int limite) {
        if (limite < -100) {
            throw new IllegalArgumentException("O limite não pode ser menor que -100!");
        }
    }
    public double calculaTaxas(){
        double Totaltaxas = 0;

        if (getMemoryCliente() instanceof PessoaFisica) {
            Totaltaxas= 10;
        }
        if (getMemoryCliente() instanceof PessoaJuridica) {
            Totaltaxas=20;
        }
        return Totaltaxas;
    }


}