package calculoRevestimento;

public abstract class Local {

    protected Float base, altura;

    public Local(Float base, Float altura) {
        this.base = base;
        this.altura = altura;
    }

    protected abstract Float calculaRevestiPiso(Float base, Float altura);

    protected Float calculaRevestiRodape(Float base, Float altura){
        return (base * 0.1f + altura * 0.1f) * 2;
    }
}
