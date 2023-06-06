package jogo_rpg;

import java.util.Scanner;
import jogo.model.Jogador;

public class RPG {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome do personagem: ");
        String nome = scanner.nextLine();

        System.out.print("Level: ");
        int level = scanner.nextInt();

        System.out.print("Vida: ");
        int vida = scanner.nextInt();

        System.out.print("Classe: ");
        String playerClass = scanner.next();

        Jogador player = new Jogador(nome, level, vida, playerClass);

        System.out.println("--- Character Sheet ---");
        System.out.println("Nome: " + player.getNome());
        System.out.println("Level: " + player.getLevel());
        System.out.println("Vida: " + player.getVida());
        System.out.println("Jogador Class: " + player.getPlayerClass());

        scanner.close();
	}

}
