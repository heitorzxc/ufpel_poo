import java.util.Scanner;

public class Exercicio15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numeroLido;

        do {
            System.out.print("Digite um número inteiro, positivo de três dígitos: ");
            numeroLido = scanner.nextInt();
        } while (numeroLido < 100 || numeroLido > 999);

        int numeroGerado = inverterNumero(numeroLido);

        System.out.println("Número Gerado: " + numeroGerado);

        scanner.close();
    }

    public static int inverterNumero(int numero) {
        int centena = numero / 100;
        int dezena = (numero % 100) / 10;
        int unidade = numero % 10;

        return (unidade * 100) + (dezena * 10) + centena;
    }
}
