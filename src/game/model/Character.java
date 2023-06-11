package game.model;

public abstract class Character {
	
	private String nome;
	private int vida;
    protected boolean defesaAtiva;
    protected int defesa;

    public Character(String nome, int vida, int defesa) {
        this.nome = nome;
        this.vida = vida;
        this.defesaAtiva = false;
        this.defesa = defesa;
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


	public int getDefesa() {
		return defesa;
	}



	public void setDefesa(int defesa) {
		this.defesa = defesa;
	}



	public abstract boolean atacar(Character alvo);

    public abstract void defender();

    public void receberDano(int dano) {
        int danoRecebido = dano - defesa;
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