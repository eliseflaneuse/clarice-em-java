package game.model;

public abstract class Character {
	
	private String name;
    private int level;
    private int attributePoints;
     
	public Character(String name, int level, int attributePoints) {
		this.name = name;
		this.level = level; 
		this.attributePoints = attributePoints;
	}

	public String getName() {
		return name;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getAttributePoints() {
		return attributePoints;
	}

	public void addAttributePoints() {
		attributePoints++;
	}
    
	public abstract void read();
}