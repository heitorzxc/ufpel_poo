import java.util.Scanner;

public class Exercicio25 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int opcao;

        do {
            exibirMenu();
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    converterKmParaMs();
                    break;
                case 2:
                    converterMsParaKm();
                    break;
                case 3:
                    System.out.println("Programa finalizado.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }

            System.out.println();
        } while (opcao != 3);

        scanner.close();
    }

    public static void exibirMenu() {
        System.out.println("Escolha uma opção:");
        System.out.println("1. Converter de km/h para m/s");
        System.out.println("2. Converter de m/s para km/h");
        System.out.println("3. Finalizar programa");
        System.out.print("Opção: ");
    }

    public static void converterKmParaMs() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a velocidade em km/h: ");
        double kmh = scanner.nextDouble();

        double ms = kmh / 3.6;

        System.out.println("Velocidade em m/s: " + ms);

        scanner.close();
    }

    public static void converterMsParaKm() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a velocidade em m/s: ");
        double ms = scanner.nextDouble();

        double kmh = ms * 3.6;

        System.out.println("Velocidade em km/h: " + kmh);

        scanner.close();
    }
}
