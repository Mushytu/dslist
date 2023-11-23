package com.springintensivao.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springintensivao.dslist.dto.GameListDTO;
import com.springintensivao.dslist.entities.GameList;
import com.springintensivao.dslist.projections.GameMinProjection;
import com.springintensivao.dslist.repositories.GameListRepository;
import com.springintensivao.dslist.repositories.GameRepository;

@Service
public class GameListService {
	
	@Autowired
	private GameListRepository gameListRepository;
	
	@Autowired
	private GameRepository gameRepository;

	@Transactional(readOnly = true)
	public List<GameListDTO> findAll(){
		List<GameList> result = gameListRepository.findAll();
		return result.stream().map(x -> new GameListDTO(x)).toList();
	}
	
	@Transactional 
	public void move(Long listId, int sourceIndex, int destinationIndex) {
		List<GameMinProjection> list = gameRepository.searchByList(listId);
		
		GameMinProjection obj = list.remove(sourceIndex);
		list.add(destinationIndex, obj);
		
		int minimum = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
		int maximum = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;
		
		for (int i = minimum; i <= maximum; i++) {
			gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
		}
	}
}
