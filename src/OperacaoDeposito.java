public class OperacaoDeposito extends Operacao implements ITaxas{

    public OperacaoDeposito(double valor) {
        super('d', valor);
    }

    @Override
    public double calcularTaxas() {
        return 0f;
    }

}
