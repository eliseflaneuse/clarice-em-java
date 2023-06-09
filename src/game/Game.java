package game;

import java.util.Scanner;
import game.controller.OpponentController;
import game.controller.PlayerController;
import game.model.Opponent;
import game.model.Player;
import game.util.ArtLibrary;

public class Game {

	public static void main(String[] args) {

		printWelcomeMessage();
		ArtLibrary.printMonteJavaArt();

		Scanner scanner = new Scanner(System.in);
		PlayerController players = new PlayerController();
		OpponentController opponents = new OpponentController();

		// Player
		System.out.print("\n\tDigite o nome da sua personagem: ");
		String playerName = scanner.nextLine();

		Player player = new Player(playerName, 1, 0);

		// Distribute attribute points
		Player.distributeAttributePoints(player, scanner);

		// Test players' methods
		players.createPlayer(player);
		players.readPlayer();

		// Opponents
		Opponent theMadHatter = new Opponent("Chapeleiro Maluco", 1, 1, "Carta 1", 2);
		Opponent theCheshireCat = new Opponent("Gato de Cheshire", 2, 1, "Carta 2", 4);
		Opponent theWhiteRabbit = new Opponent("Coelho Branco", 3, 4, "Carta 3", 6);
		Opponent theQueenOfHearts = new Opponent("Rainha de Copas", 4, 1, "Carta 4", 8);
		Opponent theKingOfHearts = new Opponent("Rei de Copas", 5, 1, "Carta 5", 10);

		// Test opponents' methods
		opponents.createOpponent(theMadHatter);
		opponents.createOpponent(theCheshireCat);
		opponents.createOpponent(theWhiteRabbit);
		opponents.createOpponent(theQueenOfHearts);
		opponents.createOpponent(theKingOfHearts);
		opponents.readOpponent();

	}

	public static void printWelcomeMessage() {
		// Print top border
		System.out.println(
				"==============================================================================================");

		// Print message with padding
		System.out.println(
				" ____  _            _                                ___                  _                 _ ");
		System.out.println(
				"/   _\\| |          (_)                              |_  |                | |               | |");
		System.out.println(
				"| /  \\| | __ _ _ __ _  ___ ___    ___   _ __ ___      | | __ ___   ____ _| | __ _ _ __   __| |");
		System.out.println(
				"| |   | |/ _` | '__| |/ __/ _ \\  / _ ` | '_ ` _ \\     | |/ _` \\ \\ / / _` | |/ _` | '_ \\ / _` |");
		System.out.println(
				"| \\__/| | (_| | |  | | (_|  __/ |  _ /  | | | | | /\\__/ | (_| |\\ V / (_| | | (_| | | | | (_| |");
		System.out.println(
				" \\____|_|\\__,_|_|  |_|\\___\\___|  \\___|  | |_| |_| \\____/ \\__,_| \\_/ \\__,_|_|\\__,_|_| |_|\\__,_|");
		System.out.println(
				"                                                                                                         ");

		// Print bottom border
		System.out.println(
				"==============================================================================================\n");
	}
}