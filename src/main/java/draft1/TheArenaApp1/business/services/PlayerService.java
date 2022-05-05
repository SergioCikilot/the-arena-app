package draft1.TheArenaApp1.business.services;


import draft1.TheArenaApp1.entities.model.Player;

import java.util.List;

public interface PlayerService {

     void add(Player player);

     void delete(int id);

     void updatePlayer(Player player);
     List<Player> getAll();

     List<Player> getPlayersByTeam(int teamId);

     Player getByPlayerPlayerId(int playerId);

     String getPlayerAge(Player player);

     void addTeam(int teamId, int playerId);

}
