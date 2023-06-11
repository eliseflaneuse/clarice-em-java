package game.model;

import java.util.Scanner;

public class Player extends Character {

	private int lifePoints;
	private int responsabilidadePessoal;
	private int mentalidadeDeCrescimento;
	private int proatividade;
	private int orientacaoAoDetalhe;

	public Player(String name, int level, int attributePoints) {
		super(name, level, attributePoints); // Invoke the constructor of the Character class
		this.lifePoints = 3;
		this.responsabilidadePessoal = 0;
		this.mentalidadeDeCrescimento = 0;
		this.proatividade = 0;
		this.orientacaoAoDetalhe = 0;
	}

	public int getLifePoints() {
		return lifePoints;
	}

	public void setLifePoints(int lifePoints) {
		this.lifePoints = lifePoints;
	}

	public void decreaseLifePoints() {
		lifePoints--;
	}

	public int getResponsabilidadePessoal() {
		return responsabilidadePessoal;
	}

	public void setResponsabilidadePessoal(int points) {
		responsabilidadePessoal += points;
	}

	public int getMentalidadeDeCrescimento() {
		return mentalidadeDeCrescimento;
	}

	public void setMentalidadeDeCrescimento(int points) {
		mentalidadeDeCrescimento += points;
	}

	public int getProatividade() {
		return proatividade;
	}

	public void setProatividade(int points) {
		proatividade += points;
	}

	public int getOrientacaoAoDetalhe() {
		return orientacaoAoDetalhe;
	}

	public void setOrientacaoAoDetalhe(int points) {
		orientacaoAoDetalhe += points;
	}

	public void increaseLifePoints() {
		lifePoints++;
	}

	@Override
	public void read() {
		System.out.println("\n--- Ficha do Personagem ---");
		System.out.println("Nome: " + getName());
		System.out.println("Nível: " + getLevel());
	}

	public static void distributeAttributePoints(Player player, Scanner scanner) {
		int remainingPoints = 10;

		System.out.println("--- Distribua os Pontos de Atributo ---");

		while (remainingPoints > 0) {
			System.out.println("Pontos restantes: " + remainingPoints);
			System.out.println("1. Responsabilidade Pessoal");
			System.out.println("2. Mentalidade de Crescimento");
			System.out.println("3. Proatividade");
			System.out.println("4. Orientação ao Detalhe");
			System.out.print("Escolha um atributo para distribuir os pontos (1-4): ");

			int choice = scanner.nextInt();
			scanner.nextLine(); // Consume the newline character

			if (choice < 1 || choice > 4) {
				System.out.println("Invalid choice. Please choose again.");
				continue;
			}

			System.out.print("Enter the number of points to allocate: ");
			int points = scanner.nextInt();
			scanner.nextLine(); // Consume the newline character

			if (points < 0 || points > remainingPoints) {
				System.out.println("Invalid number of points. Please choose again.");
				continue;
			}

			switch (choice) {
			case 1:
				player.setResponsabilidadePessoal(points);
				break;
			case 2:
				player.setMentalidadeDeCrescimento(points);
				break;
			case 3:
				player.setProatividade(points);
				break;
			case 4:
				player.setOrientacaoAoDetalhe(points);
				break;
			}

			remainingPoints -= points;
		}

		System.out.println("\n\n--- Character Sheet ---");
		System.out.println("Nome:\t\t\t\t" + player.getName());
		System.out.println("--- Distribua os pontos nos atributos ---");
		System.out.println("Responsabilidade Pessoal:\t" + player.getResponsabilidadePessoal());
		System.out.println("Mentalidade de Crescimento:\t" + player.getMentalidadeDeCrescimento());
		System.out.println("Proatividade:\t\t\t" + player.getProatividade());
		System.out.println("Orientação ao Detalhe:\t\t" + player.getOrientacaoAoDetalhe());
		System.out.println("\n\n\n");
	}

}