package game.repository;

import game.model.Opponent;

public interface OpponentRepository {

	public void createOpponent(Opponent opponent);
	public void readOpponent();
	public void updateOpponent(Opponent opponent);
	public void deleteOpponent(Opponent opponent);
	
}