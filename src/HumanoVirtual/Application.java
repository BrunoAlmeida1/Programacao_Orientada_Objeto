/*Programa que simula um humano no que tange o seu crescimento físico, seu envelhecimento,
aumento de peso e alimentação.
 */

package HumanoVirtual;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("\n==== HUMANO VIRTUAL ====\n");
        System.out.println("Preencha as informações abaixo\n");

        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("\nSexo: ");
        char sexo = sc.next().charAt(0);
        System.out.print("\nIdade: ");
        int idade = sc.nextInt();
        System.out.print("\nAltura: ");
        BigDecimal altura = new BigDecimal(sc.next());
        System.out.print("\nPeso: ");
        BigDecimal peso = new BigDecimal(sc.next());

        Pessoa pessoa = new Pessoa(nome, sexo, idade, altura, peso);

        char opcao;
        do {
            System.out.println("\n\nDeseja mudar algum aspecto do seu humano? S = sim / N = não");
            opcao = sc.next().charAt(0);

            if(Character.compare(opcao, 's') == 0 || Character.compare(opcao, 'S') == 0 ){
                System.out.println("\nEscolha uma das opções\n" +
                        "1 - Alterar a idade\n2 - Alterar a altura\n3 - Alterar o peso\n0 - Sair" +
                        "\nDigite o número da opção desejada >>> ");
                int opcao2 = sc.nextInt();

                switch (opcao2){
                    case 1:
                        pessoa.envelhecer();
                        break;
                    case 2:
                        pessoa.crescer(false, null);
                        break;
                    case 3:
                        pessoa.alterarPeso();
                        break;
                    case 0:
                        opcao = 'n';
                        break;
                    default:
                        System.err.println("\nOpção Inválida!\n");

                }
            }
            String genero = String.valueOf(sexo);
            idade = pessoa.idade;
            altura = pessoa.altura.setScale(0, RoundingMode.HALF_UP);
            peso = pessoa.peso.setScale(3, RoundingMode.HALF_UP);

            System.out.println("\n---- DADOS ATUALIZADOS ----\n");
            System.out.println("Nome: "+nome);
            System.out.println("Sexo: "+genero.toUpperCase());
            System.out.println("Idade: "+idade);
            System.out.println("Altura: "+altura.toPlainString());
            System.out.println("Peso: "+peso.toPlainString());
            System.out.println("---------------------------");

        }while (Character.compare(opcao, 's') == 0 || Character.compare(opcao, 'S') == 0 );

        System.out.println("\n---Obrigado por jogar o Humano Virtual---");
        sc.close();
    }
}
