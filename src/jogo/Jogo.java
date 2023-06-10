package jogo;

import java.util.Scanner;

import jogo.util.ArtLibrary;
import jogo.util.Jogo;
import jogo.util.Player;

public class Jogo implements JogoInterface{
	private Scanner scanner;
    private Player player;

    public Jogo() {
        scanner = new Scanner(System.in);
    }

    @Override
    public void iniciarJogo() {
        System.out.println("Bem-vindo ao Clarice em Javaland!");
        System.out.println("Informe o nome do jogador:");
        String nomeJogador = scanner.nextLine();
        player = new Player(nomeJogador, 3, 0, 0, 0, 0, 0); // Exemplo: atributos iniciais zerados

        distributeAttributePoints(player, scanner);
    }

    private static void distributeAttributePoints(Player player, Scanner scanner) {
        int remainingPoints = 10;

        System.out.println("\n--- Distribua os Pontos de Atributo ---");

        while (remainingPoints > 0) {
            System.out.println("Pontos restantes: " + remainingPoints);
            System.out.println("1. Responsabilidade Pessoal");
            System.out.println("2. Mentalidade de Crescimento");
            System.out.println("3. Proatividade");
            System.out.println("4. Orientação ao Detalhe");
            System.out.print("Escolha um atributo para distribuir os pontos (1-4): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            if (choice < 1 || choice > 4) {
                System.out.println("Escolha inválida. Por favor, escolha novamente.");
                continue;
            }

            System.out.print("Informe a quantidade de pontos a ser alocada: ");
            int points = scanner.nextInt();
            scanner.nextLine(); 

            if (points < 0 || points > remainingPoints) {
                System.out.println("Quantidade inválida de pontos. Por favor, escolha novamente.");
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

        System.out.println("\n\n--- Ficha do Personagem ---");
        System.out.println("Nome:\t\t\t\t" + player.getNome());
        System.out.println("--- Distribuição de pontos nos atributos ---");
        System.out.println("Responsabilidade Pessoal:\t" + player.getResponsabilidadePessoal());
        System.out.println("Mentalidade de Crescimento:\t" + player.getMentalidadeDeCrescimento());
        System.out.println("Proatividade:\t\t\t" + player.getProatividade());
        System.out.println("Orientação ao Detalhe:\t\t" + player.getOrientacaoAoDetalhe());
        System.out.println("\n\n\n");
    }


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
    public void jogar() {
        System.out.println("\nIniciando o jogo...");

        cenaChapeleiroLouco();
        if (player.getVida() > 0) {
            cenaGatoChester();
        }
        if (player.getVida() > 0) {
            cenaCoelhoCincoMinutos();
        }
        if (player.getVida() > 0) {
            cenaCriquetRainhaCopas();
        }
        if (player.getVida() > 0) {
            cenaDecifrarCodigoPortaMagica();
        }

        if (player.getVida() > 0) {
            System.out.println("\nParabéns! Você completou todas as cenas e venceu o jogo!");
        } else {
            System.out.println("\nQue pena! Você perdeu todas as suas vidas e não conseguiu completar o jogo.");
        }

        System.out.println("Fim do jogo. Obrigado por jogar!");
    }


    private void cenaChapeleiroLouco() {
        System.out.println("\nVocê encontrou o Chapeleiro Louco!");

        System.out.println("O Chapeleiro Louco começa a fazer perguntas estranhas e lógicas ao mesmo tempo...");

        System.out.println("\n--- Perguntas Lógicas ---");
        System.out.println("1. Bruxas são queimadas.");
        System.out.println("   Madeira é queimada.");
        System.out.println("   Portanto, bruxas são feitas de madeira.");
        System.out.print("   Verdadeiro (V) ou Falso (F)? ");
        String resposta1 = scanner.nextLine();

        System.out.println("\n2. Madeira flutua na água.");
        System.out.println("   Patos flutuam na água.");
        System.out.println("   Portanto, se uma mulher pesar tanto quanto um pato ela é feita de madeira.");
        System.out.print("   Verdadeiro (V) ou Falso (F)? ");
        String resposta2 = scanner.nextLine();

        System.out.println("\n--- Perguntas Absurdas ---");
        System.out.println("1. Por que o pássaro voa para o sul no inverno?");
        System.out.println("   a) Porque é mais quente no sul.");
        System.out.println("   b) Porque ele esqueceu o guarda-chuva em casa.");
        System.out.println("   c) Porque é um pássaro migratório.");
        System.out.print("   Escolha a opção correta (a, b ou c): ");
        String resposta3 = scanner.nextLine();

        System.out.println("\n2. O que acontece quando você divide por zero em programação Java?");
        System.out.println("   a) O programa trava e exibe uma mensagem de erro.");
        System.out.println("   b) O resultado é infinito.");
        System.out.println("   c) O universo entra em colapso.");
        System.out.print("   Escolha a opção correta (a, b ou c): ");
        String resposta4 = scanner.nextLine();

        // Verificação das respostas
        int Vida = player.getVida();

        if (resposta1.equalsIgnoreCase("V")) {
            System.out.println("Resposta correta! Bruxas são feitas de madeira.");
        } else {
            System.out.println("Resposta incorreta! Bruxas são feitas de madeira.");
            Vida--;
        }

        if (resposta2.equalsIgnoreCase("V")) {
            System.out.println("Resposta correta! Uma mulher é feita de madeira para boiar na água.");
        } else {
            System.out.println("Resposta incorreta!");
            Vida--;
        }

        if (resposta3.equalsIgnoreCase("b")) {
            System.out.println("Resposta correta! O pássaro voa para o sul no inverno porque ele esqueceu o guarda-chuva em casa.");
        } else {
            System.out.println("Resposta incorreta! O pássaro voa para o sul no inverno porque ele esqueceu o guarda-chuva em casa.");
            Vida--;
        }

        if (resposta4.equalsIgnoreCase("a")) {
            System.out.println("Resposta correta! Quando você divide por zero em programação Java, o programa trava e exibe uma mensagem de erro.");
        } else {
            System.out.println("Resposta incorreta! Quando você divide por zero em programação Java, o programa trava e exibe uma mensagem de erro.");
            Vida--;
        }

        player.setVida(Vida);

        System.out.println("\n--- Resultado ---");
        System.out.println("Pontos de Vida: " + Vida);

        // Verifica se o jogador ainda tem pontos de vida
        if (Vida <= 0) {
            System.out.println("Você perdeu todas as suas vidas. Fim de jogo!");
            return;
        }

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
        System.out.println("\nVocê encontrou uma porta mágica que requer um código para abrir!");
    }

    public static void main(String[] args) {
        Jogo jogo = new Jogo();
        jogo.exibirMenu();
    }
	
	
	
	//public static void main(String[] args) {
		
		
		/*
		 * 
		 * 
		Scanner scanner = new Scanner(System.in);
		
		printWelcomeMessage();
		ArtLibrary.printMonteJavaArt();
		
		// Create the player character
		   
        System.out.print("\n\tDigite o nome da sua personagem: ");
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
        System.out.println("==============================================================================================");

        // Print message with padding
        //System.out.printf("%" + ((70 - messageLength) / 2 + messageLength) + "s%n", welcomeMessage);
        System.out.println(" ____  _            _                                ___                  _                 _ ");
        System.out.println("/   _\\| |          (_)                              |_  |                | |               | |");
        System.out.println("| /  \\| | __ _ _ __ _  ___ ___    ___   _ __ ___      | | __ ___   ____ _| | __ _ _ __   __| |");
        System.out.println("| |   | |/ _` | '__| |/ __/ _ \\  / _ ` | '_ ` _ \\     | |/ _` \\ \\ / / _` | |/ _` | '_ \\ / _` |");
        System.out.println("| \\__/| | (_| | |  | | (_|  __/ |  _ /  | | | | | /\\__/ | (_| |\\ V / (_| | | (_| | | | | (_| |");
        System.out.println(" \\____|_|\\__,_|_|  |_|\\___\\___|  \\___|  | |_| |_| \\____/ \\__,_| \\_/ \\__,_|_|\\__,_|_| |_|\\__,_|");
        System.out.println("                                                                                                         ");
        
        // Print bottom border
        System.out.println("==============================================================================================\n");
    
    */
    }
}
