package com.example.jdbcdemo.service;

import java.util.List;

import com.example.jdbcdemo.domain.BoardGame;

public interface BoardGameManager {
	
	public int addBoardGame(BoardGame boardGame);
	public List<BoardGame> getAllBoardGames();
}
