import java.util.Scanner;

public class Exercicio28 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o valor de a: ");
        int a = scanner.nextInt();

        System.out.print("Digite o valor de b: ");
        int b = scanner.nextInt();

        int somaPrimos = somarNumerosPrimos(a, b);

        System.out.println("A soma dos números primos entre " + a + " e " + b + " é: " + somaPrimos);

        scanner.close();
    }

    public static int somarNumerosPrimos(int a, int b) {
        int soma = 0;

        for (int numero = a; numero <= b; numero++) {
            if (ehPrimo(numero)) {
                soma += numero;
            }
        }

        return soma;
    }

    public static boolean ehPrimo(int numero) {
        if (numero <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) {
                return false;
            }
        }

        return true;
    }
}
