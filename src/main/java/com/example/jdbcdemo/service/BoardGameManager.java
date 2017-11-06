package com.example.jdbcdemo.service;

import java.util.List;

import com.example.jdbcdemo.domain.BoardGame;

public interface BoardGameManager {
	
	public int addBoardGame(BoardGame boardGame);
	public List<BoardGame> getAllBoardGames();
	public void addAllBoardGames(List<BoardGame> boardGames);
	public void deleteAllBoardGames(List<BoardGame> boardGames);
}
