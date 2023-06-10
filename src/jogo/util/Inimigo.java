package jogo.util;

public class Inimigo extends Personagem {
    
    private String presente;

    public Inimigo(String nome, int vida, String presente) {
    	super(nome, vida);
		this.presente = presente;
	}


    public String getPresente() {
        return presente;
    }

    public void setPresente(String presente) {
        this.presente = presente;
    }

    @Override
    public void atacar(Personagem alvo) {
        
    }

    @Override
    public void defender() {
        
    }
}
