import java.util.Scanner;

public class Exercicio09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Digite a quantidade de minutos: ");
        int minutos = scanner.nextInt();
        
        int horas = minutos / 60;
        int minutosRestantes = minutos % 60;
        
        System.out.println("Tempo: " + horas + " horas e " + minutosRestantes + " minutos");
        
        scanner.close();
    }
}
