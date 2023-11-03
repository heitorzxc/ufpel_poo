package Lista_02.Exercicio_02;

public class Elevador {
    private int andarAtual;
    private int totalAndares;
    private int capacidade;
    private int pessoasPresentes;

    // Construtor da classe Elevador
    public Elevador(int capacidade, int totalAndares) {
        this.andarAtual = 0;
        this.capacidade = capacidade;
        this.totalAndares = totalAndares;
        this.pessoasPresentes = 0;
    }

    // Método para adicionar uma pessoa ao elevador
    public void entra() {
        if (pessoasPresentes < capacidade) {
            pessoasPresentes++;
            System.out.println("Uma pessoa entrou no elevador. Total de pessoas: " + pessoasPresentes);
        } else {
            System.out.println("O elevador está cheio. Não é possível entrar mais pessoas.");
        }
    }

    // Método para remover uma pessoa do elevador
    public void sai() {
        if (pessoasPresentes > 0) {
            pessoasPresentes--;
            System.out.println("Uma pessoa saiu do elevador. Total de pessoas: " + pessoasPresentes);
        } else {
            System.out.println("Não há pessoas dentro do elevador.");
        }
    }

    // Método para subir um andar
    public void sobe() {
        if (andarAtual < totalAndares) {
            andarAtual++;
            System.out.println("O elevador subiu para o andar " + andarAtual);
        } else {
            System.out.println("O elevador já está no último andar.");
        }
    }

    // Método para descer um andar
    public void desce() {
        if (andarAtual > 0) {
            andarAtual--;
            System.out.println("O elevador desceu para o andar " + andarAtual);
        } else {
            System.out.println("O elevador já está no térreo.");
        }
    }

    // Método para exibir o estado atual do elevador
    public void exibirEstado() {
        System.out.println("Andar Atual: " + andarAtual);
        System.out.println("Total de Andares: " + totalAndares);
        System.out.println("Capacidade do Elevador: " + capacidade);
        System.out.println("Pessoas Presentes: " + pessoasPresentes);
    }
}
