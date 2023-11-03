import java.util.Scanner;

public class Exercicio18 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a distância percorrida em Km: ");
        double distancia = scanner.nextDouble();

        System.out.print("Digite a quantidade de litros de gasolina consumidos: ");
        double litros = scanner.nextDouble();

        double consumo = calcularConsumo(distancia, litros);

        System.out.println("Consumo: " + consumo + " Km/l");

        if (consumo < 8) {
            System.out.println("Venda o carro!");
        } else if (consumo >= 8 && consumo <= 14) {
            System.out.println("Econômico!");
        } else {
            System.out.println("Super econômico!");
        }

        scanner.close();
    }

    public static double calcularConsumo(double distancia, double litros) {
        return distancia / litros;
    }
}
