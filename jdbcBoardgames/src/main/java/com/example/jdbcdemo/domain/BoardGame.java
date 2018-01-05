package com.example.jdbcdemo.domain;

public class BoardGame {
	
	private long id;
	private String name;
	private String type;
	private int yearPublished;
	
	public BoardGame()
	{
	}
	
	public BoardGame(String name, String type, int yearPublished)
	{
		super();
		this.name = name;
		this.type = type;
		this.yearPublished = yearPublished;
	}
	public long getId(){
		return id;
	}
	public void setId(long id)
	{
		this.id = id;
	}
	public String getName(){
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getType(){
		return type;
	}
	public void setType(String type){
		this.type = type;
	}
	public int getYearPublished()
	{
		return yearPublished;
	}
	public void setYearPublished(int yearPublished)
	{
		this.yearPublished = yearPublished;
	}
}
