<div># Clarice em Java </div>

![image](https://github.com/eliseflaneuse/clarice-em-java/assets/113945437/52f19d43-f6fe-4594-b4d6-7b573ad75f7d)

Ideia geral: *Um jogo rpg em java.*
Usando:
* classes, atributos e objetos; 
* encapsulamento e herança, polimorfismo, sobrecarga e sobrescrito;
* collections, exceptions, options;

A ideia é de um jogo no console, onde o personagem faz uma ficha com nome e distribui 10 pontos em atributos. Logo depois ele vai ser mostrado uma pergunta de cada vez no console, revezando uma pergunta lógica e uma pergunta engraçada e absurda (como no filme "monty python"). Se ele acertar a pergunta engraçada ele ganha um ponto de vida (o personagem começa com 5 pontos) e se errar ele perde. Na pergunta lógica ele ganha um ponto para atribuir a algum atributo, logo ele precisaria ler a escolha do usuario de onde colocar o ponto ganhado.  Os personagens inimigos são inspirados nos personagens de Alice no país das maravilhas. Todas as perguntas lógicas são sobre programação java e vão aumentando o nível de dificuldade.

## Implementação: 

### 1. Definir classes e atributos

Vamos começar definindo as classes e atributos básicos do jogo. Teremos as seguintes classes:

Game: Classe principal que contém o loop principal do jogo.
Character: Classe base para representar o personagem do jogador e personagens inimigos.
Player: Subclasse de Character que representa o personagem do jogador.
Enemy: Subclasse de Character que representa os personagens inimigos.

```
public class Game {
    public static void main(String[] args) {
        // Implementação do loop principal do jogo
    }
}

public class Character {
    private String name;
    private int lifePoints;
    // Outros atributos comuns a personagens

    // Construtor, getters e setters
}

public class Player extends Character {
    private int attributePoints;
    // Outros atributos específicos do jogador

    // Construtor, getters e setters
}

public class Enemy extends Character {
    // Atributos específicos de inimigos

    // Construtor, getters e setters
}
```
### 2. Implementar a lógica do jogo

Agora, vamos implementar a lógica do jogo. Isso inclui a criação do personagem do jogador, a distribuição dos pontos de atributos, a exibição de perguntas lógicas e engraçadas, e a interação com o jogador para receber suas respostas e atualizar o estado do jogo.

```
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Criação do personagem do jogador
        System.out.print("Digite o nome do personagem: ");
        String playerName = scanner.nextLine();
        Player player = createPlayer(playerName);

        // Distribuição dos pontos de atributos
        distributeAttributePoints(player, scanner);

        // Iniciar o jogo
        boolean gameOver = false;
        while (!gameOver) {
            // Lógica do jogo (exibir perguntas, interagir com o jogador, atualizar estado, etc.)
        }

        scanner.close();
    }

    private static Player createPlayer(String name) {
        // Implementação para criar o personagem do jogador com nome e atributos iniciais
    }

    private static void distributeAttributePoints(Player player, Scanner scanner) {
        // Implementação para distribuir os pontos de atributos para o jogador
    }
}

```

### 3. Implementar perguntas lógicas e engraçadas

Agora, precisamos criar perguntas lógicas e engraçadas para o jogo. Podemos criar uma classe separada para armazenar as perguntas e suas respostas corretas, e uma lógica para selecionar aleatoriamente as perguntas para exibir aos jogadores.
Ideia para perguntas engraçadas (cena da ponte do filme Mount Python) [http://montypython.50webs.com/scripts/Holy_Grail/Scene22.htm]

```
public class Question {
    private String question;
    private String correctAnswer;

    // Construtor, getters e setters
}

public class QuestionManager {
    private List<Question> logicQuestions;
    private List<Question> funnyQuestions;

    // Métodos para adicionar perguntas, selecionar perguntas aleatoriamente, etc.
}

```

Ideias:
* Python - cobrinha
* Java - vida (café) ganhar ou perder ponto - abaixo de 0 o programa sai.
* JavaScript - ação (efeitos especiais)
* CSS - roupa (estilização)
* Ruby - dinheiro (Ruby on Rails - dinheiro no trem - interceptar o trem?)
* `String proatividade = 4;`
* Categoria - front, back, full-stack
* Cada categoria ganha mais pontos como herança;
* Habilidades
* Uma missão principal - 3 desafios (métodos)
* Podemos dar pontos no início.
* 10 pontos
* `int inteligencia = 3;`
* `int destreza = 2;`

## BSM - Atributos
### Mentalidades 
- RESPONSABILIDADE PESSOAL
- MENTALIDADE DE CRESCIMENTO
- ORIENTAÇÃO PARA O FUTURO
- PERSISTÊNCIA

### Habilidades Comportamentais
- COMUNICAÇÃO
- TRABALHO EM EQUIPE
- PROATIVIDADE
- ORIENTAÇÃO AO DETALHE


## História, desafios lógicos no console - jogo de perguntas
Atributos: `int num = 10;` If (`num < 10`) - condição 1, se `num > 10` - condição 2

### DESAFIOS LÓGICOS (AUMENTANDO EM DIFICULDADE) E PERGUNTAS ENGRAÇADAS.
* Pergunta lógica
* Cenário - perder ou ganhar vida
* Pergunta lógica

Esfinge - pergunta x ou y? Passa, ponto de dano - DADO!!! 6, 12, 20. Variável = ganho 2 pontos.

Pergunta de programação - normalizer* - pergunta para passar da porta (meio do Senhor dos Anéis) com resposta escrita - palavra chave.

Esquerda ou direita? (Gato da Alice) - inimigo ou não dá pra avançar.

Loop infinito - game over.

Ideia da ray - viagem no tempo linear (do passado ao futuro) medieval - Mount Pyton piratas sci-fi apocalíptico - mudar as falas no console de acordo com a época. perguntas cada vez mais difíceis.

Começar em um cenário.
Personagens se repetem.

## Narrativa - Storytelling
+5 de proatividade = ajudar pessoa +vida (EVENTO)
Em outro momento - ponto pra distribuir nos atributos (perguntas técnicas)

O grande if - Nível fácil, moderado ou difícil. (se modo hard - atributos trocados)

## Personagens
* Característica única que define o personagem que permanece, como cor ou vestimenta;
* Coelho
* Esfinge - Lagarta - oferece um trago
* Bobo da Corte - Chapeleiro e a Lebre de Março
* Gato Azul Sorridente - oferece bebida (você fica bêbado e a pergunta fica mais difícil)

Vilão Rainha de Copas (carta com 5 - pra representar os minutos)

Visual - Alice dentro da Xícara (Clarice em Java)

BOSS - Yuri o dono do tempo (+5 minutos) - Cortem as cabeças;

