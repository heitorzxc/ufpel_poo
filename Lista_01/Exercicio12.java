import java.util.Scanner;

public class Exercicio12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o primeiro valor inteiro: ");
        int x = scanner.nextInt();

        System.out.print("Digite o segundo valor inteiro: ");
        int y = scanner.nextInt();

        if (ehMultiplo(x, y)) {
            System.out.println(x + " é múltiplo de " + y);
        } else {
            System.out.println(x + " não é múltiplo de " + y);
        }

        scanner.close();
    }

    public static boolean ehMultiplo(int x, int y) {
        return x % y == 0;
    }
}
