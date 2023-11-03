import java.util.Scanner;

public class Exercicio24 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o dia da semana em que cai o primeiro dia do mês (1=Domingo, 2=Segunda, ..., 7=Sábado): ");
        int primeiroDiaSemana = scanner.nextInt();

        System.out.print("Digite o número de dias do mês: ");
        int numeroDias = scanner.nextInt();

        imprimirCalendario(primeiroDiaSemana, numeroDias);

        scanner.close();
    }

    public static void imprimirCalendario(int primeiroDiaSemana, int numeroDias) {
        // Array com os dias da semana
        String[] diasSemana = {"D", "S", "T", "Q", "Q", "S", "S"};

        // Imprimir cabeçalho com os dias da semana
        for (String dia : diasSemana) {
            System.out.print(dia + " ");
        }
        System.out.println();

        // Imprimir espaços em branco para ajustar o primeiro dia da semana
        for (int i = 1; i < primeiroDiaSemana; i++) {
            System.out.print("   ");
        }

        // Imprimir os dias do mês
        for (int dia = 1; dia <= numeroDias; dia++) {
            System.out.printf("%2d ", dia);

            // Quebrar a linha no sábado
            if ((primeiroDiaSemana + dia - 1) % 7 == 0) {
                System.out.println();
            }
        }
    }
}
