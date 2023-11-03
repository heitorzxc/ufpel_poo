package Lista_03;

import java.time.LocalDate;

public class Data {
    private final int dia;
    private final int mes;
    private final int  ano;

    public Data(int dia, int mes, int ano) {
        if (dia < 1) {
            this.dia = 1;
        } else if (dia > 31) {
            this.dia = 31;
        } else {
            this.dia = dia;
        }

        if (mes < 1) {
            this.mes = 1;
        } else if (mes > 12) {
            this.mes = 12;
        } else {
            this.mes = mes;
        }

        if (ano < 1990) {
            this.ano = 1990;
        } else if (ano > 2100) {
            this.ano = 2100;
        } else {
            this.ano = ano;
        }
    }

    public int calculaIdade() {
        int currentYear = LocalDate.now().getYear();
        int idade = currentYear - this.ano;

        // Se ainda não chegou o mês de aniversário neste ano, subtraia 1
        if (LocalDate.now().getMonthValue() < this.mes || 
            (LocalDate.now().getMonthValue() == this.mes && LocalDate.now().getDayOfMonth() < this.dia)) {
            idade--;
        }

        // Se o ano de nascimento for maior que o ano atual, a idade será 0
        if (this.ano > currentYear) {
            return 0;
        }
        return idade;
    }

    @Override
    public String toString() {
        return dia + "/" + mes + "/" + ano;
    }
}