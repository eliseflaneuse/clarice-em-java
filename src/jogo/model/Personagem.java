package jogo.model;

public class Personagem {

	private String nome;
	private int level;
	private int vida;

	public Personagem(String nome, int level, int vida) {
        this.nome = nome;
        this.level = level;
        this.vida = vida;
    }

	// Getters and setters

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	// Métodos

	public void attack(Character target) {
		// Lógica aqui
	}
}
