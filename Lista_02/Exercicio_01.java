import java.time.LocalDate;

public class Pessoa {
    private String nome;
    private LocalDate dataNascimento;
    private double altura;

    // Construtor da classe Pessoa
    public Pessoa(String nome, LocalDate dataNascimento, double altura) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.altura = altura;
    }

    // Métodos getter e setter para o atributo nome
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // Métodos getter e setter para o atributo dataNascimento
    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    // Métodos getter e setter para o atributo altura
    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    // Método para calcular a idade da pessoa
    public int calcularIdade() {
        LocalDate hoje = LocalDate.now();
        int idade = hoje.getYear() - dataNascimento.getYear();
        
        // Verificar se o aniversário já ocorreu este ano
        if (hoje.getMonthValue() < dataNascimento.getMonthValue() ||
            (hoje.getMonthValue() == dataNascimento.getMonthValue() &&
            hoje.getDayOfMonth() < dataNascimento.getDayOfMonth())) {
            idade--;
        }

        return idade;
    }

    // Método para imprimir os dados da pessoa
    public void imprimirDados() {
        System.out.println("Nome: " + nome);
        System.out.println("Data de Nascimento: " + dataNascimento);
        System.out.println("Altura: " + altura);
        System.out.println("Idade: " + calcularIdade() + " anos");
    }
}
