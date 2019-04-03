package com.ndcc.registration.playerRegistration.service;

import com.ndcc.registration.playerRegistration.Repository.PlayerRegisterInterface;
import com.ndcc.registration.playerRegistration.entity.Player;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PlayerServiceImpl implements PlayerService {

    private static final Logger logger = LogManager.getLogger(PlayerServiceImpl.class);

    @Autowired
    PlayerRegisterInterface playerRegister;

    @Override
    public void registerPlayer(Player player) {
        playerRegister.save(player);
    }

    @Override
    public List<Player> getPlayer() {
        logger.info("Retrieved the players");
        return (List<Player>) playerRegister.findAll();
    }

    @Override
    public Player findById(long id) {
        Optional<Player> player = playerRegister.findById(id);
        if(player.isPresent()){
            logger.info("Player is Found");
            return player.get();
        } else {
            logger.error("Player is not Found");
            return null;
        }
    }

    @Override
    public Player update(Player player, long l) {
        logger.info("Updated the player");
        return playerRegister.save(player);
    }

    @Override
    public void deletePlayerById(long id) {
        logger.info("Delete the player");
        playerRegister.deleteById(id);
    }

    @Override
    public Player updatePlayersEmail(Player player, long id) {
        Player player1 = findById(id);
        player1.setEmail(player.getEmail());
        logger.info("update the player's email ID");
        return playerRegister.save(player1);
    }
}
