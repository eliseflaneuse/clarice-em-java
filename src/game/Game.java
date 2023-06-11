package game;

import java.text.Normalizer;
import java.util.Scanner;

import game.controller.OpponentController;
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
			System.out.println("");
			System.out.println("\t\t\t\t     ------ Menu ------");
			System.out.println("\t\t\t\t     Escolha uma opção:");
			System.out.println("\t\t\t\t     1. Iniciar Jogo");
			System.out.println("\t\t\t\t     0. Sair do jogo");

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

		System.out.printf("\n\tInforme o nome do jogador:");
		String nomeJogador = scanner.nextLine();

		player = new Player(nomeJogador, 5, 5, 3, 0, 0, 0, 0, 0);

		printCharacterSheet();

	}

	@Override
	public void jogar() {
		System.out.println("\n\tIniciando o jogo...");

		boolean continuarJogando = true;

		while (continuarJogando && player.getLifePoints() > 0) {
			System.out.println("\n\t------ Menu de Cenas ------");
			System.out.println("\tEscolha uma cena para jogar:");
			System.out.println("\t1. Cena do Chapeleiro Louco");
			System.out.println("\t2. Cena do Gato Chester/Esfinge");
			System.out.println("\t3. Cena do Coelho que dá mais 5 minutos");
			System.out.println("\t4. Cena do Criquet com a Rainha de Copas");
			System.out.println("\t5. Cena para decifrar o código da porta mágica");
			System.out.println("\t0. Voltar ao Menu Inicial");

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
	    System.out.println(Colors.TEXT_GREEN_BOLD_BRIGHT + "\n\tVocê separa as últimas folhas das árvores em seu caminho e se depara com umas das maiores porta que já viu.");
	    System.out.println("\tEla parece ter muitas palvras e letras brilhando um verde ofuscantes em ondas, como se a porta fosse feita inteira de Opala."
	    		+ " Você da um passo em direção à ela.\n\n\n\n"+ Colors.TEXT_RESET);
	    
	    ArtLibrary.printMagicDoor();
	    
	    System.out.println(Colors.TEXT_GREEN_BOLD_BRIGHT +  "\t\tDe canto de olho você percebe uma movimentação mas não consegue se esconder a tempo! ");
	    System.out.println("\tDuas cartas enormes aparecem no seu caminho. Uma com os desenhos de 3 de copas a outra 2 de paus.");
	    System.out.println("\tAmbas empunham lanças afiadíssimas. Elas te olham com desdém.\n\n" + Colors.TEXT_RESET);
	    System.out.println("\n\n");

	    ArtLibrary.printCards();

	    System.out.println(Colors.TEXT_GREEN_BOLD_BRIGHT + "\t\t3 de copas: Pare! Ninguém passa sem a permissão da Rainha de Copas!" );
	    System.out.println("\t\t2 de paus: Isso mesmo! Prepare-se para enfrentar a nossa fúria!\n" );

	    System.out.println("\t\tVocê se aproxima das cartas, pronte para o confronto.\n");
	    System.out.println("\t" + player.getName() + ": Eu enfrentei desafios incríveis para chegar até aqui e reunir os 4 itens do segredo.");
	    System.out.println("\tAgora, desejo voltar ao meu mundo, e essa porta é o caminho. Por favor, deixem-me passar!\n" );

	    System.out.println("\t3 de copas: Hahaha! Achou que seria fácil, humana insolente?");
	    System.out.println("\t2 de paus: Prepare-se para a batalha final! Nós somos as guardiãs da Rainha de Copas e não permitiremos sua passagem sem luta!\n");

	    System.out.println("\tVocê se prepara para o combate contra as cartas da Rainha de Copas.");
	    System.out.println("\tQue assim seja! Eu mostrarei a vocês do que sou capaz!" + Colors.TEXT_RESET);


	    // Criando as cartas da Rainha de Copas
	    Opponent carta1 = new Opponent("3 de copas", 2, 2, 1 , "copo");
	    Opponent carta2 = new Opponent("2 de paus", 2, 2, 1 , "copo");

	    boolean vitoria = false;
	    int currentPlayerAttack = 1;

	    while (!vitoria && player.getLifePoints() > 0) {
	        System.out.println("\n\tOpções:");
	        System.out.println("\t1. Atacar a primeira carta");
	        System.out.println("\t2. Atacar a segunda carta");
	        System.out.println("\t3. Defender");

	        int opcao = scanner.nextInt();
	        scanner.nextLine();

	        if (opcao == 3) {
	            player.shield();
	            System.out.println("\tVocê se defendeu dos ataques das cartas!");
	            carta1.attack(player);
	            carta2.attack(player);
	            currentPlayerAttack = 1; // Reset player's attack to start next round
	        } else if (opcao == 1 || opcao == 2) {
	            Opponent currentCard = (opcao == 1) ? carta1 : carta2;
	            player.attack(currentCard);
	            currentPlayerAttack = 2; // Player's next attack will be on the other card

	            if (currentCard.getLifePoints() <= 0) {
	                System.out.println("\tVocê derrotou a carta " + currentCard.getName() + " da Rainha de Copas!");

	                Opponent remainingCard = (opcao == 1) ? carta2 : carta1;
	                if (player.attack(remainingCard)) {
	                    System.out.println("\tVocê derrotou a carta " + remainingCard.getName() + " da Rainha de Copas!");
	                    vitoria = true;
	                } else {
	                    System.out.println("\tVocê precisa derrotar a carta " + remainingCard.getName() + " para abrir a porta.");
	                }
	            } else {
	                System.out.println("\tA carta " + currentCard.getName() + " contra-atacou! Cuide da sua vida!");
	            }
	        } else {
	            System.out.println("\tOpção inválida! Tente novamente.");
	        }
	    }

	    if (vitoria) {
	    	System.out.println("\n\n\n");
	        System.out.println(Colors.TEXT_GREEN_BOLD_BRIGHT + "\t\tDepois de uma árdua batalha contra as cartas furiosas da Rainha de Copas, "
	        		+ "você finalmente está diante da imponente porta e uma mensagem misteriosa é revelada em sua superfície:\n");
	        System.out.println("\t\tPara essa porta passar,");
	        System.out.println("\t\tAqui você terá que decifrar,");
	        System.out.println("\t\tDuas casas pular,");
	        System.out.println("\t\tPara 'amigo' transformar em 'COQKI'.\"");
	        
	        System.out.println("Embasbacade com a mensagem, você se desespera. "
	        		+ "Depois de todas essas provações, será que você não vai conseguir voltar pra casa?");
	        System.out.println("Você pensa em todos que te ajudaram a chegar aqui e pensa que não pode decepcioná-los.");
	        System.out.println("Você sente algo mudando dentro de você e decide colocar todos os presentes que ganhou no caminho a frente da grande porta de Opala:\n");
	        System.out.println("Uma Taça do Chapeleiro Louco\n");
	        System.out.println("Um Espelho daquele Gato Roxo\n");
	        System.out.println("Uma Maçã para não ficar com fome\n");
	        System.out.println("Um pingente para não esquecer seu nome. \n");
	        
	        System.out.println("Você sabe o que precisa fazer. Se levanta e escreve a senha na porta: \n");

	        String senhaDigitada = scanner.nextLine();
	        senhaDigitada = removerAcentos(senhaDigitada.toLowerCase());
	        
	    
	        if (senhaDigitada.equals("vgorq")) {
	        	    player.adicionarPontoTrabalhoEmEquipe();
	        	    System.out.println(Colors.TEXT_GREEN_BOLD_BRIGHT + "\n\t\tA porta de Opala começa a tremer e, aos poucos, se abre diante de você.");
	                System.out.println("\t\tA luz brilhante do mundo além da porta invade o seu campo de visão.");
	                System.out.println("\t\tVocê sente um alívio e uma gratidão imensa por ter conseguido desvendar o enigma.");
	                System.out.println("\t\tCom um último olhar para o mundo mágico que deixou para trás, você dá um passo adiante e atravessa a porta de opala.");
	                
	                printCharacterSheet();
	                System.out.println(Colors.TEXT_GREEN_BOLD_BRIGHT + "\n\n\t\t\tFim do jogo! Você voltou para o seu mundo com mais 5 minutos!\n\n" + Colors.TEXT_RESET);
	            } else {
	                System.out.println("\n\t\tA porta de Opala treme, mas permanece fechada.");
	                System.out.println("\t\tVocê sente uma pontada de desapontamento e tristeza ao perceber que a senha inserida estava incorreta.");
	                System.out.println("\t\tSerá que você esqueceu algum detalhe ou há mais a desvendar?");

	                System.out.println(Colors.TEXT_GREEN_BOLD_BRIGHT + "\n\n\t\t\tVocê não conseguiu abrir a porta mágica.\n\n" + Colors.TEXT_RESET);
	            }
	        } else {
	            System.out.println("\n\t\tVocê perdeu todas as suas vidas e não conseguiu abrir a porta mágica.");

	            System.out.println(Colors.TEXT_GREEN_BOLD_BRIGHT + "\n\n\t\t\tVocê não conseguiu abrir a porta mágica.\n\n" + Colors.TEXT_RESET);
	        }
	    
	    
	}
	public static String removerAcentos(String texto) {
        return Normalizer.normalize(texto, Normalizer.Form.NFD)
                .replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
    }
	
	public void printCharacterSheet() {
		System.out.println("\n\n\t--- Ficha do Personagem ---");
		System.out.println("\tNome:\t\t\t\t" + player.getName());
		System.out.println("\t--- Distribuição de pontos nos atributos ---");
		System.out.println("\tResponsabilidade Pessoal:\t" + player.getResponsabilidadePessoal());
		System.out.println("\tMentalidade de Crescimento:\t" + player.getMentalidadeDeCrescimento());
		System.out.println("\tProatividade:\t\t\t" + player.getProatividade());
		System.out.println("\tOrientação ao Detalhe:\t\t" + player.getOrientacaoAoDetalhe());
		System.out.println("\tTrabalho em Equipe:\t\t" + player.getTrabalhoEmEquipe());
		System.out.println("\n\n");
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
