package modelaQuadrado;

public class Quadrado {
    protected Float lados;

    protected Quadrado(Float lados){
        this.lados = lados;
    }
    protected void setLados(Float lados) {
        this.lados = lados;
    }
    protected Float getLados() {
        return lados;
    }
    protected Double calculaArea(Float lados){
        return Math.pow(lados, 2);
    }
}

