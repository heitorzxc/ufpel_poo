public class Lembrete implements Comparable<Lembrete> {
    private String descricao;
    private Data data; // Utilizando a classe Data para representar a data completa
    
    public Lembrete(String descricao, Data data) {
        this.descricao = descricao;
        this.data = data;
    }

    public Data getData() {
        return this.data;
    }
    
    @Override
    public String toString() {
        return data.toString() + " - " + descricao + "\n";
    }

    @Override
    public int compareTo(Lembrete l) {
        return this.data.compareTo(l.data);
    }
}