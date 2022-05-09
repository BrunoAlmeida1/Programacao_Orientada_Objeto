package sistemaBancario;

public class ContaPoupanca extends Conta{
    int diaAniversario;
    double juros;

    protected ContaPoupanca(String nmBanco, String nrAgencia, String nrConta, Double saldo, int diaAniversario,
                            double juros) {
        super(nmBanco, nrAgencia, nrConta, saldo);
        this.diaAniversario = diaAniversario;
        this.juros = juros;
    }

    @Override
    protected Double getSaldo(int contaVisualizaSaldo) {
        if(diaAniversario == 18 && contaVisualizaSaldo < 2) {
            saldo += (saldo * juros);
            return saldo;
        }
        else return saldo;
    }
    @Override
    protected void sacar(double vlSaque) {
        this.saldo -= vlSaque;
    }
}
