public class Poltrona {
    private boolean premium;
    private boolean livre;
  
    public Poltrona() { 
        this.premium = false;
        this.livre = true;
    }
    
    public boolean estado() { 
        return this.livre;
    }
    public boolean estadoPremium () { 
        return this.premium;
    }
    public void modifica(boolean x) { 
        this.livre = x;
    }
    public void modificaPremium (boolean x) { 
        this.premium = x;
    }
}
