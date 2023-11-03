import java.util.Scanner;

public class Exercicio16 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um ano: ");
        int ano = scanner.nextInt();

        boolean bissexto = verificarAnoBissexto(ano);

        if (bissexto) {
            System.out.println(ano + " é um ano bissexto.");
        } else {
            System.out.println(ano + " não é um ano bissexto.");
        }

        scanner.close();
    }

    public static boolean verificarAnoBissexto(int ano) {
        if (ano % 400 == 0) {
            return true;
        } else if (ano % 4 == 0 && ano % 100 != 0) {
            return true;
        } else {
            return false;
        }
    }
}
