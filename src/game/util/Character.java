package game.util;

public class Character {
	
	private String name;
    private int level;
    private int attributePoints;
    
    
	public Character(String name) {
		this.name = name;
		this.level = 1; 
		this.attributePoints = 0;
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
    
	
    
}
