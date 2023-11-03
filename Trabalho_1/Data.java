public class Data implements Comparable<Data> {
    private int dia;
    private int mes;
    private int ano;

    public Data(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    public int dia() {
        return dia;
    }

    public int mes() {
        return mes;
    }

    @Override
    public int compareTo(Data outra) {
        if (ano != outra.ano)
            return ano - outra.ano;
        if (mes != outra.mes)
            return mes - outra.mes;
        return dia - outra.dia;
    }

    @Override
    public String toString() {
        return dia + "/" + mes + "/" + ano;
    }
}