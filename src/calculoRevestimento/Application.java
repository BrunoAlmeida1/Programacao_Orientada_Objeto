package calculoRevestimento;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        int opcao = -1;
        float base, altura, ladoDireito, ladoEsquerdo;
        float piso, rodape;

        Scanner sc = new Scanner(System.in);

        while (opcao != 0) {
            System.out.println("\n           ==== CÁLCULADORA DE REVESTIMENTO ====\n" +
                    "\n       |        1 - Área quadrada ou retangular   |" +
                    "\n       |        2 - Área triangular               |" +
                    "\n       |        -------------------------------   |" +
                    "\n       |        0 -        S A I R                |" + "\n" +
                    "\n      Informe a opção que se encaixa com o seu local >>>>");

            opcao = sc.nextInt();

            switch (opcao){
                case 1:
                    System.out.println("\nInforme o comprimeto: ");
                    base = sc.nextFloat();
                    System.out.println("\nInforme a largura: ");
                    altura = sc.nextFloat();

                    LocalQuadradoRetan localQuad = new LocalQuadradoRetan(base, altura);
                    piso = localQuad.calculaRevestiPiso(base, altura);
                    rodape = localQuad.calculaRevestiRodape(base, altura);

                    System.out.printf("\nO local precisará de %.2fm de revestimento para o piso\n" +
                            "e %.2fm de revestimento para o rodapé\n", piso, rodape);
                    break;

                case 2:
                    System.out.println("\nInforme a base: ");
                    base = sc.nextFloat();
                    System.out.println("\nInforme a altura: ");
                    altura = sc.nextFloat();
                    System.out.println("\nInforme o tamanho do lado direito: ");
                    ladoDireito = sc.nextFloat();
                    System.out.println("\nInforme o tamanho do lado esquerdo: ");
                    ladoEsquerdo = sc.nextFloat();

                    LocalTriangular localTrian = new LocalTriangular(base, altura, ladoDireito, ladoEsquerdo);
                    piso = localTrian.calculaRevestiPiso(base, altura);
                    rodape = localTrian.calculaRevestiRodape(base, ladoDireito, ladoEsquerdo);

                    System.out.printf("\nO local precisará de %.2fm de revestimento para o piso\n" +
                            "e %.2fm de revestimento para o rodapé\n", piso, rodape);
                    break;

                case 0:
                    break;

                default:
                    System.err.println("\nOpção Inválida! Digite 1, 2, 0\n");
            }
        }
        System.out.println("\nObrigado por usar nossa calculadora de revestimento\n");

    }
}
