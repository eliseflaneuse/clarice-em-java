<h1 align="center"> 
    Clarice em Javaland
</h1>

<div align="center">
  <img src="https://github.com/eliseflaneuse/clarice-em-java/assets/113945437/52f19d43-f6fe-4594-b4d6-7b573ad75f7d" alt="Image" />
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

Como esta organizado o projeto?
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
<img src=https://github.com/eliseflaneuse/clarice-em-java/assets/113945437/1b4ac2ed-b13c-4642-a6f5-6509ac1e7d88 alt="Image" />
</div>

## Implementação: 

### 1. Definir classes e atributos

Vamos começar definindo as classes e atributos básicos do jogo. Teremos as seguintes classes:

Game: Classe principal que contém main que roda o jogo.
Character: Classe base para representar o personagem do jogador e personagens inimigos.
Player: Subclasse de Character que representa o personagem do jogador.
Opponent: Subclasse de Character que representa os personagens inimigos.

```
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

```
public interface GameRepository {
    void iniciarJogo();
    void exibirMenu();
    void jogar();

}

```

### 3. Implementar a lógica dos métodos de sobrescrita da interface

Agora que temos as classes básicas criadas, podemos partir para a lógica de funcionamento do jogo. Primeiramente vamos criar o menu principal.

```
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

```
public void iniciarJogo() {

		ArtLibrary.printWelcomeMessage();
		ArtLibrary.printMonteJavaArt();

		System.out.printf("\n\tInforme o nome do jogador:");
		String nomeJogador = scanner.nextLine();

		player = new Player(nomeJogador, 5, 5, 3, 0, 0, 0, 0, 0);

		player.printCharacterSheet();

	}
```

```
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

```
private void cenaChapeleiroLouco() {}
private void cenaGatoChester() {}
private void cenaCoelhoCintoMinutos() {}
private void cenaRainhaCopas() {}
private void cenaDecifrarCodigoPortaMagica() {}
```
