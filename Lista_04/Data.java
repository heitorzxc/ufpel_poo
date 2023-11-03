public class Data {
    private final int dia;
    private final int mes;
    private final int ano;
    
    public Data(int dia, int mes, int ano) { 
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }
    
    @Override 
    public String toString() { 
        return ("Dia: " + dia + "/" + mes + "/" + ano + ".");
    }
}