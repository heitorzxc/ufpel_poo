package Lista_03;

public class Principal {
    public static void main(String[] args) {
        Pessoa[] pessoas = new Pessoa[3];
        pessoas[0] = new Pessoa("João", "123.456.789-00", new Data(20, 11, 1980));
        pessoas[1] = new Professor("Carlos", "123.456.789-01", new Data(10, 5, 1970), "123456");
        pessoas[2] = new Estudante("Maria", "123.456.789-02", new Data(5, 2, 2000), "654321");
        // Loop que faz o vetor iniciar da primeira pessoa e ir até a última
        for (Pessoa pessoa : pessoas) {
            System.out.println(pessoa.toString());
        }
    }
}
