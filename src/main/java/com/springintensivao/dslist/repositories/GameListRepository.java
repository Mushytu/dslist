package com.springintensivao.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springintensivao.dslist.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long> {

	
}
