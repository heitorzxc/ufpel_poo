import java.util.Scanner;

public class Exercicio23 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um valor N (> 0): ");
        int n = scanner.nextInt();

        gerarQuadrado(n);

        scanner.close();
    }

    public static void gerarQuadrado(int n) {
        char[][] quadrado = new char[n][n];

        // Preencher o quadrado com '.'
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                quadrado[i][j] = '.';
            }
        }

        // Preencher a diagonal principal com '*'
        for (int i = 0; i < n; i++) {
            quadrado[i][i] = '*';
        }

        // Imprimir o quadrado
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(quadrado[i][j]);
            }
            System.out.println();
        }
    }
}
