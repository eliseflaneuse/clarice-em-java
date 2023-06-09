package game.controller;

import java.util.ArrayList;
import game.model.Player;
import game.repository.PlayerRepository;

public class PlayerController implements PlayerRepository {

	private ArrayList<Player> playerList = new ArrayList<Player>();

	@Override
	public void createPlayer(Player player) {
		playerList.add(player);
		System.out.println("A personagem " + player.getName() + " foi criada com sucesso!");
	}

	@Override
	public void readPlayer() {
		for (var player : playerList) {
			player.read();
		}
	}

	@Override
	public void updatePlayer(Player player) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deletePlayer(Player player) {
		// TODO Auto-generated method stub

	}

}