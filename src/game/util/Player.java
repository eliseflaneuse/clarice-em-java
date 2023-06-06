package game.util;

public class Player extends Character {
	
	private int lifePoints;
	private int attributePoints;
    private int responsabilidadePessoal;
    private int mentalidadeDeCrescimento;
    private int proatividade;
    private int orientacaoAoDetalhe;
    
	public Player(String name) {
		super(name); // Invoke the constructor of the Character class
		this.lifePoints = 3;
		this.attributePoints = 0;
		this.responsabilidadePessoal = 0;
		this.mentalidadeDeCrescimento = 0;
		this.proatividade = 0;
		this.orientacaoAoDetalhe = 0;
	}
    
	public int getLifePoints() {
		return lifePoints;
	}

	public void setLifePoints(int lifePoints) {
		this.lifePoints = lifePoints;
	}
	
	public void decreaseLifePoints() {
        lifePoints--;
    }

    public int getAttributePoints() {
        return attributePoints;
    }

    public void addAttributePoint() {
        attributePoints++;
    }

    public int getResponsabilidadePessoal() {
        return responsabilidadePessoal;
    }

    public void setResponsabilidadePessoal(int points) {
        responsabilidadePessoal += points;
    }

    public int getMentalidadeDeCrescimento() {
        return mentalidadeDeCrescimento;
    }

    public void setMentalidadeDeCrescimento(int points) {
        mentalidadeDeCrescimento += points;
    }

    public int getProatividade() {
        return proatividade;
    }

    public void setProatividade(int points) {
        proatividade += points;
    }

    public int getOrientacaoAoDetalhe() {
        return orientacaoAoDetalhe;
    }

    public void setOrientacaoAoDetalhe(int points) {
        orientacaoAoDetalhe += points;
    }

    public void increaseLifePoints() {
        lifePoints++;
    }
    
}
