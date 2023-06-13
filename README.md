<h1 align="center"> 
    Clarice em Javaland
</h1>

<div align="center">
  <img src="https://github.com/eliseflaneuse/clarice-em-java/assets/113945437/18f5bdcb-bc97-4222-9449-9dd055457795" alt="Image" />
</div>



### Ideia geral: *Um jogo rpg em java.*
Usando:
- Entrada e saída de dados;
- Laços Condicionais;
- Laços de Repetição;
- Métodos e Modificadores de acesso;
- Classes, Atributos e Objetos;
- Polimorfismo, Herança e Sobrecarga;
- Classes Abstratas e Interfaces;
- Collections;
- Exceptions.


A ideia é de um jogo no console. Os personagens e inimigos são inspirados nos personagens de Alice no País das Maravilhas. Todas as perguntas lógicas são sobre programação java e vão aumentando o nível de dificuldade.

*PITCH*
Nós criamos um jogo de aventura empolgante em que o jogador assume o papel de um alune da Generation em busca de mais 5 minutos. A história é repleta de desafios intrigantes e enigmas a serem desvendados. Ao longo da jornada, o jogador encontrará obstáculos, enfrentará batalhas e interagirá com personagens não jogáveis. A exploração de diferentes cenários e a coleta de itens especiais serão fundamentais para o progresso na história, revelando segredos e desbloqueando novas áreas. À medida que o jogo avança, o protagonista poderá aprimorar suas habilidades e atributos BSM's (Batalha, Sobrevivência e Magia. Brincadeira!). A busca pelo retorno ao mundo do personagem será repleta de emoção, reviravoltas e decisões impactantes, moldando assim o desfecho da história. Prepare-se para uma jornada emocionante em busca dos preciosos 5 minutos perdidos!

### Passos para rodar a aplicação

1. Dê um fork nesse repositório e se você puder nos dê uma estrelinha!


![image](https://github.com/eliseflaneuse/clarice-em-java/assets/113945437/0fa3a816-5396-4060-853b-741e434c7ef2)

2. Clone o repositório 

```

git clone link do repositório 

```





### Como esta organizado o projeto?
```
game
├── controller
│   ├── OpponentController.java
│   └── PlayerController.java
├── model
│   ├── Character.java
│   ├── Opponent.java
│   └── Player.java
├── repository
│   ├── GameRepository.java
│   ├── OpponentRepository.java
│   └── PlayerRepository.java
└── util
│   ├── ArtLibrary.java
│   ├── Colors.java
│   ├── ColorsTest.java
│   ├── Story.java
└── Game.java
```

O jogo começa com os atributos BSM's zerados: 

<div align="center">
<img src="https://github.com/eliseflaneuse/clarice-em-java/assets/113945437/9d6d197b-ed00-467b-9e88-b89150097def" alt="Image" />
</div>

## Implementação: 

### 1. Definir classes e atributos

Vamos começar definindo as classes e atributos básicos do jogo. Teremos as seguintes classes:

Game: Classe principal que contém main que roda o jogo.
Character: Classe base para representar o personagem do jogador e personagens inimigos.
Player: Subclasse de Character que representa o personagem do jogador.
Opponent: Subclasse de Character que representa os personagens inimigos.

```java
public class Game {
    public static void main(String[] args) {
        // Implementação do loop principal do jogo
    }
}

public abstract class Character {
    private String name;
	private int lifePoints;
    protected boolean defesaAtiva;
    protected int defense;
    protected int damage;
    // Outros atributos comuns a personagens

    // Construtor, getters e setters
}

public class Player extends Character {
       private int responsabilidadePessoal;
	   private int mentalidadeDeCrescimento;
	   private int proatividade;
	   private int orientacaoAoDetalhe;
	   private int trabalhoEmEquipe;
    // Outros atributos específicos do jogador

    // Construtor, getters e setters
}

public class Opponent extends Character {
        private String item;
    // Atributos específicos de inimigos

    // Construtor, getters e setters
}
```
### 2. Implementar a interface GameRepository

Agora, vamos implementar a interface do jogo Ela vai permitir a utilização de três métodos importantes para a lógica do jogo: iniciarJogo, exibirMenu e jogar.

```java
public interface GameRepository {
    void iniciarJogo();
    void exibirMenu();
    void jogar();

}

```

### 3. Implementar a lógica dos métodos implementados pela interface - polimorfismo 

Agora que temos as classes básicas criadas, podemos partir para a lógica de funcionamento do jogo. Primeiramente vamos criar o menu principal.

```java
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

```

Sobrescrever o método "iniciarJogo()" que é responsável por iniciar o jogo. O jogador é solicitado a inserir seu nome através da entrada de dados. Em seguida, um novo objeto da classe "Player" é criado, atribuindo o nome do jogador e definindo valores iniciais para os atributos do personagem, como pontos de vida, defesa e dano.


```java
public void iniciarJogo() {

		System.out.printf("\n\tInforme o nome do jogador:");
		String nomeJogador = scanner.nextLine();

		player = new Player(nomeJogador, 5, 5, 3, 0, 0, 0, 0, 0);

	}
```

Sobrescrevemos o método "jogar()" que é responsável por conduzir o jogo em si. Ao iniciar o jogo, o jogador é apresentado a um menu de cenas disponíveis para jogar. Cada cena representa um desafio ou enigma a ser enfrentado. O jogador seleciona uma opção digitando o número correspondente e, em seguida, a função correspondente à cena escolhida é executada. O jogador pode voltar ao menu inicial digitando 0. O jogo continua enquanto o jogador escolher continuar jogando e tiver pontos de vida restantes. Ao finalizar todas as cenas com vida restante, o jogador vence o jogo. Caso contrário, se o jogador perder todas as vidas, ele perde o jogo. Em ambos os casos, uma mensagem final é exibida.


```java
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
				cenaRainhaCopas();
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
```

### 4. Implementar a lógica das Cenas do Jogo 

Decidimos criar a história tendo como base Alice no País das Maravilhas, então cada cena apresenta uma das personagens icônicas dessa história. Cada cena foi desenvolvida por uma pessoa do nosso Dev Team. 

```java
private void cenaChapeleiroLouco() {}
private void cenaGatoChester() {}
private void cenaCoelhoCintoMinutos() {}
private void cenaRainhaCopas() {}
private void cenaDecifrarCodigoPortaMagica() {}
```
