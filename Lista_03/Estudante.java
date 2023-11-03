package Lista_03;

public class Estudante extends Pessoa {
    private String matricula;

    public Estudante(String nome, String cpf, Data dataNascimento, String matricula) {
        super(nome, cpf, dataNascimento);
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return super.toString() + ", Matrícula: " + matricula;
    }
}
