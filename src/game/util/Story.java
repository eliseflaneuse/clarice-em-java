package game.util;

public class Story {
	
//	print story part
	public static void Introduction() {
		System.out.println("\t\tVocê caminha pelo túnel escuro enquanto as palavras daquele coelho ");
		System.out.println("\tecoam na sua mente: 'Me siga e terá mais 5 minutos para realizar suas ");
		System.out.println("\tatividades.', isso antes dele disparar na sua frente pelo túnel. ");
		System.out.println("\t\tSaindo da escuridão, você enxerga um pequeno vilarejo na encosta de montes ");
		System.out.println("\tnevados, e decide que sua melhor opção é caminhar até a maior construção");
		System.out.println("\tque vê, o que aparenta ser uma taverna. Passando pela porta, sua");
		System.out.println("\tatenção é voltada para um sujeito peculiar atrás do balcão.\n");	
	}
//	padrão de 6 linhas por bloco, adicionar frase do coelho ali em cima e adicionar numeros/logica nos personagens da taverna
	public static void Introduction2() {
		System.out.println("\n\t\tVocê caminha até o balcão, observando o ambiente da taverna e vendo");
		System.out.println("\tque algumas figuras peculiares te observam, como troncos de árvores ambulantes,");
		System.out.println("\tnúmeros e sinais matemáticos com pernas e braços, e nesse momento você percebe");
		System.out.println("\tque é a exceção daqui. O taverneiro, vestido como se estivesse fantasiado de ");
		System.out.println("\tum mágico, com cartola e tudo, fala contigo assim que você se senta num banco:");
		System.out.println(Colors.TEXT_CYAN_BOLD_BRIGHT);
		System.out.println("\t\t'Hahahaha oláááá ☜(⌒▽⌒)☞, estávamos esperando por você!! Você precisa de algo, não é??");
		System.out.println("\tAh não, nada disso, primeiro tenho que te fazer algumas perguntas, sabe como é né,");
		System.out.println("\tregras da casa, pra garantir que você não é nenhum 'tipo estranho' hihihi...'" + Colors.TEXT_RESET);
	}
	
	public static void Pergunta1() {
		System.out.println(Colors.TEXT_CYAN_BOLD_BRIGHT + "\n\t\tVamos lá, primeira pergunta, atenção hein:"+ Colors.TEXT_RESET);
		System.out.println(Colors.TEXT_WHITE_BOLD_BRIGHT);
		System.out.println("\tEu sou aquilo que tudo devora: pássaros, feras, flores, árvores,");
		System.out.println("\teu como ferro, mordo aço; trituro pedras duras para fazer farinha; mato reis,");
		System.out.println("\tdestruo cidades; e derrubo altas montanhas. Quem sou eu?"+ Colors.TEXT_RESET);
	}
	
	public static void Pergunta2() {
		System.out.println(Colors.TEXT_CYAN_BOLD_BRIGHT);
		System.out.println("\n\t\tTa vendo uns números ambulantes ali? Então, estão com um problemão, são aspirantes");
		System.out.println("\ta soldados e querem entrar na divisão Java do exército real, precisam se organizar");
		System.out.println("\tpara que o primeiro a se alistar seja o primeiro a fazer o teste de recrutamento."+ Colors.TEXT_RESET);
		System.out.println(Colors.TEXT_WHITE_BOLD_BRIGHT);
		System.out.println("\tMe diga, qual a melhor estrutura de organização para eles? (Responda com o número)"+ Colors.TEXT_RESET);
		System.out.println("\n\t1. Array");
		System.out.println("\t2. Pilha");
		System.out.println("\t3. Hashmap");
		System.out.println("\t4. Fila");
	}
	
	public static void pergunta3() {
		System.out.println(Colors.TEXT_CYAN_BOLD_BRIGHT);
		System.out.println("\n\t\tVamos lá, última pergunta, essa é bem fácil hein. Eu tenho um chá especial que");
		System.out.println("\tenvolve quem tomar em uma aura que os torna versões diferenciadas de si. Por exemplo,");
		System.out.println("\taquele Dois ambulante ali no canto, era apenas um número int mirradinho, um pequeno dois");
		System.out.println("\tprimitivo, mas depois de tomar o meu chá se transformou em um Inteiro, um grande Dois, ");
		System.out.println("\tforte como um Objeto digno de se colecionar"+ Colors.TEXT_RESET);
		System.out.println(Colors.TEXT_WHITE_BOLD_BRIGHT);
		System.out.println("\tAgora me responda, forasteire, qual o nome do meu chá? (Responda com o número)"+ Colors.TEXT_RESET);
		System.out.println("\n\t1. Chá Iterator");
		System.out.println("\t2. Chá de Objeto");
		System.out.println("\t3. Chá Wrapper");
		System.out.println("\t4. Xácomigo");
	}
	
	public static void tchau() {

		System.out.println(Colors.TEXT_CYAN_BOLD_BRIGHT);
		System.out.println("\n\t\tMuito bem, deu pra ver que você pelo menos se esforça, acho que vai se");
		System.out.println("\tdar bem por aqui, o faro daquela lebre continua apurado hehehe. Aliás, falando na lebre,");
		System.out.println("\teu a vi correndo em direção à floresta, murmurando algo sobre tempo e um campo florido,");
		System.out.println("\tsiga pela estrada de terra que leva até a floresta e você não vai se perder. AH, leve isso com você,");
		System.out.println("\tacho que pode te ajudar em algum momento!"+ Colors.TEXT_RESET);
		System.out.println(Colors.TEXT_GREEN_BOLD_BRIGHT);
		System.out.println("\n\tVocê recebeu uma taça!"+ Colors.TEXT_RESET);

	}

}