package game.util;

public abstract class Character {
	
	private String nome;
	private int vida;
    protected boolean defesaAtiva;
    protected int defesaAtual;

    public Character(String nome, int vida) {
        this.nome = nome;
        this.vida = vida;
        this.defesaAtiva = false;
        this.defesaAtual = 0;
    }

   

    public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public int getVida() {
		return vida;
	}



	public void setVida(int vida) {
		this.vida = vida;
	}


	public abstract boolean atacar(Character alvo);

    public abstract void defender();

    public void receberDano(int dano) {
        int danoRecebido = dano - defesaAtual;
        if (danoRecebido > 0) {
            vida -= danoRecebido;
            System.out.println(nome + " recebeu " + danoRecebido + " de dano.");
        } else {
            System.out.println(nome + " se defendeu totalmente.");
        }

        if (vida <= 0) {
            System.out.println(nome + " foi derrotado.");
        }
    }
	
}
