package Lista_03;

public class Pessoa {
    private String nome;
    private String cpf;
    private Data dataNascimento;

    public Pessoa(String nome, String cpf, Data dataNascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Pessoa other = (Pessoa) obj;
        return cpf != null ? cpf.equals(other.cpf) : other.cpf == null;
    }

    @Override
    public int hashCode() {
        return cpf != null ? cpf.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", CPF: " + cpf + ", Data de Nascimento: " + dataNascimento.toString();
    }
}