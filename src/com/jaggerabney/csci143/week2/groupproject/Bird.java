package com.jaggerabney.csci143.week2.groupproject;

import java.util.Random;

public class Bird implements Critter {
	@SuppressWarnings("unused")
	private int x, y;

	// This is our no argument constructor.
	public Bird() {

	}

	public Bird(int x, int y) {
		this.x = x;
		this.y = y;
	}

	// this method returns the character B
	public char getChar() {
		return 'B';
	}

	public int getMove(CritterInfo info) {

		// this will generate a random number.
		Random randN = new Random();
		// this variable will then generate a random number 0-3.
		int directionValue = randN.nextInt(4);
		if (directionValue == 0) {
			// this will move to the east.
			x++;
			return Critter.EAST;
		} else if (directionValue == 1) {
			// this will move to the west.
			x--;
			return Critter.WEST;
		} else if (directionValue == 2) {
			// this will move to the north.
			y--;
			return Critter.NORTH;
		} else
			// this will move to the south.
			y++;
		return Critter.SOUTH;

	}

}
