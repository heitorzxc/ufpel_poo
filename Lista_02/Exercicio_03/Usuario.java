package Lista_02.Exercicio_03;

public class Usuario {
    public static void main(String[] args) {
        Televisao televisao = new Televisao();
        ControleRemoto controleRemoto = new ControleRemoto(televisao);

        controleRemoto.aumentarVolume();
        controleRemoto.aumentarVolume();
        controleRemoto.diminuirVolume();

        controleRemoto.aumentarCanal();
        controleRemoto.aumentarCanal();
        controleRemoto.diminuirCanal();

        controleRemoto.trocarCanal(5);

        controleRemoto.consultarStatus();
    }
}
