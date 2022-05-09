package calculoRevestimento;

public class LocalTriangular extends Local{
    protected Float ladoB, ladoC;

    public LocalTriangular(Float base, Float altura, Float ladoB, Float ladoC) {
        super(base, altura);
        this.ladoB = ladoB;
        this.ladoC = ladoC;
    }


    protected Float calculaRevestiPiso(Float base, Float altura){
        return base * altura;
    }
    protected Float calculaRevestiRodape(Float base, Float ladoB, Float ladoC){
        return (base * 0.1f + ladoB * 0.1f + ladoC * 0.1f);
    }
}
