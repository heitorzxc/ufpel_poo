public class Exercicio26 {
    public static void main(String[] args) {
        double alturaChico = 1.50;
        double alturaZe = 1.10;
        int anos = 0;

        while (alturaZe <= alturaChico) {
            alturaChico += 0.02; // Chico cresce 2 centímetros por ano
            alturaZe += 0.03; // Zé cresce 3 centímetros por ano
            anos++;
        }

        System.out.println("Serão necessários " + anos + " anos para que Zé seja maior que Chico.");
    }
}
