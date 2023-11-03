public class AviaoPremium extends Aviao {
    public AviaoPremium(int numeroAviao, int dia, int mes, int ano, int capacidade, int cadeirasPremium) {
        super(numeroAviao, dia, mes, ano);
        this.assento = new Poltrona[capacidade];
        for (int i = 0; i < capacidade; i++) {
            this.assento[i] = new Poltrona();
        }
        for (int i = 0; i < cadeirasPremium; i++) { 
            assento[i].modificaPremium(true);
        }
    }
    
    public int maxVagas() { 
        return assento.length;
    }

    public int cadeirasPremium() { 
        int assentosPremium = 0;
        for (int i = 0; i < assento.length; i++) {
            if (assento[i].estadoPremium()) {
                assentosPremium++;
            }
        }
        return assentosPremium;
    }

    public String tipo(int x) { 
        if (assento[x].estadoPremium()) { 
            return ("Primeira Classe");
        }
        else { 
            return ("Assento Comum");
        }
    }
    
    @Override 
    public int proximoLivre() {
        int i;
        for (i = 0; i < maxPessoas; i++) {
            if (assento[i].estado() && !assento[i].estadoPremium()) {
                return i;
            }
        }
        return -1;
    }
    
    public int proximoPremiumLivre() {
        int i;
        for (i = 0; i < maxPessoas; i++) {
            if (assento[i].estado() && assento[i].estadoPremium()) {
                return i;
            }
        }
        return -1;
    }
}