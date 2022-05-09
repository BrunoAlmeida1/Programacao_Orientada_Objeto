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
                    "|   Qual tipo de conta você deseja movimentar?   |\n" +
                    "|                1 - Conta Corrente              |\n" +
                    "|                2 - Conta Poupança              |\n" +
                    "|------------------------------------------------|\n" +
                    "|                0 -     S A I R                 |\n" +
                    "   Digite o número correspondente à opção >>>>   ");

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
                                "Digite o número referente a sua opção >>>");
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
                                System.out.println("\nAguarde a saída do dinheiro" +
                                        "\n...\n");
                                Thread.sleep(2000);
                                System.out.println("Saque realizado!");
                                break;

                            case 3:
                                System.out.println("Seu saldo é de: " + cc.getSaldo(contaVisualizaSaldo));
                                break;

                            case 0:
                                break out;

                            default:
                                System.err.println("\nOpção Inválida! Tente novamente\n");

                        }
                    } while (opcaoCC != 0);

                case 2:
                    ContaPoupanca cp = new ContaPoupanca("Tabajara", "123", "3210",
                            500.0, 18, 0.02);

                    int opcaoCP;
                    do {
                        System.out.println("\nConta Poupança\n" +
                                "-----------------\n" +
                                "  1 - Depositar  \n" +
                                "  2 - Sacar      \n" +
                                "  3 - Saldo      \n" +
                                "  0 - Sair       \n" +
                                "-----------------\n" +
                                "Digite o número referente a sua opção >>>");
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
                                System.out.println("\nAguarde a saída do dinheiro" +
                                        "\n...\n");
                                Thread.sleep(2000);
                                System.out.println("Saque realizado!");
                                break;

                            case 3:
                                contaVisualizaSaldo++;
                                System.out.println("Seu saldo é de: " + cp.getSaldo(contaVisualizaSaldo));
                                break;

                            case 0:
                                break out;

                            default:
                                System.err.println("\nOpção Inválida! Tente novamente\n");
                        }
                    } while (opcaoCP != 0);

                default:
                    System.err.println("\nOpção Inválida! Digite 1, 2 ou 0\n");

            }
        }
        System.out.println("\n----- Obrigado por usar os serviços do Banco Tabajara! -----\n");
    }
}
