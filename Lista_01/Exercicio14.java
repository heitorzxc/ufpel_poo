import java.util.Scanner;

public class Exercicio14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o valor em R$ a ser dividido: ");
        double valorTotal = scanner.nextDouble();

        double primeiraParte = valorTotal * 0.46;
        double segundaParte = valorTotal * 0.32;
        double terceiraParte = valorTotal - primeiraParte - segundaParte;

        System.out.println("Primeiro ganhador: R$" + primeiraParte);
        System.out.println("Segundo ganhador: R$" + segundaParte);
        System.out.println("Terceiro ganhador: R$" + terceiraParte);

        scanner.close();
    }
}
