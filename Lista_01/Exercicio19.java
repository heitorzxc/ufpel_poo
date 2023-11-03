import java.util.Scanner;

public class Exercicio19 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numero;
        int soma = 0;
        int quantidade = 0;
        int quantidadePositivos = 0;
        int quantidadeNegativos = 0;
        int quantidadePares = 0;
        int maior = Integer.MIN_VALUE;
        int menor = Integer.MAX_VALUE;
        int somaPares = 0;

        System.out.println("Digite os números (para encerrar, digite -1):");

        while (true) {
            numero = scanner.nextInt();

            if (numero == -1) {
                break;
            }

            soma += numero;
            quantidade++;

            if (numero > 0) {
                quantidadePositivos++;
            } else if (numero < 0) {
                quantidadeNegativos++;
            }

            if (numero % 2 == 0) {
                quantidadePares++;
                somaPares += numero;
            }

            if (numero > maior) {
                maior = numero;
            }

            if (numero < menor) {
                menor = numero;
            }
        }

        double media = (double) soma / quantidade;
        double percentualPositivos = (double) quantidadePositivos / quantidade * 100;
        double percentualNegativos = (double) quantidadeNegativos / quantidade * 100;
        double mediaPares = (double) somaPares / quantidadePares;

        System.out.println("Soma dos números digitados: " + soma);
        System.out.println("Quantidade de números digitados: " + quantidade);
        System.out.println("Média dos números digitados: " + media);
        System.out.println("Percentual de números positivos: " + percentualPositivos + "%");
        System.out.println("Percentual de números negativos: " + percentualNegativos + "%");
        System.out.println("Maior número digitado: " + maior);
        System.out.println("Menor número digitado: " + menor);
        System.out.println("Média dos números pares: " + mediaPares);

        scanner.close();
    }
}
