package com.lucascombinatogato.gamestore.repository;

import org.springframework.data.repository.CrudRepository;

import com.lucascombinatogato.gamestore.model.Game;

public interface GameRepository extends CrudRepository<Game, Integer>{
    
}
