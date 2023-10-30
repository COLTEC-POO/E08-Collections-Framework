import java.util.List;
import java.util.ArrayList;

public abstract class ContaPoupanca extends Conta {

    public ContaPoupanca(String dono, String numeroConta, double saldoConta, double limiteConta) {
        super(dono, numeroConta, saldoConta, limiteConta);
    }

    public void setLimite(double limiteConta) {
        if (limiteConta < 100.0) {
            System.out.println("Erro! Limite mínimo: R$100,00");
        }
        else if (limiteConta > 1000.0) {
            System.out.println("Erro! Limite máximo: R$1,000.00");
        }
        else {
            this.limiteConta = limiteConta;
        }
    }

    public double calculaTaxas() {
        return 0.0;
    }
}
