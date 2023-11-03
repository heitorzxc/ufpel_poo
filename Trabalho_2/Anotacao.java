package LembretesApp;

import java.util.Calendar;

public class Anotacao {
    private Calendar data;
    private String titulo;
    private String descricao;

    // Construtor
    public Anotacao(Calendar data, String titulo, String descricao) {
        this.data = data;
        this.titulo = titulo;
        this.descricao = descricao;
    }

    // Método para obter a data
    public Calendar getData() {
        return data;
    }

    // Método para obter o título
    public String getTitulo() {
        return titulo;
    }

    // Método para obter a descrição
    public String getDescricao() {
        return descricao;
    }

    // Método para definir o título
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    // Método para definir a descrição
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
