package game;

import java.text.Normalizer;
import java.util.Scanner;
import java.util.InputMismatchException;

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
			System.out.println("\t1. Chapeleiro Louco");
			System.out.println("\t2. Gato de Cheshire");
			System.out.println("\t3. Coelho Branco");
			System.out.println("\t4. Rainha de Copas");
			System.out.println("\t5. Porta mágica");
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
		Story.Introduction();

		ArtLibrary.printChapeleiroLouco();

		Story.Introduction2();

		Story.Pergunta1();

		String resposta1;
		
		
		resposta1 = scanner.nextLine();
		scanner.skip("");
		

		if (resposta1.equalsIgnoreCase("tempo")) {
			player.adicionarPontoOrientacaoAoDetalhe();
			System.out.println("Sua orientação ao detalhe aumentou em um ponto!");
			System.out.println("\nO taverneiro lhe responde, visivelmente alegre:");
			System.out.println("ヽ(´▽`)/ 'HAHAHAHAHA eu sabia que você era especial, ");
			System.out.println("muito bem, vamos continuar. Próxima pergunta:");
		}
		else{
			player.decreaseLifePoints();
			System.out.println("\nVocê perdeu um ponto de vida, lhe restam: " + player.getLifePoints());
			System.out.println("\n\tO taverneiro lhe responde, visivelmente desapontado:");
			System.out.println("(´･_･`) 'Sério mesmo? Esperava mais de você, talvez");
			System.out.println("o instinto daquela lebre esteja mesmo começando a falhar...");
			System.out.println("Vamos para a próxima pergunta:");
		}

//		pergunta 2
		Story.Pergunta2();
		int resposta2 = 0;
		int errado1 = 1;
		do {
			try {
		resposta2 = scanner.nextInt();

		switch (resposta2) {
		case 1:
			player.decreaseLifePoints();
			System.out.println("\nVocê perdeu um ponto de vida, lhe restam: " + player.getLifePoints());
			System.out.println("\nVamos lá, você nem está tentando, essa organização não faz sentido aqui!!");
			errado1 = 0;
			break;

		case 2:
			player.decreaseLifePoints();
			System.out.println("\nVocê perdeu um ponto de vida, lhe restam: " + player.getLifePoints());
			System.out.println(
					"\nNananinanão, nessa organização os últimos serão os primeiros, você está me decepcionando...");
			errado1 = 0;
			break;

		case 3:
			player.decreaseLifePoints();
			System.out.println("\nVocê perdeu um ponto de vida, lhe restam: " + player.getLifePoints());
			System.out
					.println("\nEu nem sequer sei o que é um Hashmap, imagino que muito menos você, pare de chutar!!");
			errado1 = 0;
			break;

		case 4:
			player.adicionarPontoProatividade();
			System.out.println("\nVocê ajudou alguém que estava precisando e sua proatividade aumentou em um ponto!");
			System.out.println(
					"\n Hmmm... muito bem, aquele coelho realmente sabe de algo hein? Estou impressionado com você!");
			errado1 = 0;
			break;

		default:
			if (errado1 == 1 ) {
				System.out
						.println("Não ouviu as opções?? Apenas de 1 a 4 forasteire, vamos lá, não tente me enrolar...");
			}
		}
		;
			} catch (InputMismatchException e) {
				System.out.println("Epa epa epa, sem gracinhas forasteire, apenas me responda com números!");
				scanner.nextLine();
			}
		} while (errado1 == 1);

//		pergunta 3
		Story.pergunta3();

		int resposta3 = 0;
		int errado2 = 1;
		
		do {
			try {
		resposta3 = scanner.nextInt();

		switch (resposta3) {
		case 1:
			player.decreaseLifePoints();
			System.out.println("\nVocê perdeu um ponto de vida, lhe restam: " + player.getLifePoints());
			System.out.println("\nUm bom chute, mas ainda assim um chute, e você é ruim de mira HAHAHAH ಠ‿ಠ");
			errado2 = 0;
			break;

		case 2:
			player.decreaseLifePoints();
			System.out.println("\nVocê perdeu um ponto de vida, lhe restam: " + player.getLifePoints());
			System.out.println("\nSério mesmo? Você realmente achou que seria tão óbvio assim? ಠ_ಠ");
			errado2 = 0;
			break;

		case 3:
			player.adicionarPontoResponsabilidadePessoal();
			System.out.println("\nVocê lembrou do que estudou e sua responsabilidade pessoal aumentou em um ponto!");
			System.out.println(
					"\nMandou bem forasteire, to gostando de ver. Hmmm, bateu uma vontade de comer um wrap. (⊙_◎)");
			errado2 = 0;
			break;

		case 4:
			player.decreaseLifePoints();
			System.out.println("\nVocê perdeu um ponto de vida, lhe restam: " + player.getLifePoints());
			System.out.println(
					"\nOk, essa é engraçadinha mas não esperava que você fosse escolhê-la, e depois eu que sou o louco...");
			errado2 = 0;
			break;

		default:
			if (errado2 == 1) {
				System.out
						.println("Não ouviu as opções?? Apenas de 1 a 4 forasteire, vamos lá, não tente me enrolar...");
			}
		}
		;
			}catch(InputMismatchException e) {
				System.out.println("Epa epa epa, sem gracinhas forasteire, apenas me responda com números!");
				scanner.nextLine();
			};
		}while(errado2 == 1);

		Story.tchau();
		ArtLibrary.printTaca();
		
		System.out.println("\nContinuando sua jornada...");
	}
	}

	private void cenaGatoChester() {
			
		System.out.println(" Você está perdide no país das maravilhas e encontra-se em um cruzamento de caminhos.");
		System.out.println(" Está confuse e não sabe qual direção tomar. ");
		System.out.println(" De repente, o gato sorridente aparece flutuando no ar, ");
		System.out.println(" com seu corpo desaparecendo aos poucos, deixando apenas seu sorriso largo visível.\n");

		System.out.println(" Ei, você aí? 'Decifra-me ou te devoro!'\n");

		ArtLibrary.printCheshireCat();
		
		System.out.println(" Vou fazer algumas perguntas para você.\n");
		System.out.println(" O que todo mundo sempre está correndo para pegar, mas nunca consegue segurar?\n");
		System.out.println(" Responda com a primeira letra.");
		char respostaEnigma = scanner.next().charAt(0);

		if (respostaEnigma == 'T') {

			System.out.println(
					" Correto!  Acredito que você esteja buscando maneiras de ganhar alguns minutos extras.\n");
			
		} else {
			System.out.println(" Incorreto! Dessa maneira, você corre o risco de perder o tempo que lhe resta.\n ");
		
		}

		System.out.println(" Você continua sua jornada em busca de mais 5 mininutos.\n");
		System.out.println(" Se deparou com um lindo jardim cheio de flores coloridas!");
		System.out.println(" Um caminho é cercado por flores amarelas e o outro por flores azuis.\n");

		System.out.println(
				"Gostei de você. Fique atento ao que vou dizer.\n");
		
        System.out.println("Teu desafio é decifrar o enigma e desvendar os segredos ocultos neste mundo mágico.");
        
		System.out.println(" Sou a cor do ouro, do tesouro valioso,\r\n" + " Símbolo de riqueza e sucesso sem fim.\r\n"
				+ " Nas abelhas listradas, sou o distintivo honroso,\r\n"
				+ " E nas estrelas mais brilhantes, sou seu matiz enfim\n.  ");

		char caminhoEscolhido = 'C';
		int errado = 1;

		do {
			System.out.println("Qual caminho você vai escolher: A - Flores amarelas ou B - Flores azuis?\n");
			caminhoEscolhido = scanner.next().charAt(0);

			if (caminhoEscolhido == ('A')) {
				System.out.println(" Escolheu o caminho das flores amarelas.\n");
				System.out.println(" Você ganhou um espelho mágico que te ajudará nessa jornada");
				errado = 1;

			} else if (caminhoEscolhido == ('B')) {
				System.out.println(" Escolheu o caminho das flores azuis.\n");
				System.out.println(" Você perdeu?  ");
				errado = 1;

			} else {
				errado = 0;
				System.out.println("Opção inválida\n");

			}
		} while (errado == 0);

	}
	
	private void cenaCoelhoCintoMinutos() {
			System.out.println("\nVocê encontrou o Coelho que lhe deu mais 5 minutos!");
			System.out.println(Colors.TEXT_BLUE + "\n Você então fica bem pensative sobre tudo o que está acontecendo e se lembra também que é " 
					+ "preciso encontrar o coelho! Depois de muito procurar, quando menos espera encontrou ele e então foram dadas as nóticias..." + Colors.TEXT_RESET);
			
			ArtLibrary.printCoelho();
			
			System.out.println(Colors.TEXT_BLUE + "\n - Oh, estava te procurando! Eu tenho algo para te contar, mas não sei se "
				+ "esse é o momento mais adequado, como te contar e como vai lidar com essa notícia..."
				+ "É algo de extrema importância, peço que não se apavore... O rélogio não está comigo!" + Colors.TEXT_RESET);
			
			System.out.println(Colors.TEXT_RED + "\n Logo você é dominade pela fúria, já que precisava tanto daquele relógio para conseguir voltar!"
					+ "Pensa consigo mesma: Por que isso está acontecendo comigo? Logo hoje! Eu já não estou entendendo nada e acontece isso!"
					+ "Não quero mais perder tempo aqui, quero os 5 minutos logo... O coelho nota toda sua fúria e percebe que precisa fazer algo..." + Colors.TEXT_RESET);
			
			System.out.println(Colors.TEXT_BLUE + "\n - Opa opa, peço que não fique tão brave! Temos uma solução! Mas tome uma maçã, mastigar acalma um pouco..." + Colors.TEXT_RESET);

			ArtLibrary.printMaca();
			
			System.out.println(Colors.TEXT_BLUE + "\n - Oras, me diga logo qual é essa solução! E obrigada pela maçã, vou guardar para quando conseguir"
					+ "ter o relógio! Disse ainda furiose... " + Colors.TEXT_RESET);
			
			System.out.println(Colors.TEXT_BLUE + "\n O coelho te observa por um instante e então prossegue dizendo: "
					+ "- Veja ali, aquele relógio flutuante, a rainha pegou o meu e transformou nisso... "
					+ "É preciso derrotar ela para que possa conseguir recuperar, agora existe uma conexão entre eles"
					+ "e tanto eu quanto você precisamos dele, meu relógio favorito que perdi na floresta e a "
					+ "rainha transformou naquilo, aí aí... Ah, sim, os seus 5 minutos também, você precisa tanto "
					+ "aqueles minutos que tanto deseja! Por favor, recupere ele!" + Colors.TEXT_RESET);
			
			ArtLibrary.printRelogioFlutuante();
			
			System.out.println(Colors.TEXT_BLUE + "\n - Já não reconheço o relógio. As configurações básicas de conexão podem estar dentro dessa coisa voadora. "
					+ "O tempo está voando literalmente. Quando pega-lo, quebre as asas com cuidado. Diga a chave em binário corretamente. "
					+ "Evite um erro catastrófico que faria você voltar no tempo. E estabeleceremos uma conexão entre você e o relógio. "
					+ "Por favor, devolva-o para que eu não fique atrasado depois. Assim adicionaremos seus 5 minutos e vamos ter tempo para "
					+ "realizar nossos sonhos, não é por nada, mas seu mundo é estranho. Precisamos muito de sua ajuda!" + Colors.TEXT_RESET);
			
			ArtLibrary.printOutroRelogio();
			
			System.out.println(Colors.TEXT_CYAN + "\n ... A grande decisão!" + Colors.TEXT_RESET);
			System.out.println(Colors.TEXT_CYAN + "\n Isso é algo diário, "
					+ "digamos que primário, "
					+ "ao se digitar, use o seu imaginário, "
					+ "mas lembre-se que é binário, "
					+ "pois começa de modo involuntário" + Colors.TEXT_RESET);
	        System.out.println(Colors.TEXT_CYAN + "\n É de seu desejo continuar?");

	        System.out.print("\n Escolha sabiamente: (Bora/Não): ");
	        String opcao = scanner.nextLine();

	        if (opcao.equalsIgnoreCase("bora")) {
	            boolean acertou = false;
	            for (int i = 0; i < 2; i++) {
	            	ArtLibrary.printBinario();
	                System.out.print("\n Digite a resposta da charada: ");
	                String resposta = scanner.nextLine();

	                if (resposta.equalsIgnoreCase("01001010")) {
	                    acertou = true;
	                    break;
	                }
	            }

	            if (acertou) {
	                System.out.println("\n Olha só quem é que conseguiu! Meus parábens, já consegue viver bem aqui nesse mundo!");
	            } else {
	                System.out.println("\n Xiii... O que me parece é que não foi dessa vez...");
	            }
	        } else if (opcao.equalsIgnoreCase("não")) {
	            System.out.println("\n Hummm, nessa situação o coelho vai ter que se virar de uma outra maneira e você achar "
	            		+ "outro jeito de ter seus 5 minutos...");
	        } else {
	            System.out.println("\n Opa opa, onde pensa que está indo? Essa opção, não tem não...");
	        }

	        scanner.close();
			
		 }
	
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
	    Opponent carta1 = new Opponent("3 de copas", 2, 2, 1 , "lança");
	    Opponent carta2 = new Opponent("2 de paus", 2, 2, 1 , "lança");

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
	        
	        System.out.println("\tEmbasbacade com a mensagem, você se desespera. "
	        		+ "Depois de todas essas provações, será que você não vai conseguir voltar pra casa?");
	        System.out.println("\tVocê pensa em todos que te ajudaram a chegar aqui e pensa que não pode decepcioná-los.");
	        System.out.println("\tVocê sente algo mudando dentro de você e decide colocar todos os presentes que ganhou no caminho a frente da grande porta de Opala:\n");
	        System.out.println("\tUma Taça do Chapeleiro Louco\n");
	        System.out.println("\tUm Espelho daquele Gato Roxo\n");
	        System.out.println("\tUma Maçã para não ficar com fome\n");
	        System.out.println("\tUm pingente para não esquecer seu nome. \n");
	        
	        System.out.println("\tVocê sabe o que precisa fazer. Se levanta e escreve a senha na porta: \n");

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
