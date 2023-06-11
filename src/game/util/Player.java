package game.util;


public class Player extends Character {
		
	   private int attributePoints;
	   private int responsabilidadePessoal;
	   private int mentalidadeDeCrescimento;
	   private int proatividade;
	   private int orientacaoAoDetalhe; //Le


	    public Player(String nome, int vida, int attributePoints, int responsabilidadePessoal, int mentalidadeDeCrescimento,
			int proatividade, int orientacaoAoDetalhe) {
		super(nome, vida);
		this.attributePoints = attributePoints;
		this.responsabilidadePessoal = responsabilidadePessoal;
		this.mentalidadeDeCrescimento = mentalidadeDeCrescimento;
		this.proatividade = proatividade;
		this.orientacaoAoDetalhe = orientacaoAoDetalhe;
	}
	    
	    

		public int getAttributePoints() {
			return attributePoints;
		}



		public void setAttributePoints(int attributePoints) {
			this.attributePoints = attributePoints;
		}



		public int getResponsabilidadePessoal() {
			return responsabilidadePessoal;
		}



		public void setResponsabilidadePessoal(int responsabilidadePessoal) {
			this.responsabilidadePessoal = responsabilidadePessoal;
		}



		public int getMentalidadeDeCrescimento() {
			return mentalidadeDeCrescimento;
		}



		public void setMentalidadeDeCrescimento(int mentalidadeDeCrescimento) {
			this.mentalidadeDeCrescimento = mentalidadeDeCrescimento;
		}



		public int getProatividade() {
			return proatividade;
		}



		public void setProatividade(int proatividade) {
			this.proatividade = proatividade;
		}



		public int getOrientacaoAoDetalhe() {
			return orientacaoAoDetalhe;
		}



		public void setOrientacaoAoDetalhe(int orientacaoAoDetalhe) {
			this.orientacaoAoDetalhe = orientacaoAoDetalhe;
		}



		 @Override
		    public void atacar(Character alvo) {
		        int dano = 1; // Dano do ataque

		        System.out.println(getNome() + " atacou " + alvo.getNome() + " causando " + dano + " de dano.");
		        alvo.receberDano(dano);
		    }

		    public void atacar(Opponent inimigo) {
		        int dano = 2; // Dano do ataque específico para cartas

		        System.out.println(getNome() + " atacou " + inimigo.getNome() + " causando " + dano + " de dano.");
		        inimigo.receberDano(dano);
		    }

		    @Override
		    public void defender() {
		        int defesa = 3; // Valor de defesa

		        System.out.println(getNome() + " se defendeu, reduzindo o dano recebido em " + defesa + ".");
		        defesaAtiva = true;
		        defesaAtual = defesa;
		    }
	}

	

