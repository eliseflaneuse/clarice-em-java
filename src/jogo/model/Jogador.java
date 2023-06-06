package jogo.model;

public class Jogador extends Personagem {
	
    private String playerClass;
   

    public Jogador(String nome, int level, int vida, String playerClass) {
        super(nome, level, vida);
        this.playerClass = playerClass;
       
    }

    // Getters and setters for Jogador-specific attributes

    public String getPlayerClass() {
        return playerClass;
    }

    public void setPlayerClass(String playerClass) {
        this.playerClass = playerClass;
    }


    // Additional methods specific to Jogador
}

