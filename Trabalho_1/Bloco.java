import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Bloco {
    private List<Lembrete> lista;
    
    public Bloco() {
        lista = new ArrayList<>();
    }
    
    public void inserir(Lembrete l) {
        lista.add(l);
    }
    
    public Lembrete remover(int posicao) {
        return lista.remove(posicao);
    }
    
    public Lembrete buscar(int posicao) {
        return lista.get(posicao);
    }

    public List<Lembrete> buscarPorPalavra(String substring) {
        List<Lembrete> resultados = new ArrayList<>();
        for (Lembrete l : lista) {
            if (l.toString().contains(substring)) {
                resultados.add(l);
            }
        }
        return resultados;
    }
    
    public List<Lembrete> buscarPorMes(int mes) {
        List<Lembrete> resultados = new ArrayList<>();
        for (Lembrete l : lista) {
            if (l.getData().mes() == mes) {
                resultados.add(l);
            }
        }
        return resultados;
    }
    
    public List<Lembrete> buscarPorDia(int dia) {
        List<Lembrete> resultados = new ArrayList<>();
        for (Lembrete l : lista) {
            if (l.getData().dia() == dia) {
                resultados.add(l);
            }
        }
        return resultados;
    }

    public List<Lembrete> buscarTodos() {
        return new ArrayList<>(lista);
    }
    
    public void ordenar() {
        Collections.sort(lista);
    }
    
    @Override
    public String toString() {
        return lista.toString();
    }
}