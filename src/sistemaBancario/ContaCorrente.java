package sistemaBancario;

public class ContaCorrente extends Conta{
    double chequeEspecial;

    protected ContaCorrente(String nmBanco, String nrAgencia, String nrConta, double saldo, double chequeEspecial) {
        super(nmBanco, nrAgencia, nrConta, saldo);
        this.chequeEspecial = chequeEspecial;
    }

    @Override
    protected Double getSaldo(int contador) {
        return saldo + chequeEspecial;
    }
    @Override
    protected void sacar(double vlSaque){
        this.saldo -= (vlSaque + 2.50);
    }
}
