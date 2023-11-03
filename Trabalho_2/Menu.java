package LembretesApp;

import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class Menu {
    
    private static AnotacoesApp bloco = new AnotacoesApp();

    private static final Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;
        do {
            exibirMenu();
            opcao = entrada.nextInt();
            entrada.nextLine(); // Consome o buffer, mesmo problema que a gente tinha no C.
            
            switch (opcao) {
                case 1:
                    inserirNovaAnotacao();
                    break;
                case 2:
                    editarAnotacaoExistente();
                    break;
                case 3:
                    excluirAnotacao();
                    break;
                case 4:
                    listarTodasAnotacoes();
                    break;
                case 5:
                    buscarAnotacaoPorMes();
                    break;
                case 6:
                    buscarAnotacaoPorDia();
                    break;
                case 7:
                    ordenarAnotacoesPorData();
                    break;
                case 8:
                    ordenarAnotacoesPorTitulo();
                    break;
                case 9:
                    System.out.println("Até logo!");
                    System.exit(0);                  
                default:
                    System.out.println("Erro! Opção inválida!");
            }
        } while (true);
    }
    
    private static void exibirMenu() {
        System.out.println("\nMenu:");
        System.out.println("1 -> Inserir nova anotação");
        System.out.println("2 -> Editar uma anotação existente");
        System.out.println("3 -> Excluir uma anotação");
        System.out.println("4 -> Listar todas as anotações");
        System.out.println("5 -> Buscar anotações por mês");
        System.out.println("6 -> Buscar anotações por dia");
        System.out.println("7 -> Ordenar anotações por data");
        System.out.println("8 -> Ordenar anotações por título");
        System.out.println("9 -> Sair");
    }
    
    private static void inserirNovaAnotacao() {
        System.out.print("Digite o dia (1-31): ");
        int dia = entrada.nextInt();
        entrada.nextLine(); // Consumir a nova linha

        System.out.print("Digite o mês (1-12): ");
        int mes = entrada.nextInt();
        entrada.nextLine(); // Consumir a nova linha

        System.out.print("Digite o ano: ");
        int ano = entrada.nextInt();
        entrada.nextLine(); // Consumir a nova linha

        System.out.print("Digite o título da anotação: ");
        String titulo = entrada.nextLine();

        System.out.print("Digite a descrição da anotação: ");
        String descricao = entrada.nextLine();

        Calendar data = Calendar.getInstance();
        data.set(ano, mes - 1, dia);
        Anotacao novaAnotacao = new Anotacao(data, titulo, descricao);
        bloco.adicionarAnotacao(novaAnotacao);

        System.out.println("Anotação inserida com sucesso!");
    }
    
    private static void editarAnotacaoExistente() {
        // Lista todas as anotações pelo título
        List<Anotacao> todasAnotacoes = bloco.listarAnotacoes();
        for (int i = 0; i < todasAnotacoes.size(); i++) {
            System.out.println((i + 1) + ". " + todasAnotacoes.get(i).getTitulo());
        }

        // Solicita ao usuário que selecione uma anotação para editar
        System.out.print("Selecione uma anotação para editar (insira o número): ");
        int indice = entrada.nextInt();
        entrada.nextLine(); // Consumir a nova linha

        if (indice > 0 && indice <= todasAnotacoes.size()) {
            Anotacao anotacaoAntiga = todasAnotacoes.get(indice - 1);

            // Solicita ao usuário que insira um novo título e uma nova descrição
            System.out.print("Insira o novo título: ");
            String novoTitulo = entrada.nextLine();

            System.out.print("Insira a nova descrição: ");
            String novaDescricao = entrada.nextLine();

            // Cria uma nova instância de Anotacao com a data da anotação antiga
            Anotacao anotacaoNova = new Anotacao(anotacaoAntiga.getData(), novoTitulo, novaDescricao);

            // Atualiza a anotação selecionada com o novo título e a nova descrição
            bloco.editarAnotacao(anotacaoAntiga, anotacaoNova);

            System.out.println("Anotação editada com sucesso!");
        } else {
            System.out.println("Índice inválido. Operação cancelada.");
        }
    }

    private static void excluirAnotacao() {
        // Lista todas as anotações pelo título
        List<Anotacao> todasAnotacoes = bloco.listarAnotacoes();
        for (int i = 0; i < todasAnotacoes.size(); i++) {
            System.out.println((i + 1) + ". " + todasAnotacoes.get(i).getTitulo());
        }

        // Solicita ao usuário que selecione uma anotação para excluir
        System.out.print("Selecione uma anotação para excluir (insira o número): ");
        int indice = entrada.nextInt();
        entrada.nextLine(); // Consumir a nova linha

        // Exclui a anotação selecionada
        if (indice > 0 && indice <= todasAnotacoes.size()) {
            Anotacao anotacaoASerRemovida = todasAnotacoes.get(indice - 1);
            bloco.removerAnotacao(anotacaoASerRemovida);
            System.out.println("Anotação excluída com sucesso!");
        } else {
            System.out.println("Índice inválido. Operação cancelada.");
        }
    }
    
    private static void listarTodasAnotacoes() {
        // Lista todas as anotações existentes, mostrando a data, o título e a descrição de cada uma
        List<Anotacao> todasAnotacoes = bloco.listarAnotacoes();
        for (int i = 0; i < todasAnotacoes.size(); i++) {
            Anotacao anotacao = todasAnotacoes.get(i);
            System.out.println((i + 1) + ". ");
            
            System.out.println("Título: " + anotacao.getTitulo());
            System.out.println("Descrição: " + anotacao.getDescricao());
            System.out.println("--------------------------------");
        }

        if (todasAnotacoes.isEmpty()) {
            System.out.println("Nenhuma anotação encontrada.");
        }
    }

    private static void buscarAnotacaoPorMes() {
        // Solicita ao usuário que insira um mês
        System.out.print("Insira o número do mês (1-12) para buscar: ");
        int mes = entrada.nextInt();
        entrada.nextLine(); // Consumir a nova linha

        // Pesquisa todas as anotações criadas no mês especificado
        List<Anotacao> anotacoesEncontradas = bloco.buscarPorMes(mes);

        // Lista todas as anotações encontradas que correspondem ao critério de busca
        for (int i = 0; i < anotacoesEncontradas.size(); i++) {
            Anotacao anotacao = anotacoesEncontradas.get(i);
            System.out.println((i + 1) + ". ");
            
            System.out.println("Título: " + anotacao.getTitulo());
            System.out.println("Descrição: " + anotacao.getDescricao());
            System.out.println("--------------------------------");
        }

        if (anotacoesEncontradas.isEmpty()) {
            System.out.println("Nenhuma anotação encontrada para o mês especificado.");
        }
    }

    private static void buscarAnotacaoPorDia() {
        // Solicita ao usuário que insira um dia
        System.out.print("Insira o número do dia (1-31) para buscar: ");
        int dia = entrada.nextInt();

        // Solicita ao usuário que insira um mês
        System.out.print("Insira o número do mês (1-12) para buscar: ");
        int mes = entrada.nextInt();
        entrada.nextLine(); // Consumir a nova linha

        // Pesquisa todas as anotações criadas no dia e mês especificados
        List<Anotacao> anotacoesEncontradas = bloco.buscarPorDia(dia, mes);

        // Lista todas as anotações encontradas que correspondem ao critério de busca
        for (int i = 0; i < anotacoesEncontradas.size(); i++) {
            Anotacao anotacao = anotacoesEncontradas.get(i);
            System.out.println((i + 1) + ". ");
            
            System.out.println("Título: " + anotacao.getTitulo());
            System.out.println("Descrição: " + anotacao.getDescricao());
            System.out.println("--------------------------------");
        }

        if (anotacoesEncontradas.isEmpty()) {
            System.out.println("Nenhuma anotação encontrada para o dia e mês especificados.");
        }
    }
   
    private static void ordenarAnotacoesPorData() {
        // Ordena todas as anotações pela data de criação, do mais antigo ao mais recente
        List<Anotacao> anotacoesOrdenadas = bloco.ordenarPorData();

        // Lista todas as anotações ordenadas
        for (int i = 0; i < anotacoesOrdenadas.size(); i++) {
            Anotacao anotacao = anotacoesOrdenadas.get(i);
            System.out.println((i + 1) + ". ");
            
            System.out.println("Título: " + anotacao.getTitulo());
            System.out.println("Descrição: " + anotacao.getDescricao());
            System.out.println("--------------------------------");
        }

        if (anotacoesOrdenadas.isEmpty()) {
            System.out.println("Nenhuma anotação encontrada.");
        }
    }

    private static void ordenarAnotacoesPorTitulo() {
        // Ordena todas as anotações alfabeticamente pelo título
        List<Anotacao> anotacoesOrdenadas = bloco.ordenarPorTitulo();

        // Lista todas as anotações ordenadas
        for (int i = 0; i < anotacoesOrdenadas.size(); i++) {
            Anotacao anotacao = anotacoesOrdenadas.get(i);
            System.out.println((i + 1) + ". ");
            
            System.out.println("Título: " + anotacao.getTitulo());
            System.out.println("Descrição: " + anotacao.getDescricao());
            System.out.println("--------------------------------");
        }

        if (anotacoesOrdenadas.isEmpty()) {
            System.out.println("Nenhuma anotação encontrada.");
        }
    }

}