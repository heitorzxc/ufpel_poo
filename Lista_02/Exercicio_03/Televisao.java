package Lista_02.Exercicio_03;

public class Televisao {
    private int canal;
    private int volume;

    // Construtor da classe Televisao
    public Televisao() {
        this.canal = 1; // Inicia no canal 1
        this.volume = 50; // Inicia com volume 50
    }

    // Métodos getter para o canal e volume
    public int getCanal() {
        return canal;
    }

    public int getVolume() {
        return volume;
    }

    // Métodos para aumentar e diminuir o volume
    public void aumentarVolume() {
        if (volume < 100) {
            volume++;
        }
    }

    public void diminuirVolume() {
        if (volume > 0) {
            volume--;
        }
    }

    // Métodos para aumentar e diminuir o canal
    public void aumentarCanal() {
        canal++;
    }

    public void diminuirCanal() {
        canal--;
    }

    // Método para trocar para um canal indicado
    public void trocarCanal(int novoCanal) {
        canal = novoCanal;
    }
}
