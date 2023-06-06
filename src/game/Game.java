package game;

import java.util.Scanner;
import game.util.ArtLibrary;
import game.util.Player;

public class Game {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		printWelcomeMessage();
		ArtLibrary.printMonteJavaArt();
		
		// Create the player character
		   
        System.out.print("Digite o nome do personagem: ");
        String playerName = scanner.nextLine();
        
        Player player = new Player(playerName);
        
        System.out.println("--- Ficha do Personagem ---");
        System.out.println("Nome: " + player.getName());
		System.out.println("Level: " + player.getLevel());
		
		// Distribute attribute points
        distributeAttributePoints(player, scanner);
        
        //Start the game
        
        //Display the story = sysout with drawing + story 
        //Início da Jornada do Herói - Gandalf asks Frodo - Do you want to acompany me on an adventure? y/n
        // Grande if
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
        scanner.close();
	}
	
	private static void distributeAttributePoints(Player player, Scanner scanner) {
        int remainingPoints = 10;

        System.out.println("--- Distribua os Pontos de Atributo ---");

        while (remainingPoints > 0) {
            System.out.println("Pontos restantes: " + remainingPoints);
            System.out.println("1. Responsabilidade Pessoal");
            System.out.println("2. Mentalidade de Crescimento");
            System.out.println("3. Proatividade");
            System.out.println("4. Orientação ao Detalhe");
            System.out.print("Escolha um atributo para distribuir os pontos (1-4): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            if (choice < 1 || choice > 4) {
                System.out.println("Escolha inválida. Ta faltando orientação ao detalhe!");
                continue;
            }

            System.out.print("Quantos pontos você quer alocar: ");
            int points = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            if (points < 0 || points > remainingPoints) {
                System.out.println("Invalid number of points. Please choose again.");// deixar engraçadinho
                continue;
            }

            switch (choice) {
                case 1:
                    player.setResponsabilidadePessoal(points);
                    break;
                case 2:
                    player.setMentalidadeDeCrescimento(points);
                    break;
                case 3:
                    player.setProatividade(points);
                    break;
                case 4:
                    player.setOrientacaoAoDetalhe(points);
                    break;
            }

            remainingPoints -= points;
        }
        
        // Deixar a ficha cute
        System.out.println("\n\n--- Character Sheet ---");
        System.out.println("Nome: " + player.getName());
        System.out.println("Level: " + player.getLevel());
        System.out.println("--- Distributed Attribute Points ---");
        System.out.println("Responsabilidade Pessoal: " + player.getResponsabilidadePessoal());
        System.out.println("Mentalidade de Crescimento: " + player.getMentalidadeDeCrescimento());
        System.out.println("Proatividade: " + player.getProatividade());
        System.out.println("Orientação ao Detalhe: " + player.getOrientacaoAoDetalhe() + "\n\n\n");
    }
	private static void distributeAttributePoints(Player player, Scanner scanner) {
        int remainingPoints = 10;

        System.out.println("--- Distribua os Pontos de Atributo ---");

        while (remainingPoints > 0) {
            System.out.println("Pontos restantes: " + remainingPoints);
            System.out.println("1. Responsabilidade Pessoal");
            System.out.println("2. Mentalidade de Crescimento");
            System.out.println("3. Proatividade");
            System.out.println("4. Orientação ao Detalhe");
            System.out.print("Escolha um atributo para distribuir os pontos (1-4): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            if (choice < 1 || choice > 4) {
                System.out.println("Invalid choice. Please choose again.");
                continue;
            }

            System.out.print("Enter the number of points to allocate: ");
            int points = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            if (points < 0 || points > remainingPoints) {
                System.out.println("Invalid number of points. Please choose again.");
                continue;
            }

            switch (choice) {
                case 1:
                    player.setResponsabilidadePessoal(points);
                    break;
                case 2:
                    player.setMentalidadeDeCrescimento(points);
                    break;
                case 3:
                    player.setProatividade(points);
                    break;
                case 4:
                    player.setOrientacaoAoDetalhe(points);
                    break;
            }

            remainingPoints -= points;
        }
        
        System.out.println("\n\n--- Character Sheet ---");
        System.out.println("Nome:\t\t\t\t" + player.getName());
        System.out.println("--- Distribua os pontos nos atributos ---");
        System.out.println("Responsabilidade Pessoal:\t" + player.getResponsabilidadePessoal());
        System.out.println("Mentalidade de Crescimento:\t" + player.getMentalidadeDeCrescimento());
        System.out.println("Proatividade:\t\t\t" + player.getProatividade());
        System.out.println("Orientação ao Detalhe:\t\t" + player.getOrientacaoAoDetalhe());
        System.out.println("\n\n\n");
    }
	
	public static void printWelcomeMessage() {
        String welcomeMessage = "Bem-vindo ao jogo Monte Java!";
        int messageLength = welcomeMessage.length();

        // Print top border
        System.out.println("=========================================================================");

        // Print message with padding
        System.out.printf("%" + ((70 - messageLength) / 2 + messageLength) + "s%n", welcomeMessage);

        // Print bottom border
        System.out.println("=========================================================================\n");
    }
}
