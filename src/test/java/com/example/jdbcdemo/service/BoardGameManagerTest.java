package com.example.jdbcdemo.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;

import com.example.jdbcdemo.domain.BoardGame;

public class BoardGameManagerTest {
	BoardGameManagerJDBC boardGameManager = new BoardGameManagerJDBC();
	
	private final static String NAME_1 = "The 12 Towers";
	private final static String TYPE_1 = "Medieval";
	private final static int YEARPUBLISHED_1 = 2014;
	
	@Test
	public void checkConnection(){
		assertNotNull(boardGameManager.getConnection());
	}
	
	@Test
	public void checkAdding(){
		
		BoardGame boardGame = new BoardGame(NAME_1, TYPE_1, YEARPUBLISHED_1);
		
		boardGameManager.clearBoardGames();
		assertEquals(1,boardGameManager.addBoardGame(boardGame));
		
		List<BoardGame> boardGames = boardGameManager.getAllBoardGames();
		BoardGame boardGamesRetrieved = boardGames.get(0);
		
		assertEquals(NAME_1, boardGamesRetrieved.getName());
		assertEquals(TYPE_1, boardGamesRetrieved.getType());
		assertEquals(YEARPUBLISHED_1, boardGamesRetrieved.getYearPublished());
		
	}
}
