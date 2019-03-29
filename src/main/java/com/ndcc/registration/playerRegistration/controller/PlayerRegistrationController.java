package com.ndcc.registration.playerRegistration.controller;


import java.util.List;

import com.ndcc.registration.playerRegistration.entity.Player;
import com.ndcc.registration.playerRegistration.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping(value={"/player"})
public class PlayerRegistrationController {

    @Autowired
    PlayerService playerService;

    @GetMapping(value = "/{id}",produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Player> getPlayerById(@PathVariable("id") long id){
        System.out.println("Fetching Player with Id :"+ id);

        Player player = playerService.findById(id);

        if(player == null) {
            return new ResponseEntity<Player>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<Player>(player, HttpStatus.OK);
        }
    }

    @PostMapping(value="/register",headers="Accept=application/json")
    public ResponseEntity<Void> registerPlayer(@RequestBody Player player, UriComponentsBuilder ucBuilder){
        System.out.println("Creating Player "+player.getfName());
        playerService.registerPlayer(player);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/player/{id}").buildAndExpand(player.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @GetMapping(value="/get", headers="Accept=application/json")
    public List<Player> getAllPlayers() {
        List<Player> tasks=playerService.getPlayer();
        return tasks;
    }

    @PutMapping(value="/update", headers="Accept=application/json")
    public ResponseEntity<String> updatePlayer(@RequestBody Player currentPlayer)
    {
        System.out.println("sd");
        Player player = playerService.findById(currentPlayer.getId());
        if (player==null) {
            return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
        }
        playerService.update(currentPlayer, currentPlayer.getId());
        return new ResponseEntity<String>(HttpStatus.OK);
    }


    @DeleteMapping(value="/{id}", headers ="Accept=application/json")
    public ResponseEntity<Player> deletePlayer(@PathVariable("id") long id){
        Player user = playerService.findById(id);
        if (user == null) {
            return new ResponseEntity<Player>(HttpStatus.NOT_FOUND);
        }
        playerService.deletePlayerById(id);
        return new ResponseEntity<Player>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping(value="/{id}", headers="Accept=application/json")
    public ResponseEntity<Player> updatePlayersEmail(@PathVariable("id") long id, @RequestBody Player currentPlayer){
        Player player = playerService.findById(id);
        if(player ==null){
            return new ResponseEntity<Player>(HttpStatus.NOT_FOUND);
        }
        Player player1 = playerService.updatePlayersEmail(currentPlayer, id);
        return new ResponseEntity<Player>(player1, HttpStatus.OK);
    }
}
