package model;

import java.io.Serializable;

public class Player implements Serializable{
	private int py = 3;
	private int px = 2;
	
	public Player() {}

	public int getPy() {
		return py;
	}

	public int getPx() {
		return px;
	}
	
	
}
