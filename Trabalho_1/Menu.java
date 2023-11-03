import java.util.Scanner;
import java.util.List;

public class Menu {
    
    private static Bloco bloco = new Bloco();
    private static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;
        do {
            exibirMenu();
            opcao = entrada.nextInt();
            entrada.nextLine();
            // Consome o buffer, mesmo problema que a gente tinha no C.
            
            switch (opcao) {
                case 1:
                    novoLembrete();
                    break;
                case 2:
                    excluirLembrete();
                    break;
                case 3:
                    buscaPorPalavra();
                    break;
                case 4:
                    buscaPorMes();
                    break;
                case 5:
                    buscaPorDia();
                    break;
                case 6:
                    imprimeTodos();
                    break;
                case 7:
                    imprimePorMes();
                    break;
                case 8:
                    imprimePorDia();
                    break;
                case 0:
                    System.out.println("Até logo!");
                    break;
                default:
                    System.out.println("Erro! Opção inválida!");
            }
        } while (opcao != 0);
    }
    
    private static void exibirMenu() {
        System.out.println("\nMenu:");
        System.out.println("1 -> Inserir lembrete");
        System.out.println("2 -> Excluir lembrete");
        System.out.println("3 -> Buscar lembrete por palavra");
        System.out.println("4 -> Buscar lembrete por mês");
        System.out.println("5 -> Buscar lembrete por dia");
        System.out.println("6 -> Imprimir todos os lembretes");
        System.out.println("7 -> Imprimir lembretes por mês");
        System.out.println("8 -> Imprimir lembretes por dia");
        System.out.println("0 -> Sair");
        System.out.println("Digite sua opção:");
        System.out.print("> ");
    }
    
    private static void novoLembrete() {
        System.out.print("O que você lembrar? ");
        String descricao = entrada.nextLine();
        System.out.println("Qual dia? (Número): ");
        System.out.print("> ");
        int dia = entrada.nextInt();
        System.out.println("Qual mês? (Número) ");
        System.out.print("> ");        
        int mes = entrada.nextInt();
        System.out.println("Qual ano? (Número) ");
        System.out.print("> ");        
        int ano = entrada.nextInt();
        Data data = new Data(dia, mes, ano);
        Lembrete lembrete = new Lembrete(descricao, data);
        bloco.inserir(lembrete);
        System.out.println("Feito! Retornando!");
    }
    
    private static void excluirLembrete() {
        System.out.print("Digite o ID (número): ");
        int indice = entrada.nextInt();
        bloco.remover(indice);
        System.out.println("Lembrete removido!");
    }
    
    private static void buscaPorPalavra() {
        System.out.print("Digite a palavra de busca: ");
        String substring = entrada.nextLine();
        List<Lembrete> resultados = bloco.buscarPorPalavra(substring);
        for (Lembrete l : resultados) {
            System.out.println(l);
        }
    }
    
    private static void buscaPorMes() {
        System.out.print("Digite o mês de busca (1-12): ");
        int mes = entrada.nextInt();
        List<Lembrete> resultados = bloco.buscarPorMes(mes);
        for (Lembrete l : resultados) {
            System.out.println(l);
        }
    }
    
    private static void buscaPorDia() {
        System.out.print("Digite o dia de busca (1-31): ");
        int dia = entrada.nextInt();
        List<Lembrete> resultados = bloco.buscarPorDia(dia);
        for (Lembrete l : resultados) {
            System.out.println(l);
        }
    }
    
    private static void imprimeTodos() {
        for (Lembrete l : bloco.buscarTodos()) {
            System.out.println(l);
        }
    }
    
    private static void imprimePorMes() {
        System.out.print("Digite o mês de busca (1-12): ");
        int mes = entrada.nextInt();
        List<Lembrete> resultados = bloco.buscarPorMes(mes);
        resultados.sort(null);
        for (Lembrete l : resultados) {
            System.out.println(l);
        }
    }
    
    private static void imprimePorDia() {
        System.out.print("Digite o dia de busca (1-31): ");
        int dia = entrada.nextInt();
        List<Lembrete> resultados = bloco.buscarPorDia(dia);
        resultados.sort(null);
        for (Lembrete l : resultados) {
            System.out.println(l);
        }
    }
}