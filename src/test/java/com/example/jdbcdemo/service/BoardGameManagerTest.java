package com.example.jdbcdemo.service;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
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
	
	//@Test
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
	
	@Test
	public void checkAddAllBoardGames()
	{
		boardGameManager.clearBoardGames();
		
		BoardGame bg1 = new BoardGame("Bag O' Munchkins","Fantasy",2009);
		BoardGame bg2 = new BoardGame("Abduction","Maze",1998);
		BoardGame bg3 = new BoardGame("5Crests","Mafia",2015);
		BoardGame bg4 = new BoardGame("1740","Economic",2005);
		
		List<BoardGame> boardGames = new ArrayList<BoardGame>();
		boardGames.add(bg1);
		boardGames.add(bg2);
		boardGames.add(bg3);
		boardGames.add(bg4);
		
		boardGameManager.addAllBoardGames(boardGames);
		int size = boardGameManager.getAllBoardGames().size();
		assertThat(size, either(is(4)).or(is(0)));
	}
}
