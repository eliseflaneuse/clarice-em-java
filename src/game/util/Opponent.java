package game.util;

public class Opponent extends Character {
    
    private String presente;

    public Opponent(String nome, int vida, String presente) {
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
    public boolean atacar(Character alvo) {
        int dano = 1; // Dano do ataque

        System.out.println(getNome() + " atacou " + alvo.getNome() + " causando " + dano + " de dano.");
        alvo.receberDano(dano);

        return alvo.getVida() <= 0; // Return true if the target was defeated, false otherwise
    }

    @Override
    public void defender() {
        int defesa = 1; // Valor de defesa do inimigo

        System.out.println(getNome() + " se defendeu, reduzindo o dano recebido em " + defesa + ".");
        defesaAtiva = true;
        defesaAtual = defesa;
    }
}
