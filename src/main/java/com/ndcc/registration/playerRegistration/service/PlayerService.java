package com.ndcc.registration.playerRegistration.service;

import java.util.List;
import com.ndcc.registration.playerRegistration.entity.Player;

public interface PlayerService {

    public void registerPlayer(Player player);

    public List<Player> getPlayer();

    public Player findById(long id);

    public Player update(Player player, long l);

    public void deletePlayerById(long id);

    public Player updatePlayersEmail(Player player, long id);
}
