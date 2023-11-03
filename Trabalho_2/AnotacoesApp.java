package LembretesApp;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.List;

public class AnotacoesApp {
    private List<Anotacao> anotacoes;

    // Construtor
    public AnotacoesApp() {
        this.anotacoes = new ArrayList<>();
    }

    // Método para adicionar uma anotação
    public void adicionarAnotacao(Anotacao anotacao) {
        this.anotacoes.add(anotacao);
    }

    // Método para remover uma anotação
    public void removerAnotacao(Anotacao anotacao) {
        this.anotacoes.remove(anotacao);
    }

    // Método para listar todas as anotações
    public List<Anotacao> listarAnotacoes() {
        return new ArrayList<>(this.anotacoes);
    }

    

    // Método para buscar anotações por mês
    public List<Anotacao> buscarPorMes(int mes) {
        List<Anotacao> resultados = new ArrayList<>();
        for (Anotacao anotacao : this.anotacoes) {
            if (anotacao.getData().get(Calendar.MONTH) + 1 == mes) {
                resultados.add(anotacao);
            }
        }
        return resultados;
    }

    // Método para buscar anotações por dia
    public List<Anotacao> buscarPorDia(int dia, int mes) {
        List<Anotacao> resultados = new ArrayList<>();
        for (Anotacao anotacao : this.anotacoes) {
            if (anotacao.getData().get(Calendar.DAY_OF_MONTH) == dia && anotacao.getData().get(Calendar.MONTH) + 1 == mes) {
                resultados.add(anotacao);
            }
        }
        return resultados;
    }

    // Método para ordenar anotações por data
    public List<Anotacao> ordenarPorData() {
        List<Anotacao> anotacoesOrdenadas = new ArrayList<>(this.anotacoes);
        anotacoesOrdenadas.sort(Comparator.comparing(Anotacao::getData, Comparator.reverseOrder()));
        return anotacoesOrdenadas;
    }

    // Método para ordenar anotações por título
    public List<Anotacao> ordenarPorTitulo() {
        List<Anotacao> anotacoesOrdenadas = new ArrayList<>(this.anotacoes);
        anotacoesOrdenadas.sort(Comparator.comparing(Anotacao::getTitulo));
        return anotacoesOrdenadas;
    }

    public void editarAnotacao(Anotacao anotacaoAntiga, Anotacao anotacaoNova) {
        int indice = this.anotacoes.indexOf(anotacaoAntiga);
        if (indice != -1) {
            this.anotacoes.set(indice, anotacaoNova);
        }
    }    

}


