package com.ndcc.registration.playerRegistration.Repository;

import com.ndcc.registration.playerRegistration.entity.Player;
import org.springframework.data.repository.CrudRepository;

public interface PlayerRegisterInterface extends CrudRepository<Player,Long> {
}
