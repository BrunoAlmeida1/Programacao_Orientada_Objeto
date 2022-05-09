package calculoRevestimento;

public class LocalQuadradoRetan extends Local{
    public LocalQuadradoRetan(Float base, Float altura) {
        super(base, altura);
    }

    protected Float calculaRevestiPiso(Float base, Float altura){
        return base * altura;
    }
}
