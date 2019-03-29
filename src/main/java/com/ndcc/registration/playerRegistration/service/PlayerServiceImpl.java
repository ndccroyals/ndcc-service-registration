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
        return (List<Player>) playerRegister.findAll();
    }

    @Override
    public Player findById(long id) {
        logger.info("findById", id);
        Optional<Player> player = playerRegister.findById(id);
        if(player.isPresent()){
            return player.get();
        } else {
            return null;
        }
    }

    @Override
    public Player update(Player player, long l) {
        logger.info("update", player);
        return playerRegister.save(player);
    }

    @Override
    public void deletePlayerById(long id) {
        logger.info("deletePlayerById", id);
        playerRegister.deleteById(id);
    }

    @Override
    public Player updatePlayersEmail(Player player, long id) {
        Player player1 = findById(id);
        player1.seteMail(player.geteMail());
        logger.info("updatePlayersEmail", player.geteMail());
        return playerRegister.save(player1);
    }
}
