import java.util.Scanner;

public class Exercicio11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o primeiro valor inteiro: ");
        int a = scanner.nextInt();

        System.out.print("Digite o segundo valor inteiro: ");
        int b = scanner.nextInt();

        int diferenca = calcularDiferenca(a, b);

        System.out.println("Diferença: " + diferenca);

        scanner.close();
    }

    public static int calcularDiferenca(int a, int b) {
        if (a > b) {
            return a - b;
        } else {
            return b - a;
        }
    }
}
