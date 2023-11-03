package Lista_02.Exercicio_04;

public class Interface {
    public static void main(String[] args) {
        RelogioDigital relogio = new RelogioDigital();

        relogio.atualizaVisor();

        // Simula eventos do relógio a cada segundo
        for (int i = 0; i < 60; i++) {
            try {
                Thread.sleep(1000); // Aguarda 1 segundo
                relogio.eventoDoRelogio();
                relogio.atualizaVisor();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
