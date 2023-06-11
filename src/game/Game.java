package game;

import java.util.Scanner;
import game.model.*;
import game.repository.*;
import game.util.*;

public class Game implements GameRepository {

	Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		Game jogo = new Game();
		jogo.exibirMenu();
	}

	private Player player;

	@Override
	public void exibirMenu() {
		boolean sair = false;
		while (!sair) {
			System.out.println("\n------ Menu ------");
			System.out.println("Escolha uma opção:");
			System.out.println("1. Iniciar Jogo");
			System.out.println("0. Sair do jogo");

			int opcao = scanner.nextInt();
			scanner.nextLine();

			switch (opcao) {
			case 1:
				iniciarJogo();
				jogar();
				break;
			case 0:
				sair = true;
				System.out.println("Obrigado por jogar! Até a próxima!");
				break;
			default:
				System.out.println("Opção inválida! Tente novamente.");
				break;
			}
		}
	}

	@Override
	public void iniciarJogo() {

		ArtLibrary.printWelcomeMessage();
		ArtLibrary.printMonteJavaArt();

		System.out.printf("\tInforme o nome do jogador:");
		String nomeJogador = scanner.nextLine();

		player = new Player(nomeJogador, 5, 5, 2, 0, 0, 0, 0);

		System.out.println("\n\n--- Ficha do Personagem ---");
		System.out.println("Nome:\t\t\t\t" + player.getName());
		System.out.println("--- Distribuição de pontos nos atributos ---");
		System.out.println("Responsabilidade Pessoal:\t" + player.getResponsabilidadePessoal());
		System.out.println("Mentalidade de Crescimento:\t" + player.getMentalidadeDeCrescimento());
		System.out.println("Proatividade:\t\t\t" + player.getProatividade());
		System.out.println("Orientação ao Detalhe:\t\t" + player.getOrientacaoAoDetalhe());
		System.out.println("\n\n\n");

	}

	@Override
	public void jogar() {
		System.out.println("\nIniciando o jogo...");

		boolean continuarJogando = true;

		while (continuarJogando && player.getLifePoints() > 0) {
			System.out.println("\n------ Menu de Cenas ------");
			System.out.println("Escolha uma cena para jogar:");
			System.out.println("1. Cena do Chapeleiro Louco");
			System.out.println("2. Cena do Gato Chester/Esfinge");
			System.out.println("3. Cena do Coelho que dá mais 5 minutos");
			System.out.println("4. Cena do Criquet com a Rainha de Copas");
			System.out.println("5. Cena para decifrar o código da porta mágica");
			System.out.println("0. Voltar ao Menu Inicial");

			int opcao = scanner.nextInt();
			scanner.nextLine();

			switch (opcao) {
			case 1:
				cenaChapeleiroLouco();
				break;
			case 2:
				cenaGatoChester();
				break;
			case 3:
				cenaCoelhoCincoMinutos();
				break;
			case 4:
				cenaCriquetRainhaCopas();
				break;
			case 5:
				cenaDecifrarCodigoPortaMagica();
				break;
			case 0:
				exibirMenu();
				break;
			default:
				System.out.println("Opção inválida! Tente novamente.");
				break;
			}
		}

		if (player.getLifePoints() > 0) {
			System.out.println("\nParabéns! Você completou todas as cenas e venceu o jogo!");
		} else {
			System.out.println("\nQue pena! Você perdeu todas as suas vidas e não conseguiu completar o jogo.");
		}

		System.out.println("Fim do jogo. Obrigado por jogar!");
	}

	private void cenaChapeleiroLouco() {
		System.out.println("\nVocê encontrou o Chapeleiro Louco!");

		System.out.println("\nContinuando sua jornada...");
	}

	private void cenaGatoChester() {
		System.out.println("\nVocê encontrou o Gato Chester/Esfinge!");

	}

	private void cenaCoelhoCincoMinutos() {
		System.out.println("\nVocê encontrou o Coelho que lhe deu mais 5 minutos!");
	}

	private void cenaCriquetRainhaCopas() {
		System.out.println("\nVocê está jogando criquet com a Rainha de Copas!");
	}

	private void cenaDecifrarCodigoPortaMagica() {
	    System.out.println("\n--- Cena da Porta Mágica ---");
	    System.out.println("Você chegou à misteriosa Porta Mágica, guardada por duas cartas da Rainha de Copas!\n");

	    System.out.println("3 de copas: Pare! Ninguém passa sem a permissão da Rainha de Copas!");
	    System.out.println("2 de paus: Isso mesmo! Prepare-se para enfrentar a nossa fúria!\n");

	    System.out.println("Você se aproxima das cartas, pronta para o confronto.");
	    System.out.println(player.getName() + ": Eu enfrentei desafios incríveis para chegar até aqui e reunir os 4 itens do segredo.");
	    System.out.println("Agora, desejo voltar ao meu mundo, e essa porta é o caminho. Por favor, deixem-me passar!");

	    System.out.println("3 de copas: Hahaha! Achou que seria fácil, humana insolente?");
	    System.out.println("2 de paus: Prepare-se para a batalha final! Nós somos as guardiãs da Rainha de Copas e não permitiremos sua passagem sem luta!\n");

	    System.out.println("Você se prepara para o combate contra as cartas da Rainha de Copas.");
	    System.out.println("Então seja! Eu mostrarei a vocês do que sou capaz!");


	    // Criando as cartas da Rainha de Copas
	    Opponent carta1 = new Opponent("3 de copas", 4, 2, 1 , "copo");
	    Opponent carta2 = new Opponent("2 de paus", 4, 2, 1 , "copo");

	    boolean vitoria = false;
	    int currentPlayerAttack = 1;

	    while (!vitoria && player.getLifePoints() > 0) {
	        System.out.println("\nOpções:");
	        System.out.println("1. Atacar a primeira carta");
	        System.out.println("2. Atacar a segunda carta");
	        System.out.println("3. Defender");

	        int opcao = scanner.nextInt();
	        scanner.nextLine();

	        if (opcao == 3) {
	            player.shield();
	            System.out.println("Você se defendeu dos ataques das cartas!");
	            carta1.attack(player);
	            carta2.attack(player);
	            currentPlayerAttack = 1; // Reset player's attack to start next round
	        } else if (opcao == 1 || opcao == 2) {
	            Opponent currentCard = (opcao == 1) ? carta1 : carta2;
	            player.attack(currentCard);
	            currentPlayerAttack = 2; // Player's next attack will be on the other card

	            if (currentCard.getLifePoints() <= 0) {
	                System.out.println("Você derrotou a carta " + currentCard.getName() + " da Rainha de Copas!");

	                Opponent remainingCard = (opcao == 1) ? carta2 : carta1;
	                if (player.attack(remainingCard)) {
	                    System.out.println("Você derrotou a carta " + remainingCard.getName() + " da Rainha de Copas!");
	                    vitoria = true;
	                } else {
	                    System.out.println("Você precisa derrotar a carta " + remainingCard.getName() + " para abrir a porta.");
	                }
	            } else {
	                System.out.println("A carta " + currentCard.getName() + " contra-atacou! Cuide da sua vida!");
	            }
	        } else {
	            System.out.println("Opção inválida! Tente novamente.");
	        }
	    }

	    if (vitoria) {
	        System.out.println("\nParabéns! Você derrotou as cartas da Rainha de Copas e abriu a porta mágica!");
	    } else {
	        System.out.println("\nQue pena! Você perdeu todas as suas vidas e não conseguiu abrir a porta mágica.");
	    }
	}
}

/*
 * package game;
 * 
 * import java.util.Scanner; import game.controller.OpponentController; import
 * game.controller.PlayerController; import game.model.Opponent; import
 * game.model.Player; import game.util.ArtLibrary;
 * 
 * public class Game {
 * 
 * public static void main(String[] args) {
 * 
 * printWelcomeMessage(); ArtLibrary.printMonteJavaArt();
 * 
 * Scanner scanner = new Scanner(System.in); PlayerController players = new
 * PlayerController(); OpponentController opponents = new OpponentController();
 * 
 * // Player System.out.print("\n\tDigite o nome da sua personagem: "); String
 * playerName = scanner.nextLine();
 * 
 * Player player = new Player(playerName, 1, 0);
 * 
 * // Distribute attribute points Player.distributeAttributePoints(player,
 * scanner);
 * 
 * // Test players' methods players.createPlayer(player); players.readPlayer();
 * 
 * // Opponents Opponent theMadHatter = new Opponent("Chapeleiro Maluco", 1, 1,
 * "Carta 1", 2); Opponent theCheshireCat = new Opponent("Gato de Cheshire", 2,
 * 1, "Carta 2", 4); Opponent theWhiteRabbit = new Opponent("Coelho Branco", 3,
 * 4, "Carta 3", 6); Opponent theQueenOfHearts = new Opponent("Rainha de Copas",
 * 4, 1, "Carta 4", 8); Opponent theKingOfHearts = new Opponent("Rei de Copas",
 * 5, 1, "Carta 5", 10);
 * 
 * // Test opponents' methods opponents.createOpponent(theMadHatter);
 * opponents.createOpponent(theCheshireCat);
 * opponents.createOpponent(theWhiteRabbit);
 * opponents.createOpponent(theQueenOfHearts);
 * opponents.createOpponent(theKingOfHearts); opponents.readOpponent();
 * 
 * }
 * 
 * public static void printWelcomeMessage() { // Print top border
 * System.out.println(
 * "=============================================================================================="
 * );
 * 
 * // Print message with padding System.out.println(
 * " ____  _            _                                ___                  _                 _ "
 * ); System.out.println(
 * "/   _\\| |          (_)                              |_  |                | |               | |"
 * ); System.out.println(
 * "| /  \\| | __ _ _ __ _  ___ ___    ___   _ __ ___      | | __ ___   ____ _| | __ _ _ __   __| |"
 * ); System.out.println(
 * "| |   | |/ _` | '__| |/ __/ _ \\  / _ ` | '_ ` _ \\     | |/ _` \\ \\ / / _` | |/ _` | '_ \\ / _` |"
 * ); System.out.println(
 * "| \\__/| | (_| | |  | | (_|  __/ |  _ /  | | | | | /\\__/ | (_| |\\ V / (_| | | (_| | | | | (_| |"
 * ); System.out.println(
 * " \\____|_|\\__,_|_|  |_|\\___\\___|  \\___|  | |_| |_| \\____/ \\__,_| \\_/ \\__,_|_|\\__,_|_| |_|\\__,_|"
 * ); System.out.println(
 * "                                                                                                         "
 * );
 * 
 * // Print bottom border System.out.println(
 * "==============================================================================================\n"
 * ); } }
 */
