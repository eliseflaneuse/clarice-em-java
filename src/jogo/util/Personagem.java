package jogo.util;

public abstract class Personagem {
	private String nome;
	private int vida;


    public Personagem(String nome, int vida) {
		this.nome = nome;
		this.vida = vida;
	}
    

	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public int getVida() {
		return vida;
	}


	public void setVida(int vida) {
		this.vida = vida;
	}


	public abstract void atacar(Personagem alvo);
    public abstract void defender();
}
