import java.util.Scanner;

public class Exercicio22 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um número inteiro (até 10.000): ");
        int numero = scanner.nextInt();

        contarDigitos(numero);

        scanner.close();
    }

    public static void contarDigitos(int numero) {
        int[] contagem = new int[10];

        while (numero > 0) {
            int digito = numero % 10;
            contagem[digito]++;
            numero /= 10;
        }

        for (int i = 0; i < contagem.length; i++) {
            if (contagem[i] > 0) {
                System.out.println(i + ": " + contagem[i] + " vez(es)");
            }
        }
    }
}
