import java.util.Scanner;

public class Exercicio20 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um inteiro n: ");
        int n = scanner.nextInt();

        double soma = calcularSoma(n);

        System.out.println("Valor da soma: " + soma);

        scanner.close();
    }

    public static double calcularSoma(int n) {
        double soma = 0.0;

        for (int i = 1; i <= n; i++) {
            soma += 1.0 / (i * i);
        }

        return soma;
    }
}
