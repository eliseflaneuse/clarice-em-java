package game.util;

public class Story {
	
//	print story part
	public static void Introduction() {
		System.out.println("\tVocê caminha pelo túnel escuro enquanto as palavras daquele coelho ");
		System.out.println("ecoam na sua mente: 'Me siga e terá mais 5 minutos para realizar suas ");
		System.out.println("atividades.', isso antes dele disparar na sua frente pelo túnel. ");
		System.out.println("\tSaindo da escuridão, você enxerga um pequeno vilarejo na encosta de montes ");
		System.out.println("nevados, e decide que sua melhor opção é caminhar até a maior construção");
		System.out.println("que vê, o que aparenta ser uma taverna. Passando pela porta, sua");
		System.out.println("atenção é voltada para um sujeito peculiar atrás do balcão.\n");	
	}
//	padrão de 6 linhas por bloco, adicionar frase do coelho ali em cima e adicionar numeros/logica nos personagens da taverna
	public static void Introduction2() {
		System.out.println("\n\tVocê caminha até o balcão, observando o ambiente da taverna e vendo");
		System.out.println("que algumas figuras peculiares te observam, como troncos de árvores ambulantes,");
		System.out.println("números e sinais matemáticos com pernas e braços, e nesse momento você percebe");
		System.out.println("que é a exceção daqui. O taverneiro, vestido como se estivesse fantasiado de ");
		System.out.println("um mágico, com cartola e tudo, fala contigo assim que você se senta num banco:");
		System.out.println("\t'Hahahaha oláááá ☜(⌒▽⌒)☞, estávamos esperando por você!! Você precisa de algo, não é??");
		System.out.println("Ah não, nada disso, primeiro tenho que te fazer algumas perguntas, sabe como é né,");
		System.out.println("regras da casa, pra garantir que você não é nenhum 'tipo estranho' hihihi...'");
	}
	
	public static void Pergunta1() {
		System.out.println("\n\t Vamos lá, primeira pergunta, atenção hein:");
		System.out.println("\tEu sou aquilo que tudo devora: pássaros, feras, flores, árvores,");
		System.out.println(" eu como ferro, mordo aço; trituro pedras duras para fazer farinha; mato reis,");
		System.out.println(" destruo cidades; e derrubo altas montanhas. Quem sou eu?");
	}
	
	public static void Pergunta2() {
		System.out.println("\n\t Ta vendo uns números ambulantes ali? Então, estão com um problemão, são aspirantes");
		System.out.println("a soldados e querem entrar na divisão Java do exército real, precisam se organizar");
		System.out.println("para que o primeiro a se alistar seja o primeiro a fazer o teste de recrutamento.");
		System.out.println("Me diga, qual a melhor estrutura de organização para eles? (Responda com o número)");
		System.out.println("\n1. Array");
		System.out.println("2. Pilha");
		System.out.println("3. Hashmap");
		System.out.println("4. Fila");
	}
	
	public static void pergunta3() {
		System.out.println("\n\tVamos lá, última pergunta, essa é bem fácil hein. Eu tenho um chá especial que");
		System.out.println("envolve quem tomar em uma aura que os torna versões diferenciadas de si. Por exemplo,");
		System.out.println("aquele Dois ambulante ali no canto, era apenas um número inteiro mirradinho, um pequeno dois");
		System.out.println("primitivo, mas depois de tomar o meu chá se transformou em um Inteiro, um grande Dois, ");
		System.out.println("forte como um Objeto digno de se colecionar");
		System.out.println("\tAgora me responda, forasteire, qual o nome do meu chá? (Responda com o número)");
		System.out.println("\n1. Chá Iterator");
		System.out.println("2. Chá de Objeto");
		System.out.println("3. Chá Wrapper");
		System.out.println("4. Xácomigo");
	}
	
	public static void tchau() {
		System.out.println("\n\tMuito bem forasteire, deu pra ver que você pelo menos se esforça, acho que vai se");
		System.out.println("dar bem por aqui, o faro daquela lebre continua apurado hehehe. Aliás, falando na lebre,");
		System.out.println("eu vi correndo em direção à floresta, murmurando algo sobre tempo e um campo florido,");
		System.out.println("siga pela estrada de terra que leva até a floresta e você não vai se perder. AH, leve isso com você,");
		System.out.println("acho que pode te ajudar em algum momento!");
		System.out.println("\nVocê recebeu uma taça!");
	}

}
