public class Aviao {
    protected int maxPessoas = 299; 
    private int numeroAviao;
    private Data dataEmbarque;
    protected Poltrona[] assento;

    public Aviao(int numeroAviao, int dia, int mes, int ano) {
        this.numeroAviao = numeroAviao;
        this.dataEmbarque = new Data(dia, mes, ano);
        this.assento = new Poltrona[maxPessoas];
        for (int i = 0; i < maxPessoas; i++) {
            this.assento[i] = new Poltrona();
        }
    }

    public int proximoLivre() {
        int i;
        for (i = 0; i < maxPessoas; i++) {
            if (assento[i].estado()) {
                return i;
            }
        }
        return -1;
    }

    public boolean verifica(int x) {
        return !assento[x].estado();
    }

    public boolean ocupa(int x) {
        if (assento[x].estado()) {
            assento[x].modifica(false);
            return true;
        } else {
            return false;
        }
    }

    public int vagas() {
        int vagasLivres = 0;
        for (int i = 0; i < maxPessoas; i++) {
            if (assento[i].estado()) {
                vagasLivres++;
            }
        }
        return vagasLivres;
    }

    public String getNumero() {
        return ("Número do avião: " + this.numeroAviao);
    }

    public String getData() {
        return (dataEmbarque.toString());
    }
}