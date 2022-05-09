package HumanoVirtual;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Pessoa {

    String nome = new String();
    char sexo;
    Integer idade;
    BigDecimal peso;
    BigDecimal altura;

    protected Pessoa(String nome, char sexo, Integer idade, BigDecimal altura, BigDecimal peso) {
        this.nome = nome;
        this.sexo = sexo;
        this.idade = idade;
        this.altura = altura;
        this.peso = peso;
    }

    protected void envelhecer() {
        Scanner sc = new Scanner(System.in);
        BigDecimal anosAte21;
        BigDecimal anosAte11;
        BigDecimal alturaAtual = altura;

        System.out.println("\nInforme a nova idade: ");
        Integer novaIdade = sc.nextInt();

        if (idade > 10 && idade <= 21) {
            if (novaIdade > idade) {
                if (novaIdade > 21) {
                    int diferencaTo21 = novaIdade - 21;
                    anosAte21 = new BigDecimal(novaIdade - idade - diferencaTo21);
                    anosAte21 = anosAte21.multiply(BigDecimal.valueOf(4));
                    altura = altura.add(anosAte21);
                } else {
                    anosAte21 = new BigDecimal(novaIdade - idade);
                    anosAte21 = anosAte21.multiply(BigDecimal.valueOf(4));
                    altura = altura.add(anosAte21);
                }
            } else {
                anosAte21 = new BigDecimal(idade - novaIdade);
                anosAte21 = anosAte21.multiply(BigDecimal.valueOf(4));
                altura = altura.subtract(anosAte21);
            }
            idade = novaIdade;
            crescer(true, alturaAtual);
        } else if (idade <= 10) {
            if (novaIdade <= 11) {
                anosAte11 = new BigDecimal(novaIdade - idade);
                anosAte11 = anosAte11.multiply(BigDecimal.valueOf(2.5));
                altura = altura.add(anosAte11);
            } else if (novaIdade > 11 && novaIdade <= 21) {
                anosAte11 = BigDecimal.valueOf(11).subtract(BigDecimal.valueOf(idade));
                anosAte21 = BigDecimal.valueOf(novaIdade);
                anosAte21 = anosAte21.subtract(BigDecimal.valueOf(11));

                anosAte11 = anosAte11.multiply(BigDecimal.valueOf(2.5));
                anosAte21 = anosAte21.multiply(BigDecimal.valueOf(4));
                altura = altura.add(anosAte11);
                altura = altura.add(anosAte21);
            } else if (novaIdade > 11) {
                int diferencaTo21 = novaIdade - 21;
                anosAte21 = new BigDecimal(novaIdade - idade - diferencaTo21);
                anosAte11 = BigDecimal.valueOf(11).subtract(BigDecimal.valueOf(idade));
                anosAte21 = anosAte21.subtract(anosAte11);

                anosAte11 = anosAte11.multiply(BigDecimal.valueOf(2.5));
                anosAte21 = anosAte21.multiply(BigDecimal.valueOf(4));
                altura = altura.add(anosAte11);
                altura = altura.add(anosAte21);
            }
            idade = novaIdade;
            crescer(true, alturaAtual);
        }else{
            idade = novaIdade;
        }
    }

    protected void crescer(boolean cresceu, BigDecimal novaAltura) {
        Scanner sc = new Scanner(System.in);

        if (cresceu) {
            if (altura.compareTo(novaAltura) > 0) {
                novaAltura = altura.subtract(novaAltura);
                peso = peso.add(novaAltura.multiply(BigDecimal.valueOf(1.05)));
            } else {
                BigDecimal diferenca = altura.subtract(novaAltura);
                peso = peso.subtract(diferenca.multiply(BigDecimal.valueOf(1.05)));
            }

        } else {
            System.out.println("Informe a nova altura em centimetros: ");
            novaAltura = new BigDecimal(sc.nextInt());

            if (altura.compareTo(novaAltura) < 0) {
                BigDecimal diferenca = novaAltura.subtract(altura);
                peso = peso.add(diferenca.multiply(BigDecimal.valueOf(1.05)));
            } else {
                BigDecimal diferenca = altura.subtract(novaAltura);
                peso = peso.subtract(diferenca.multiply(BigDecimal.valueOf(1.05)));
            }
            altura = novaAltura;
        }
    }
    protected void alterarPeso() {
        Scanner sc = new Scanner(System.in);
        BigDecimal taxaMetabolismo = null;
        boolean notdefault = true;

        System.out.println("Qual a ingestão diária de calorias da pessoa? ");
        BigDecimal calorias = BigDecimal.valueOf(sc.nextInt());

        System.out.println("\nQual a taxa de atividade da pessoa? \n" +
                "1 - Sedentário (pouco ou nenhum exercício)\n" +
                "2 - Levemente ativo (exercício leve de 1 a 3 dias por semana)\n" +
                "3 - Moderadamente ativo (exercício moderado de 3 a 5 dias por semana\n" +
                "4 - Altamente ativo (exercício pesado de 5 a 6 dias por semana\n" +
                "5 - Extremamente ativo (exercício pesado diário e até 2 vezes ao dia\n" +
                "\n\nDIGITE O NÚMERO CORRESPONDENTE A ATIVIDADE >>>");
        int opcao = sc.nextInt();

        switch (opcao) {
            case 1:
                if (Character.compare(sexo, 'm') == 0 || Character.compare(sexo, 'M') == 0) {
                    taxaMetabolismo = ((BigDecimal.valueOf(13.7).multiply(peso)).add((BigDecimal.valueOf(5)
                            .multiply(altura))).subtract((BigDecimal.valueOf(6.8).multiply(BigDecimal.valueOf(idade)))))
                            .add(BigDecimal.valueOf(66));
                    taxaMetabolismo = taxaMetabolismo.multiply(BigDecimal.valueOf(1.2));
                } else if(Character.compare(sexo, 'f') == 0 || Character.compare(sexo, 'F') == 0) {
                    taxaMetabolismo = ((BigDecimal.valueOf(9.6).multiply(peso)).add((BigDecimal.valueOf(1.8)
                            .multiply(altura))).subtract((BigDecimal.valueOf(4.7).multiply(BigDecimal.valueOf(idade)))))
                            .add(BigDecimal.valueOf(655));
                    taxaMetabolismo = taxaMetabolismo.multiply(BigDecimal.valueOf(1.2));
                }else{
                    System.err.println("Caracter Inválido!");
                    notdefault = false;
                }
                break;
            case 2:
                if (Character.compare(sexo, 'm') == 0 || Character.compare(sexo, 'M') == 0) {
                    taxaMetabolismo = ((BigDecimal.valueOf(13.7).multiply(peso)).add((BigDecimal.valueOf(5)
                            .multiply(altura))).subtract((BigDecimal.valueOf(6.8).multiply(BigDecimal.valueOf(idade)))))
                            .add(BigDecimal.valueOf(66));
                    taxaMetabolismo = taxaMetabolismo.multiply(BigDecimal.valueOf(1.375));
                } else if (Character.compare(sexo, 'f') == 0 || Character.compare(sexo, 'F') == 0) {
                    taxaMetabolismo = ((BigDecimal.valueOf(9.6).multiply(peso)).add((BigDecimal.valueOf(1.8)
                            .multiply(altura))).subtract((BigDecimal.valueOf(4.7).multiply(BigDecimal.valueOf(idade)))))
                            .add(BigDecimal.valueOf(655));
                    taxaMetabolismo = taxaMetabolismo.multiply(BigDecimal.valueOf(1.375));
                }else{
                    System.err.println("Caracter Inválido!");
                    notdefault = false;
                }
                break;
            case 3:
                if (Character.compare(sexo, 'm') == 0 || Character.compare(sexo, 'M') == 0){
                    taxaMetabolismo = ((BigDecimal.valueOf(13.7).multiply(peso)).add((BigDecimal.valueOf(5)
                            .multiply(altura))).subtract((BigDecimal.valueOf(6.8).multiply(BigDecimal.valueOf(idade)))))
                            .add(BigDecimal.valueOf(66));
                    taxaMetabolismo = taxaMetabolismo.multiply(BigDecimal.valueOf(1.55));
                } else if (Character.compare(sexo, 'f') == 0 || Character.compare(sexo, 'F') == 0){
                    taxaMetabolismo = ((BigDecimal.valueOf(9.6).multiply(peso)).add((BigDecimal.valueOf(1.8)
                            .multiply(altura))).subtract((BigDecimal.valueOf(4.7).multiply(BigDecimal.valueOf(idade)))))
                            .add(BigDecimal.valueOf(655));
                    taxaMetabolismo = taxaMetabolismo.multiply(BigDecimal.valueOf(1.55));
                }else{
                    System.err.println("Caracter Inválido!");
                    notdefault = false;
                }
                break;
            case 4:
                if(Character.compare(sexo, 'm') == 0 || Character.compare(sexo, 'M') == 0){
                    taxaMetabolismo = ((BigDecimal.valueOf(13.7).multiply(peso)).add((BigDecimal.valueOf(5)
                            .multiply(altura))).subtract((BigDecimal.valueOf(6.8).multiply(BigDecimal.valueOf(idade)))))
                            .add(BigDecimal.valueOf(66));
                    taxaMetabolismo = taxaMetabolismo.multiply(BigDecimal.valueOf(1.725));
                } else if (Character.compare(sexo, 'f') == 0 || Character.compare(sexo, 'F') == 0) {
                    taxaMetabolismo = ((BigDecimal.valueOf(9.6).multiply(peso)).add((BigDecimal.valueOf(1.8)
                            .multiply(altura))).subtract((BigDecimal.valueOf(4.7).multiply(BigDecimal.valueOf(idade)))))
                            .add(BigDecimal.valueOf(655));
                    taxaMetabolismo = taxaMetabolismo.multiply(BigDecimal.valueOf(1.725));
                }else{
                    System.err.println("Caracter Inválido!");
                    notdefault = false;
                }
                break;
            case 5:
                if (Character.compare(sexo, 'm') == 0 || Character.compare(sexo, 'M') == 0) {
                    taxaMetabolismo = ((BigDecimal.valueOf(13.7).multiply(peso)).add((BigDecimal.valueOf(5)
                            .multiply(altura))).subtract((BigDecimal.valueOf(6.8).multiply(BigDecimal.valueOf(idade)))))
                            .add(BigDecimal.valueOf(66));
                    taxaMetabolismo = taxaMetabolismo.multiply(BigDecimal.valueOf(1.9));
                } else if (Character.compare(sexo, 'f') == 0 || Character.compare(sexo, 'F') == 0) {
                    taxaMetabolismo = ((BigDecimal.valueOf(9.6).multiply(peso)).add((BigDecimal.valueOf(1.8)
                            .multiply(altura))).subtract((BigDecimal.valueOf(4.7).multiply(BigDecimal.valueOf(idade)))))
                            .add(BigDecimal.valueOf(655));
                    taxaMetabolismo = taxaMetabolismo.multiply(BigDecimal.valueOf(1.9));
                }else{
                    System.err.println("Caracter Inválido!");
                    notdefault = false;
                }
                break;
            default:
                System.err.println("\nOpção Inválida!\n");
                notdefault = false;

        }
        System.out.println("\nTaxa Metabólica Basal: "+taxaMetabolismo);
        if(notdefault) {
            peso = peso.add(((calorias.subtract(taxaMetabolismo)))
                    .divide(BigDecimal.valueOf(9000), 2, RoundingMode.HALF_UP));
        }
    }
}
