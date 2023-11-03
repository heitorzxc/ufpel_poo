package Lista_03;

public class Professor extends Pessoa {
    private String siape;

    public Professor(String nome, String cpf, Data dataNascimento, String siape) {
        super(nome, cpf, dataNascimento);
        this.siape = siape;
    }

    @Override
    public String toString() {
        return super.toString() + ", SIAPE: " + siape;
    }
}
