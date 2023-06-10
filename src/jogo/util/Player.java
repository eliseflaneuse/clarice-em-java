package jogo.util;

public class Player extends Personagem {
	
	
	package jogo.util;

	public class Player extends Personagem {
		
	    private int attributePoints;
	    private int responsabilidadePessoal;
	    private int mentalidadeDeCrescimento;
	    private int proatividade;
	    private int orientacaoAoDetalhe; //Le


	    public Player(String nome, int vida, int attributePoints, int responsabilidadePessoal, int mentalidadeDeCrescimento,
				int proatividade, int orientacaoAoDetalhe) {
			super(nome, vida);
			this.attributePoints = attributePoints;
			this.responsabilidadePessoal = responsabilidadePessoal;
			this.mentalidadeDeCrescimento = mentalidadeDeCrescimento;
			this.proatividade = proatividade;
			this.orientacaoAoDetalhe = orientacaoAoDetalhe;
		}


	    public int getAttributePoints() {
	        return attributePoints;
	    }

	    public void setAttributePoints(int attributePoints) {
	        this.attributePoints = attributePoints;
	    }

	    public int getResponsabilidadePessoal() {
	        return responsabilidadePessoal;
	    }

	    public void setResponsabilidadePessoal(int responsabilidadePessoal) {
	        this.responsabilidadePessoal = responsabilidadePessoal;
	    }

	    public int getMentalidadeDeCrescimento() {
	        return mentalidadeDeCrescimento;
	    }

	    public void setMentalidadeDeCrescimento(int mentalidadeDeCrescimento) {
	        this.mentalidadeDeCrescimento = mentalidadeDeCrescimento;
	    }

	    public int getProatividade() {
	        return proatividade;
	    }

	    public void setProatividade(int proatividade) {
	        this.proatividade = proatividade;
	    }

	    public int getOrientacaoAoDetalhe() {
	        return orientacaoAoDetalhe;
	    }

	    public void setOrientacaoAoDetalhe(int orientacaoAoDetalhe) {
	        this.orientacaoAoDetalhe = orientacaoAoDetalhe;
	    }

	    @Override
	    public void atacar(Personagem alvo) {
	       
	    }

	    @Override
	    public void defender() {
	        
	    }
	}

	/*
	
	private int lifePoints;
	private int attributePoints;
    private int responsabilidadePessoal;
    private int mentalidadeDeCrescimento;
    private int proatividade;
    private int orientacaoAoDetalhe;
    
	public Player(String name) {
		super(name); 
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
    */
}
