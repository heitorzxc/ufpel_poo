import java.util.Scanner;

public class Exercicio08 {
    public static void main(String[] args) {
        int[] valores = new int[5];
        lerValores(valores);
        
        int soma = calcularSoma(valores);
        double media = calcularMedia(valores);
        int maximo = encontrarMaximo(valores);
        int minimo = encontrarMinimo(valores);
        
        System.out.println("Soma: " + soma);
        System.out.println("Média: " + media);
        System.out.println("Máximo: " + maximo);
        System.out.println("Mínimo: " + minimo);
    }
    
    public static void lerValores(int[] valores) {
        Scanner scanner = new Scanner(System.in);
        
        for (int i = 0; i < valores.length; i++) {
            System.out.print("Digite o valor " + (i+1) + ": ");
            valores[i] = scanner.nextInt();
        }
        
        scanner.close();
    }
    
    public static int calcularSoma(int[] valores) {
        int soma = 0;
        
        for (int valor : valores) {
            soma += valor;
        }
        
        return soma;
    }
    
    public static double calcularMedia(int[] valores) {
        int soma = calcularSoma(valores);
        return (double) soma / valores.length;
    }
    
    public static int encontrarMaximo(int[] valores) {
        int maximo = Integer.MIN_VALUE;
        
        for (int valor : valores) {
            if (valor > maximo) {
                maximo = valor;
            }
        }
        
        return maximo;
    }
    
    public static int encontrarMinimo(int[] valores) {
        int minimo = Integer.MAX_VALUE;
        
        for (int valor : valores) {
            if (valor < minimo) {
                minimo = valor;
            }
        }
        
        return minimo;
    }
}
