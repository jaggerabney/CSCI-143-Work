package com.jaggerabney.csci143.week2.groupproject;

import java.util.Random;

public class Frog implements Critter {

	// our world variables
	private int x, y;
	private int counter;
	private int returnValue;

	// this will be our no arugument constructor.
	public Frog() {

	}

	public Frog(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public char getChar() {
		return 'F';
	}

	public int getMove(CritterInfo info) {
		// this will generate a random number.
		Random randN = new Random();
		// this will then generate a random number between 0-3.
		int directionValue = randN.nextInt(4);
		/*
		 * this will check if either our counter and returnValue are equal to 0. Counter
		 * is what allows our Frog to move 3 times in the same direction. returnValue
		 * returns the output given that counter is within bounds.
		 */

		if (counter == 0 || returnValue == 0) {
			counter = 2;

			if (directionValue == 0) {
				// this will move to the east
				x = x + 3;
				returnValue = Critter.EAST;
			} else if (directionValue == 1) {
				// this will move to the west
				x = x - 3;
				returnValue = Critter.WEST;
			} else if (directionValue == 2) {
				// this will move to the north
				y = y - 3;
				returnValue = Critter.NORTH;
			} else {
				// this will move to the south
				y = y + 3;
				returnValue = Critter.SOUTH;
			}
		} else {
			/*
			 * as the program continues running, decrement 1 from our counter, as it
			 * continues to evaluate its relation to the randomly generated direction
			 */
			counter--;
		}

		return returnValue;
	}
}
