package Lista_02.Exercicio_03;

public class ControleRemoto {
    private Televisao televisao;

    // Construtor da classe ControleRemoto
    public ControleRemoto(Televisao televisao) {
        this.televisao = televisao;
    }

    // Métodos para controlar o volume
    public void aumentarVolume() {
        televisao.aumentarVolume();
    }

    public void diminuirVolume() {
        televisao.diminuirVolume();
    }

    // Métodos para controlar o canal
    public void aumentarCanal() {
        televisao.aumentarCanal();
    }

    public void diminuirCanal() {
        televisao.diminuirCanal();
    }

    public void trocarCanal(int novoCanal) {
        televisao.trocarCanal(novoCanal);
    }

    // Método para consultar o valor do volume de som e do canal
    public void consultarStatus() {
        System.out.println("Volume: " + televisao.getVolume());
        System.out.println("Canal: " + televisao.getCanal());
    }
}
