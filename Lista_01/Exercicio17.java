import java.util.Scanner;

public class Exercicio17 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um número inteiro: ");
        int numero = scanner.nextInt();

        boolean divisivelPor3 = numero % 3 == 0;
        boolean divisivelPor5 = numero % 5 == 0;

        if ((divisivelPor3 || divisivelPor5) && !(divisivelPor3 && divisivelPor5)) {
            System.out.println(numero + " é divisível por 3 ou 5, mas não simultaneamente pelos dois.");
        } else {
            System.out.println(numero + " não atende às condições especificadas.");
        }

        scanner.close();
    }
}
