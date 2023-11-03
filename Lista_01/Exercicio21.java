import java.util.Scanner;

public class Exercicio21 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um número inteiro positivo: ");
        int numero = scanner.nextInt();

        System.out.println(numero + " |");

        decomposicaoEmFatoresPrimos(numero);

        scanner.close();
    }

    public static void decomposicaoEmFatoresPrimos(int numero) {
        int fator = 2;

        while (numero > 1) {
            if (numero % fator == 0) {
                System.out.println(numero + " | " + fator);
                numero /= fator;
            } else {
                fator++;
            }
        }
    }
}
