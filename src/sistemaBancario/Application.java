package sistemaBancario;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) throws InterruptedException {
        int opcao = -1, contaVisualizaSaldo = 0;
        Scanner sc = new Scanner(System.in);

        /* ContaPoupanca cp = new ContaPoupanca("B", "1", "2", 100d, 1, 0.005);
        System.out.println("Digite: ");
        cp.sacar(sc.nextDouble());
        System.out.println(cp.getSaldo()); */

       while (opcao != 0) {
            System.out.println("\n             ==== BANCO TABAJARA ====\n" +
                    "|   Qual tipo de conta voc� deseja movimentar?   |\n" +
                    "|                1 - Conta Corrente              |\n" +
                    "|                2 - Conta Poupan�a              |\n" +
                    "|------------------------------------------------|\n" +
                    "|                0 -     S A I R                 |\n" +
                    "   Digite o n�mero correspondente � op��o >>>>   ");

            opcao = sc.nextInt();

            out:
            switch (opcao) {
                case 1:
                    ContaCorrente cc = new ContaCorrente( "Tabajara","123",
                            "6969", 500, 1000);
                    int opcaoCC;
                    do {
                        System.out.println("\nConta Corrente\n" +
                                "-----------------\n" +
                                "  1 - Depositar  \n" +
                                "  2 - Sacar      \n" +
                                "  3 - Saldo      \n" +
                                "  0 - Sair       \n" +
                                "-----------------\n" +
                                "Digite o n�mero referente a sua op��o >>>");
                        opcaoCC = sc.nextInt();

                        switch (opcaoCC) {
                            case 1:
                                System.out.println("\nInforme o valor do deposito: ");
                                cc.depositar(sc.nextDouble());
                                System.out.println("\nDeposito realizado com sucesso!\n");
                                break;

                            case 2:
                                System.out.println("\nInforme o valor que deseja sacar: ");
                                cc.sacar(sc.nextDouble());
                                System.out.println("\nAguarde a sa�da do dinheiro" +
                                        "\n...\n");
                                Thread.sleep(2000);
                                System.out.println("Saque realizado!");
                                break;

                            case 3:
                                System.out.println("Seu saldo � de: " + cc.getSaldo(contaVisualizaSaldo));
                                break;

                            case 0:
                                break out;

                            default:
                                System.err.println("\nOp��o Inv�lida! Tente novamente\n");

                        }
                    } while (opcaoCC != 0);

                case 2:
                    ContaPoupanca cp = new ContaPoupanca("Tabajara", "123", "3210",
                            500.0, 18, 0.02);

                    int opcaoCP;
                    do {
                        System.out.println("\nConta Poupan�a\n" +
                                "-----------------\n" +
                                "  1 - Depositar  \n" +
                                "  2 - Sacar      \n" +
                                "  3 - Saldo      \n" +
                                "  0 - Sair       \n" +
                                "-----------------\n" +
                                "Digite o n�mero referente a sua op��o >>>");
                        opcaoCP = sc.nextInt();

                        switch (opcaoCP) {
                            case 1:
                                System.out.println("\nInforme o valor do deposito: ");
                                cp.depositar(sc.nextDouble());
                                System.out.println("\nDeposito realizado com sucesso!\n");
                                break;

                            case 2:
                                System.out.println("\nInforme o valor que deseja sacar: ");
                                cp.sacar(sc.nextDouble());
                                System.out.println("\nAguarde a sa�da do dinheiro" +
                                        "\n...\n");
                                Thread.sleep(2000);
                                System.out.println("Saque realizado!");
                                break;

                            case 3:
                                contaVisualizaSaldo++;
                                System.out.println("Seu saldo � de: " + cp.getSaldo(contaVisualizaSaldo));
                                break;

                            case 0:
                                break out;

                            default:
                                System.err.println("\nOp��o Inv�lida! Tente novamente\n");
                        }
                    } while (opcaoCP != 0);

                default:
                    System.err.println("\nOp��o Inv�lida! Digite 1, 2 ou 0\n");

            }
        }
        System.out.println("\n----- Obrigado por usar os servi�os do Banco Tabajara! -----\n");
    }
}
