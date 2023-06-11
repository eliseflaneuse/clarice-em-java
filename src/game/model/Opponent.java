package game.model;

public class Opponent extends Character {

	private String item;

	public Opponent(String name, int lifePoints, int defense, int damage, String item) {
		super(name, lifePoints, defense, damage);
		this.item = item;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	@Override
	public boolean attack(Character alvo) {

		System.out.println(getName() + " atacou " + alvo.getName() + " causando " + damage + " de dano.");
		alvo.receberDano(damage);

		return alvo.getLifePoints() <= 0; // Return true if the target was defeated, false otherwise
	}

	@Override
	public void shield() {

		System.out.println(getName() + " se defendeu, reduzindo o dano recebido em " + defense + ".");
		defesaAtiva = true;
	}

	
	public void read() {
		System.out.println("\nNome: " + getName());
		System.out.println("Item: " + item);
		System.out.println("Pontos de dano: " + damage);
	}
	
}