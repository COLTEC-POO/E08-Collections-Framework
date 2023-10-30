import java.util.List;
import java.util.ArrayList;

public abstract class ContaUniversitaria extends Conta {

    public ContaUniversitaria(String dono, String numeroConta, double saldoConta, double limiteConta) {
        super(dono, numeroConta, saldoConta, limiteConta);
    }

    public void setLimite(double limiteConta) {
        if (limiteConta < 500.0) {
            System.out.println("Erro! Limite mínimo: R$500,00");
        } else if (limiteConta < 0.0) {
            System.out.println("Erro! Limite mínimo: R$0,00");
        } else {
            this.limiteConta = limiteConta;
        }
    }

    public void imprimirExtrato() {
        List<Operacao> operacoesOrdenadas = new ArrayList<>(this.operacoes);

        System.out.println("Extrato da conta de " + this.getDono());
        for (Operacao operacao : operacoesOrdenadas) {
            System.out.println(operacao);
        }
    }

    public double calculaTaxas() {
        return 0.0;
    }
}
