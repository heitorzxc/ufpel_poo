import java.util.Scanner;

public class Exercicio27 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o valor do saque: ");
        int valorSaque = scanner.nextInt();

        int notas100 = valorSaque / 100;
        valorSaque %= 100;

        int notas50 = valorSaque / 50;
        valorSaque %= 50;

        int notas20 = valorSaque / 20;
        valorSaque %= 20;

        int notas10 = valorSaque / 10;
        valorSaque %= 10;

        int notas5 = valorSaque / 5;
        valorSaque %= 5;

        int notas2 = valorSaque / 2;
        valorSaque %= 2;

        int notas1 = valorSaque;

        System.out.println("Quantidade de notas necessárias:");
        System.out.println("Notas de 100: " + notas100);
        System.out.println("Notas de 50: " + notas50);
        System.out.println("Notas de 20: " + notas20);
        System.out.println("Notas de 10: " + notas10);
        System.out.println("Notas de 5: " + notas5);
        System.out.println("Notas de 2: " + notas2);
        System.out.println("Notas de 1: " + notas1);

        scanner.close();
    }
}
