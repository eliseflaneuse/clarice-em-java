package game.model;

public class Opponent extends Character {

	private String item;
	private int damage;

	public Opponent(String name, int level, int attributePoints, String item, int damage) {
		super(name, level, attributePoints);
		this.item = item;
		this.damage = damage;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	@Override
	public void read() {
		System.out.println("\nNome: " + getName());
		System.out.println("Nível: " + getLevel());
		System.out.println("Pontos de atributo: " + getAttributePoints());
		System.out.println("Item: " + item);
		System.out.println("Pontos de dano: " + damage);
	}
}