package game.controller;

import java.util.ArrayList;
import game.model.Opponent;
import game.repository.OpponentRepository;

public class OpponentController implements OpponentRepository {

	private ArrayList<Opponent> opponentList = new ArrayList<Opponent>();

	@Override
	public void createOpponent(Opponent opponent) {
		opponentList.add(opponent);
		System.out.println("\nO oponente " + opponent.getName() + " foi criado com sucesso!");
	}

	@Override
	public void readOpponent() {
		for (var opponent : opponentList) {
			opponent.read();
		}
	}

	@Override
	public void updateOpponent(Opponent opponent) {

	}

	@Override
	public void deleteOpponent(Opponent opponent) {
		
	}
	
	public Opponent searchOpponent(String name) {
		for (var opponent : opponentList) {
			if (opponent.getName() == name) {
				return opponent;
			}
		}
		return null;
	}

}