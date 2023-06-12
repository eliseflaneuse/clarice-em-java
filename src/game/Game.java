package game;

import java.text.Normalizer;
import java.util.Scanner;
import java.util.ArrayList;
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
			System.out.println(Colors.TEXT_WHITE_BOLD_BRIGHT + " ");
			System.out.println("\t\t\t\t     ------ Menu ------");
			System.out.println("\t\t\t\t     Escolha uma opção:");
			System.out.println("\t\t\t\t     1. Iniciar Jogo");
			System.out.println("\t\t\t\t     0. Sair do jogo" + Colors.TEXT_RESET);

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
				cenaCoelhoCintoMinutos();
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
			System.out.println(Colors.TEXT_GREEN_BOLD_BRIGHT + "\n\tSua orientação ao detalhe aumentou em um ponto!" + Colors.TEXT_RESET);
			System.out.println("\n\t\tO taverneiro lhe responde, visivelmente alegre:");
			System.out.println(Colors.TEXT_CYAN_BOLD_BRIGHT);
			System.out.println("\tヽ(´▽`)/ 'HAHAHAHAHA eu sabia que você era especial, ");
			System.out.println("\tmuito bem, vamos continuar. Próxima pergunta:"+ Colors.TEXT_RESET);
		}
		else{
			player.decreaseLifePoints();
			System.out.println(Colors.TEXT_RED_BOLD_BRIGHT + "\n\tVocê perdeu um ponto de vida, lhe restam: " + player.getLifePoints() + Colors.TEXT_RESET);
			System.out.println("\n\t\tO taverneiro lhe responde, visivelmente desapontado:");
			System.out.println(Colors.TEXT_CYAN_BOLD_BRIGHT);
			System.out.println("\t(´･_･`) 'Sério mesmo? Esperava mais de você, talvez");
			System.out.println("\to instinto daquela lebre esteja mesmo começando a falhar...");
			System.out.println("\t\tVamos para a próxima pergunta:" + Colors.TEXT_RESET);
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
			System.out.println(Colors.TEXT_RED_BOLD_BRIGHT + "\n\tVocê perdeu um ponto de vida, lhe restam: " + player.getLifePoints()+ Colors.TEXT_RESET);
			System.out.println(Colors.TEXT_CYAN_BOLD_BRIGHT + "\n\tVamos lá, você nem está tentando, essa organização não faz sentido aqui!!"+ Colors.TEXT_RESET);
			errado1 = 0;
			break;

		case 2:
			player.decreaseLifePoints();
			System.out.println(Colors.TEXT_RED_BOLD_BRIGHT + "\n\tVocê perdeu um ponto de vida, lhe restam: " + player.getLifePoints()+ Colors.TEXT_RESET);
			System.out.println(
					Colors.TEXT_CYAN_BOLD_BRIGHT + "\n\tNananinanão, nessa organização os últimos serão os primeiros, você está me decepcionando..."+ Colors.TEXT_RESET);
			errado1 = 0;
			break;

		case 3:
			player.decreaseLifePoints();
			System.out.println(Colors.TEXT_RED_BOLD_BRIGHT + "\n\tVocê perdeu um ponto de vida, lhe restam: " + player.getLifePoints()+ Colors.TEXT_RESET);
			System.out
					.println(Colors.TEXT_CYAN_BOLD_BRIGHT + "\n\tEu nem sequer sei o que é um Hashmap, imagino que muito menos você, pare de chutar!!"+ Colors.TEXT_RESET);
			errado1 = 0;
			break;

		case 4:
			player.adicionarPontoProatividade();
			System.out.println(Colors.TEXT_GREEN_BOLD_BRIGHT + "\n\tVocê ajudou alguém que estava precisando e sua proatividade aumentou em um ponto!"+ Colors.TEXT_RESET);
			System.out.println(
					Colors.TEXT_CYAN_BOLD_BRIGHT + "\n\tHmmm... muito bem, aquele coelho realmente sabe de algo hein? Estou impressionado com você!"+ Colors.TEXT_RESET);
			errado1 = 0;
			break;

		default:
			if (errado1 == 1 ) {
				System.out
						.println(Colors.TEXT_CYAN_BOLD_BRIGHT);
				System.out.println("\tNão ouviu as opções?? Apenas de 1 a 4 forasteire, vamos lá, não tente me enrolar..."+ Colors.TEXT_RESET);
			}
		}
		;
			} catch (InputMismatchException e) {
				System.out.println(Colors.TEXT_CYAN_BOLD_BRIGHT);
				System.out.println("\tEpa epa epa, sem gracinhas forasteire, apenas me responda com números!"+ Colors.TEXT_RESET);
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
			System.out.println(Colors.TEXT_RED_BOLD_BRIGHT + "\n\tVocê perdeu um ponto de vida, lhe restam: " + player.getLifePoints()+ Colors.TEXT_RESET);
			System.out.println(Colors.TEXT_CYAN_BOLD_BRIGHT + "\n\tUm bom chute, mas ainda assim um chute, e você é ruim de mira HAHAHAH ಠ‿ಠ"+ Colors.TEXT_RESET);
			errado2 = 0;
			break;

		case 2:
			player.decreaseLifePoints();
			System.out.println(Colors.TEXT_RED_BOLD_BRIGHT + "\n\tVocê perdeu um ponto de vida, lhe restam: " + player.getLifePoints()+ Colors.TEXT_RESET);
			System.out.println(Colors.TEXT_CYAN_BOLD_BRIGHT + "\n\tSério mesmo? Você realmente achou que seria tão óbvio assim? ಠ_ಠ"+ Colors.TEXT_RESET);
			errado2 = 0;
			break;

		case 3:
			player.adicionarPontoResponsabilidadePessoal();
			System.out.println(Colors.TEXT_GREEN_BOLD_BRIGHT + "\n\tVocê lembrou do que estudou e sua responsabilidade pessoal aumentou em um ponto!"+ Colors.TEXT_RESET);
			System.out.println(
					Colors.TEXT_CYAN_BOLD_BRIGHT + "\n\tMandou bem forasteire, to gostando de ver. Hmmm, bateu uma vontade de comer um wrap. (⊙_◎)"+ Colors.TEXT_RESET);
			errado2 = 0;
			break;

		case 4:
			player.decreaseLifePoints();
			System.out.println(Colors.TEXT_RED_BOLD_BRIGHT + "\n\tVocê perdeu um ponto de vida, lhe restam: " + player.getLifePoints()+ Colors.TEXT_RESET);
			System.out.println(
					Colors.TEXT_CYAN_BOLD_BRIGHT + "\n\tOk, essa é engraçadinha mas não esperava que você fosse escolhê-la, e depois eu que sou o louco..."+ Colors.TEXT_RESET);
			errado2 = 0;
			break;

		default:
			if (errado2 == 1) {
				System.out
						.println(Colors.TEXT_CYAN_BOLD_BRIGHT);
				System.out.println("\tNão ouviu as opções?? Apenas de 1 a 4 forasteire, vamos lá, não tente me enrolar..."+ Colors.TEXT_RESET);
			}
		}
		;
			}catch(InputMismatchException e) {
				System.out.println(Colors.TEXT_CYAN_BOLD_BRIGHT);
				System.out.println("\tEpa epa epa, sem gracinhas forasteire, apenas me responda com números!"+ Colors.TEXT_RESET);
				scanner.nextLine();
			};
		}while(errado2 == 1);

		Story.tchau();
		ArtLibrary.printTaca();
		
		printCharacterSheet();
		
		System.out.println("\n\tContinuando sua jornada...");
	} 

	
// item passar pro jogador 
// Criar o oponente

	private void cenaGatoChester() {
			
		System.out.println("\t Você está perdide no país das maravilhas e encontra-se em um cruzamento de caminhos.");
		System.out.println("\t Está confuse e não sabe qual direção tomar. ");
		System.out.println("\t De repente, o gato sorridente aparece flutuando no ar, ");
		System.out.println("\t com seu corpo desaparecendo aos poucos, deixando apenas seu sorriso largo visível.\n");

		System.out.println("\t Ei, você aí? 'Decifra-me ou te devoro!'\n");

		ArtLibrary.printCheshireCat();
		

		System.out.println(" Vou fazer algumas perguntas para você.\n");
		System.out.println(" O que todo mundo sempre está correndo para pegar, mas nunca consegue segurar?\n");
		System.out.println(" Responda com a primeira letra: ");

		String respostaEnigma = scanner.nextLine();
		
		// try catch - igual do Lê

		if (respostaEnigma.equalsIgnoreCase( "T" )) {


			System.out.println(
					"\t Correto!  Acredito que você esteja buscando maneiras de ganhar alguns minutos extras.\n");
			
		} else {
			System.out.println("\t Incorreto! Dessa maneira, você corre o risco de perder o tempo que lhe resta.\n ");
		
		}

		System.out.println("\t Você continua sua jornada em busca de mais 5 mininutos.\n");
		System.out.println("\t Se deparou com um lindo jardim cheio de flores coloridas!");
		System.out.println("\t Um caminho é cercado por flores amarelas e o outro por flores azuis.\n");

		System.out.println("\t Ah, vejo que está em busca de orientação. Em um lugar como este, a direção a seguir pode ser um enigma." 
		       +"\t Fique atento ao que vou dizer.\n");
		
        System.out.println("\t Teu desafio é decifrar o enigma e desvendar os segredos ocultos neste mundo mágico.\n");
        
		System.out.println("\t Sou a cor do ouro, do tesouro valioso,\r\n" + "\t Símbolo de riqueza e sucesso sem fim.\r\n"
				+ "\t Nas abelhas listradas, sou o distintivo honroso,\r\n"
				+ "\t E nas estrelas mais brilhantes, sou seu matiz enfim\n.  ");

		String caminhoEscolhido = "C";
		int errado = 1;

		do {

			System.out.println("\t Qual caminho você vai escolher: A - Flores amarelas ou B - Flores azuis?\n");
			caminhoEscolhido = scanner.next();

			if (caminhoEscolhido.equalsIgnoreCase("A")) {
				System.out.println("\t Escolheu o caminho das flores amarelas.\n");
				System.out.println("\t Parabéns, destemide viajante! Ao escolher o caminho das flores amarelas, você desbloqueou um poderoso presente: um espelho mágico,\n" 
				+ "\t imbuido de antigas energias que irão iluminar seu caminho nesta jornada desafiadora.");
				errado = 1;

			} else if (caminhoEscolhido.equalsIgnoreCase("B")) {
				System.out.println("\t Escolheu o caminho das flores azuis.\n");
				System.out.println("\t  Você ganhou um espelho mágico, no entanto, não será uma caminhada fácil.\n"
				+"\t Grandes desafios se erguerão à sua frente, testando sua coragem, inteligência e determinação."); 

				errado = 1;

			} else {
				errado = 0;
				System.out.println("\t Opção inválida\n");

			}
		} while (errado == 0);

	}
	
	private void cenaCoelhoCintoMinutos() {
		System.out.println("\n Você encontrou o Coelho que lhe deu mais 5 minutos!");
		System.out.println(Colors.TEXT_BLUE + "\n Você então fica bem pensative sobre tudo o que está acontecendo e se lembra também que é " 
				+ "\n preciso encontrar o coelho! Depois de muito procurar, quando menos espera encontrou ele e "
				+ "\n então foram dadas as notícias..." + Colors.TEXT_RESET);
		
		ArtLibrary.printCoelho();
		
		System.out.println(Colors.TEXT_BLUE + "\n - Oh, estava te procurando! Eu tenho algo para te contar, mas não sei se "
			+ "\n esse é o momento mais adequado, como te contar e como vai lidar com essa notícia..."
			+ "\n É algo de extrema importância, peço que não se apavore... O relógio não está comigo!" + Colors.TEXT_RESET);
		
		System.out.println(Colors.TEXT_RED + "\n Logo você é dominade pela fúria, já que precisava tanto daquele relógio para conseguir voltar!"
				+ "\n Pensa consigo mesma: Por que isso está acontecendo comigo? Logo hoje! Eu já não estou entendendo nada "
				+ "\n e acontece isso! Não quero mais perder tempo aqui, quero os 5 minutos logo... O coelho nota toda sua fúria e "
				+ "\n percebe que precisa fazer algo..." + Colors.TEXT_RESET);
		
		System.out.println(Colors.TEXT_BLUE + "\n - Opa opa, peço que não fique tão brave! Temos uma solução! "
				+ "\n Mas tome uma maçã, mastigar acalma um pouco..." + Colors.TEXT_RESET);


		ArtLibrary.printMaca();
		
		System.out.println(Colors.TEXT_BLUE + "\n - Oras, me diga logo qual é essa solução! E obrigada pela maçã, vou guardar para quando "
				+ "\n conseguir ter o relógio! Disse ainda furiose... " + Colors.TEXT_RESET);
		
		System.out.println(Colors.TEXT_BLUE + "\n O coelho te observa por um instante e então prossegue dizendo: "
				+ "\n - Veja ali, aquele relógio flutuante, a rainha pegou o meu e transformou nisso... "
				+ "\n É preciso recuperar ele e mudar a conexão, pois agora existe uma vínculo entre eles"
				+ "\n e tanto eu quanto você precisamos dele, meu relógio favorito que perdi na floresta e a "
				+ "\n rainha transformou naquilo, aí aí... Ah, sim, os seus 5 minutos também, você precisa "
				+ "\n aqueles minutos que tanto deseja! Por favor, recupere ele!" + Colors.TEXT_RESET);
		
		ArtLibrary.printRelogioFlutuante();
		
		System.out.println(Colors.TEXT_BLUE + "\n - Já não reconheço o relógio. As configurações básicas de conexão podem estar dentro dessa coisa voadora. "
				+ "\n O tempo está voando literalmente. Quando pega-lo, quebre as asas com cuidado. Diga a chave em binário corretamente. "
				+ "\n Evite um erro catastrófico que faria você voltar no tempo. E estabeleceremos uma conexão entre você e o relógio. "
				+ "\n Por favor, devolva-o para que eu não fique atrasado depois. Assim adicionaremos seus 5 minutos e vamos ter tempo para "
				+ "\n realizar nossos sonhos, não é por nada, mas seu mundo é estranho" + player.getName() + "Precisamos muito de sua ajuda!" + Colors.TEXT_RESET);
		
		ArtLibrary.printOutroRelogio();
		
		System.out.println(Colors.TEXT_CYAN + "\n\n ...Chegou a hora de uma grande decisão..."
				+ "\n\n ...Preste bem atenção..." + Colors.TEXT_RESET);
        System.out.println(Colors.TEXT_CYAN + "\n É de seu desejo continuar?");

        System.out.print("\n Escolha sabiamente: (Bora/Não): ");
        String opcao = scanner.nextLine();

        if (opcao.equalsIgnoreCase("bora")) {
            boolean acertou = false;
            for (int i = 0; i < 2; i++) {
            	System.out.println(Colors.TEXT_CYAN + "\n\t Isso é algo diário, "
        				+ "\n\t digamos que primário, "
        				+ "\n\t nao se digitar, use o seu imaginário, "
        				+ "\n\t mas lembre-se que é binário, "
        				+ "\n\t pois começa de modo involuntário..." + Colors.TEXT_RESET);
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
			
        System.out.println("\n Então vamos continuando em sua jornada...");
}

	private void cenaCriquetRainhaCopas() {
		
		int opcao, opcao2, desafio, pontos = 0;
		int respostas[] = { 3, 2, 1 };

		String perguntas[] = { "\n\nPergunta 1: O País Java é repleto de criaturas mágicas e objetos encantados."
				+ "				\nAlgumas delas são guardiãs de itens valiosos que não podem cair em mãos erradas."
				+ "				\nProteger locais secretos e impedir que objetos sejam tocados por seres sem permissão"
				+ "				\né de responsabilidade de duas dessas criaturas."
				+ "				\n\nEscolha a alternativa que melhor representa esse aspecto:"
				+ "				\n1 - Método Construtor"
				+ "				\n2 - Private, Protected e Public"
				+ "				\n3 - Getters e Setters",

				"\n\nPergunta 2: O objeto roubado da Rainha estava em seu quarto, em uma caixa de jóias, e agora a caixa está vazia."
				+ "\n\nQual o nome da classe especial em Java para tratar essa exceção? (objetos nulos/vazios)"
				+ "\n1 - Try-catch"
				+ "\n2 - Optional"
				+ "\n3 - Exception",

				"\n\nPergunta 3: A Rainha resolveu implementar a pena máxima para aqueles que roubam objetos reais."
				+ "\nPara isso ela criou o método cortarACabeça(Player player); em uma Interface.java utilizando você como parâmetro"
				+ "\n\nQual das palavras abaixo a Rainha precisa escrever para usar essa interface em uma ClasseController"
				+ "\ne assim conseguir importar o método criado?"
				+ "\n1 - implements"
				+ "\n2 - extends"
				+ "\n3 - interface" };

		System.out.println("\nOlhe todas essas flores deslumbrantes e esse jardim impecável.");
		
		do {

			System.out.println("\nParece um dia perfeito para explorar o País Java...");
			System.out.println(
					"\nEspere! Tem alguém gritando ao longe, mas a essa distância você não consegue compreender o que está acontecendo.");
			System.out.println(
					"O que deseja fazer?\n" + "\n1 - Aproximar-se" + "\n2 - Afastar-se" + "\n3 - Permanecer onde está");

			try {
				opcao = scanner.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Exceção: " + e);
				scanner.nextLine();
				opcao = 0;
			}

			switch (opcao) {
			case 1 -> {
				System.out.println("\nCORTEM-LHE AS CABEÇAAAAAS!!!");
				System.out.println("Uma das cartas lhe diz que a Rainha está furiosa porque um objeto valioso com o");
				System.out.println(
						"emblema da coroa sumiu. Aparentemente foi roubado e ninguém sabe quem é o responsável.");
				System.out.println(
						"Você precisa descobrir esse mistério e enfrentar o temperamento perigoso da Rainha de Copas para avançar ao "
								+ "próximo nível.");
				System.out.println("O que deseja fazer?\n" + "\n1 - Perguntar qual objeto foi roubado"
						+ "\n2 - Ignorar a carta" + "\n3 - Sair");

				try {
					opcao2 = scanner.nextInt();
				} catch (InputMismatchException e) {
					System.out.println("Exceção: " + e);
					scanner.nextLine();
					opcao2 = 0;
				}

				switch (opcao2) {
				case 1 -> {

					do {

						System.out.println("\nVOCÊ ROUBOU MINHAS CARTAAAAAS!!! - gritou a Rainha de Copas");
						System.out.println("\nEu não roubei nada! - você responde");
						System.out.println("\nApesar da sua inocência, a Rainha te desafia para um duelo.");
						System.out.println("\"Se é realmente inocente, prove-me em um duelo Java!!!\"");
						System.out.println("\nAceita o desafio? \n1 - Sim | 2 - Não");

						desafio = scanner.nextInt();

					} while (desafio != 1 && desafio != 2);

					if (desafio == 1) {
						System.out.println("\nVocê não tinha ideia do que era um duelo Java, mas aceitou.");
						System.out.println(
								"As personagens se posicionaram em lados opostos do cenário e magicamente uma tela apareceu.");
						System.out.println("Na tela lê-se os seguintes dizeres:");

						for (var i = 0; i < 3; i++) {

							System.out.println(perguntas[i]);

							var resposta = scanner.nextInt();

							if (resposta == respostas[i]) {
								System.out.println("Correto");
								pontos++;
							} else {
								System.out.println("Incorreto");
								pontos--;
							}
						}

						if (pontos == 3) {
							System.out.println("\nParabéns, você conseguiu derrotar a Rainha de Copas!");
							System.out.println(
									"Como reconhecimento ao seu empenho, ganhou um item e mais 2 pontos de vida!");
							System.out.println("\nItem: Um PINGENTE com a inicial do seu nome");

							// Inserir método de adicionar item e ganhar vida
							jogar();

						}
						if (pontos < 3 && pontos >= 1) {
							System.out.println("\nVocê estava indo bem, mas algo deu errado e te fez retornar ao início. Tente novamente!");

							jogar();

						}

						if (pontos < 1) {
							System.out.println("\nA Rainha de Copas saiu vitoriosa!");

							jogar();
						}

					}

					if (desafio == 2) {
						System.out.println("Infelizmente você não é páreo para os perigos da Rainha.");
						System.out.println("Sua jornada encerra aqui.");
					}

					if (desafio != 1 && desafio != 2) {
						System.out.println("\nPor favor, escolha uma opção válida na próxima tentativa.");
					}
				}
				case 2 -> {
					System.out.println("Você ignorou o Valete de Espadas e retornou ao início.");
				}
				case 3 -> {
					System.exit(0);
				}
				}

			}

			case 2 -> {
				System.out.println("Talvez você ainda não esteja tão preparado para a nossa aventura.");
				System.out.println("Pode voltar outra hora, quando se sentir pronto.");
				System.out.println("1 - Sair do jogo | 2 - Retornar");

				opcao = scanner.nextInt();

				if (opcao == 1) {
					System.exit(0);
				} else {
					System.out.println("\nVocê escolheu retornar. Como eu dizia...");
				}
			}

			case 3 -> {
				System.out.println(
						"\nÉ um jardim esplêndido, de tirar o fôlego! Exceto pela multidão que se aproxima.\n");
				System.out.println(
						"Está um alvoroço aqui! Você acaba de ser atingido acidentalmente por alguém e perdeu 2 pontos de vida.");

				// Inserir método de perder vida e ficha personagem

				System.out.println("O que deseja fazer?");
				System.out.println("1 - Sair do jogo | 2 - Retornar");

				opcao = scanner.nextInt();

				if (opcao == 1) {
					System.exit(0);
				} else {
					System.out.println("\nVocê escolheu retornar. Como eu dizia...");
				}
			}

			}

		} while (true);
			
	}

	private void cenaDecifrarCodigoPortaMagica() {
	    System.out.println(Colors.TEXT_GREEN_BOLD_BRIGHT + "\n\tVocê separa as últimas folhas das árvores em seu caminho"
	    		+ " e se depara com umas das maiores porta que já viu.");
	    System.out.println("\tEla parece ter muitas palvras e letras brilhando um verde ofuscantes em ondas, ");
	    System.out.println("\tcomo se a porta fosse feita inteira de Opala.");
	    System.out.println("\tVocê dá um passo em direção à ela.\n\n\n\n" + Colors.TEXT_RESET);
	    		
	    
	    ArtLibrary.printMagicDoor();
	    
	    System.out.println(Colors.TEXT_GREEN_BOLD_BRIGHT +  "\t\tDe canto de olho você percebe uma movimentação mas não consegue se esconder a tempo! ");
	    System.out.println("\tDuas cartas enormes aparecem no seu caminho. Uma com os desenhos de 3 de copas a outra 2 de paus.");
	    System.out.println("\tAmbas empunham lanças afiadíssimas. Elas te olham com desdém.\n\n" + Colors.TEXT_RESET);
	    System.out.println("\n\n");

	    ArtLibrary.printCards();

	    System.out.println(Colors.TEXT_GREEN_BOLD_BRIGHT + "\t\t3 de copas: Pare! Ninguém passa sem a permissão da Rainha de Copas!" );
	    System.out.println("\t2 de paus: Isso mesmo! Prepare-se para enfrentar a nossa fúria!\n" );

	    System.out.println("\tVocê se aproxima das cartas, pronte para o confronto.\n");
	    System.out.println("\t" + player.getName() + ": Eu enfrentei desafios incríveis para chegar até aqui e reunir os 4 itens do segredo.");
	    System.out.println("\tAgora, desejo voltar ao meu mundo, e essa porta é o caminho. Por favor, deixem-me passar!\n" );

	    System.out.println("\t3 de copas: Hahaha! Achou que seria fácil, humana insolente?");
	    System.out.println("\t2 de paus: Prepare-se para a batalha final!"); 
	    System.out.println("\tNós somos as guardiãs da Rainha de Copas e não permitiremos sua passagem sem luta!\n");

	    System.out.println("\tVocê se prepara para o combate contra as cartas da Rainha de Copas.");
	    System.out.println("\tQue assim seja! Eu mostrarei a vocês do que sou capaz!" + Colors.TEXT_RESET);


	    // Criando as cartas da Rainha de Copas
	
	    Opponent carta1 = new Opponent("3 de copas", 2, 2, 1 , "lança");
	    Opponent carta2 = new Opponent("2 de paus", 2, 2, 1 , "lança");

	    
	    boolean vitoria = false;
	    int currentPlayerAttack = 1;

	    while (!vitoria && player.getLifePoints() > 0) {
	        System.out.println(Colors.TEXT_WHITE_BOLD_BRIGHT + "\n\tOpções:");
	        System.out.println("\t1. Atacar a primeira carta");
	        System.out.println("\t2. Atacar a segunda carta");
	        System.out.println("\t3. Defender" + Colors.TEXT_RESET);

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
	                System.out.println("\tA carta " + currentCard.getName() + " contra-atacou! Cuidado!");
	            }
	        } else {
	            System.out.println("\tOpção inválida! Tente novamente.");
	        }
	    }

	    if (vitoria) {
	    	System.out.println("\n\n\n");
	        System.out.println(Colors.TEXT_GREEN_BOLD_BRIGHT + "\t\tDepois de uma árdua batalha contra as cartas furiosas da Rainha de Copas, " );
	        System.out.println("\tvocê finalmente está diante da imponente porta e uma mensagem misteriosa é revelada em sua superfície:\n");
	        System.out.println("\tPara essa porta passar,");
	        System.out.println("\tEssa cifra terá que decifrar,");
	        System.out.println("\tDuas casas pular,");
	        System.out.println("\tPara 'César' transformar em 'eguct'.\n\n");
	        
	        System.out.println("\tEmbasbacade com a mensagem, você se desespera. "
	        		+ "Depois de todas essas provações, ");
	        System.out.println("\tserá que você não vai conseguir voltar pra casa?");
	        System.out.println("\tVocê pensa em todos que te ajudaram a chegar aqui e pensa que não pode decepcioná-los.");
	        System.out.println("\tVocê sente algo mudando dentro de você e decide colocar todos os presentes ");
	        System.out.println("\tque ganhou no caminho a frente da grande porta de Opala:\n");
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
 
 * PlayerController players = new
 * PlayerController(); OpponentController opponents = new OpponentController();

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

 */
