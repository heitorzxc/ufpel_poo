import java.util.Scanner;

public class Exercicio29 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um número positivo: ");
        int numero = scanner.nextInt();

        System.out.println("Sequência Fibonacci até o primeiro número superior a " + numero + ":");

        int anterior = 0;
        int atual = 1;

        while (atual <= numero) {
            System.out.print(anterior + " ");

            int proximo = anterior + atual;
            anterior = atual;
            atual = proximo;
        }

        System.out.println();

        scanner.close();
    }
}
