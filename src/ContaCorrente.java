public class ContaCorrente extends Conta implements ITaxas {

    public ContaCorrente(int numero, String senha, double saldo, Cliente dono, double limite) {

        super(numero, senha, saldo, dono, limite);

    }

    public void setLimite(){

        if(this.limite >= -100){
            this.limite = limite;
            System.out.println("Limite da Conta Corrente permitido!");

        } else {
            System.out.println("Erro, limite da Conta Corrente inferior ao permitido.");
        }

    }

    public double calculaTaxas(){

        if(this.getDono() instanceof PessoaFisica){
            return 10.0;
        }
        else if(this.getDono() instanceof PessoaJuridica){
            return 20.0;
        } else{
            System.out.println("Nao esta relacionada a classes Pessoa Fisica OU Juridica.");
            return 0.0;

        }
    }

    public double calculaTaxasOperacao(){
        return 0.0;
    }
}
