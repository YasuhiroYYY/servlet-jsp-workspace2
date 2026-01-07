package model;

import java.io.Serializable;

public class Game implements Serializable{
	private int ysize = 5;
	private int xsize = 5;
	private char[][] map = {
			{'.', '.', 'g', '.', '.'},
			{'.', '.', '.', 's', '.'},
			{'.', '.', '.', '.', 'g'},
			{'.', 'p', '.', '.', '.'},
			{'.', '.', '.', 'e', '.'},
	};
	
	public Game() {}

	public int getYsize() {
		return ysize;
	}

	public int getXsize() {
		return xsize;
	}

	public char[][] getMap() {
		return map;
	}
	
	
}
