package game.model;

public class Player extends Character {
		
	   
	   private int responsabilidadePessoal;
	   private int mentalidadeDeCrescimento;
	   private int proatividade;
	   private int orientacaoAoDetalhe; //Le
	   private int trabalhoEmEquipe;
	   
		   
	  public Player(String name, int lifePoints, int defense, int damage, int responsabilidadePessoal,
				int mentalidadeDeCrescimento, int proatividade, int orientacaoAoDetalhe, int trabalhoEmEquipe) {
			super(name, lifePoints, defense, damage);
			this.responsabilidadePessoal = responsabilidadePessoal;
			this.mentalidadeDeCrescimento = mentalidadeDeCrescimento;
			this.proatividade = proatividade;
			this.orientacaoAoDetalhe = orientacaoAoDetalhe;
			this.trabalhoEmEquipe = trabalhoEmEquipe;
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

		public int getTrabalhoEmEquipe() {
			return trabalhoEmEquipe;
		}


		public void setTrabalhoEmEquipe(int trabalhoEmEquipe) {
			this.trabalhoEmEquipe = trabalhoEmEquipe;
		}
		
		public void adicionarPontoTrabalhoEmEquipe() {
		    trabalhoEmEquipe += 1;
		}
	
		public void adicionarPontoOrientacaoAoDetalhe() {
			orientacaoAoDetalhe += 1;
		}
		
		public void adicionarPontoProatividade() {
			proatividade += 1;
		}
		
		public void adicionarPontoResponsabilidadePessoal() {
			responsabilidadePessoal += 1;
		}
		
		public void adicionarPontoMentalidadeDeCrescimento() {
			mentalidadeDeCrescimento += 1;
		}

		@Override
		public boolean attack(Character alvo) {
			
		    System.out.println(getName() + " atacou " + alvo.getName() + " causando " + damage + " de dano.");
		    alvo.receberDano(damage);

		    return alvo.getLifePoints() <= 0; // Return true if the target was defeated, false otherwise
		}

		public boolean attack(Opponent inimigo) {

		    System.out.println(getName() + " atacou " + inimigo.getName() + " causando " + damage + " de dano.");
		    inimigo.receberDano(damage);

		    return inimigo.getLifePoints() <= 0; // Return true if the opponent was defeated, false otherwise
		}

	    @Override
	    public void shield() {

	        System.out.println(getName() + " se defendeu, reduzindo o dano recebido em " + defense + ".");
	        defesaAtiva = true;
	    }
	/*	
	@Override
	public void read() {
		
		System.out.println("\n\n--- Character Sheet ---");
		System.out.println("Nome:\t\t\t\t" + player.getName());
		System.out.println("--- Distribua os pontos nos atributos ---");
		System.out.println("Responsabilidade Pessoal:\t" + player.getResponsabilidadePessoal());
		System.out.println("Mentalidade de Crescimento:\t" + player.getMentalidadeDeCrescimento());
		System.out.println("Proatividade:\t\t\t" + player.getProatividade());
		System.out.println("Orientação ao Detalhe:\t\t" + player.getOrientacaoAoDetalhe());
		System.out.println("\n\n\n");
	}
	*/

}
