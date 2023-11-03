package Lista_02.Exercicio_04;

import java.time.LocalTime;

public class RelogioDigital {
    private int hora;
    private int minutos;

    // Construtor da classe RelogioDigital
    public RelogioDigital() {
        LocalTime horaAtual = LocalTime.now();
        this.hora = horaAtual.getHour();
        this.minutos = horaAtual.getMinute();
    }

    // Método para atualizar o visor com a hora atual
    public void atualizaVisor() {
        String horaFormatada = formatarHora(hora) + ":" + formatarMinutos(minutos);
        System.out.println(horaFormatada);
    }

    // Método para incrementar a unidade mais básica do relógio (minutos)
    public void eventoDoRelogio() {
        minutos++;
        if (minutos >= 60) {
            minutos = 0;
            hora++;
            if (hora >= 24) {
                hora = 0;
            }
        }
    }

    // Método auxiliar para formatar a hora
    private String formatarHora(int hora) {
        if (hora < 10) {
            return "0" + hora;
        } else {
            return String.valueOf(hora);
        }
    }

    // Método auxiliar para formatar os minutos
    private String formatarMinutos(int minutos) {
        if (minutos < 10) {
            return "0" + minutos;
        } else {
            return String.valueOf(minutos);
        }
    }
}
