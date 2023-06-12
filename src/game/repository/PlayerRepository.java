package game.repository;

import game.model.Player;

public interface PlayerRepository {

	public void createPlayer(Player player);
	public void readPlayer();
	public void updatePlayer(Player player);
	public void deletePlayer(Player player);
	
}