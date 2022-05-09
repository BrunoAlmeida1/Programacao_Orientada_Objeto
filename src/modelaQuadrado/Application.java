package modelaQuadrado;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        float lado = -1;
        double area;

        System.out.println("==== C�LCULO DA �REA DO QUADRADO ====\n");

        Scanner sc = new Scanner(System.in);

        Quadrado quad = new Quadrado(lado);
        do {
            System.out.println("Digite o valor dos lados do quadrado ou 0(zero) para sair >>>> ");
            lado = sc.nextFloat();

            if (lado != 0) {
                area = quad.calculaArea(lado);

                System.out.printf("\nA �rea de um quadrado de lados %.2f �: %.2f", lado, area);
                System.out.println("\n-------------------------------------------\n");
            }
        } while (lado != 0);

        float ultimoLado = quad.getLados();
        area = quad.calculaArea(ultimoLado);

        System.out.printf("�ltimo lado digitado: %.2f", ultimoLado);
        System.out.printf("\n�ltima �rea calculada: %.2f", area);


    }


}
