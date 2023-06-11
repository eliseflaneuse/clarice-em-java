package game.model;

public abstract class Character {
	
	private String name;
	private int lifePoints;
    protected boolean defesaAtiva;
    protected int defense;
    protected int damage;

    public Character(String name, int lifePoints, int defense, int damage) {
        this.name = name;
        this.lifePoints = lifePoints;
        this.defesaAtiva = false;
        this.defense = defense;
        this.damage = damage;
    }

   

    public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getLifePoints() {
		return lifePoints;
	}



	public void setLifePoints(int lifePoints) {
		this.lifePoints = lifePoints;
	}


	public int getDefense() {
		return defense;
	}



	public void setDefense(int defense) {
		this.defense = defense;
	}



	public int getDamage() {
		return damage;
	}



	public void setDamage(int damage) {
		this.damage = damage;
	}



	public abstract boolean attack(Character alvo);

    public abstract void shield();

    public void receberDano(int damage) {
        int danoRecebido = damage - defense;
        if (danoRecebido > 0) {
            lifePoints -= danoRecebido;
            System.out.println(name + " recebeu " + danoRecebido + " de dano.");
        } else {
            System.out.println(name + " se defendeu totalmente.");
        }

        if (lifePoints <= 0) {
            System.out.println(name + " foi derrotado.");
        }
    }
	
}