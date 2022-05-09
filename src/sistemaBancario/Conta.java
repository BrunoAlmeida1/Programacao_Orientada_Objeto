package sistemaBancario;

public abstract class Conta {
    private String nmBanco = new String();
    private String nrAgencia = new String();
    private String nrConta = new String();
    Double saldo;

    protected Conta(String nmBanco, String nrAgencia, String nrConta, Double saldo) {
        this.nmBanco = nmBanco;
        this.nrAgencia = nrAgencia;
        this.nrConta = nrConta;
        this.saldo = saldo;
    }

    protected String getNmBanco() {
        return nmBanco;
    }

    protected void setNmBanco(String nmBanco) {
        this.nmBanco = nmBanco;
    }

    protected String getNrAgencia() {
        return nrAgencia;
    }

    protected void setNrAgencia(String nrAgencia) {
        this.nrAgencia = nrAgencia;
    }

    protected String getNrConta() {
        return nrConta;
    }

    protected void setNrConta(String nrConta) {
        this.nrConta = nrConta;
    }

    protected void depositar(Double vlDeposito){
        this.saldo += vlDeposito;
    }

    protected abstract Double getSaldo(int contaVisualizacao);

    protected abstract void sacar(double vlSaque);
}
