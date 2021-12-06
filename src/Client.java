/**
 * Program: Breakout!
 * Authors: Jagger Abney, Emran Nuru, Jeff Nkashama
 * Description: This program is a twist on the Atari classic "Breakout!",
 * where the twist is that there are powerups that the player can collect
 * to help them with beating the game
 */

public class Client {
  public static void main(String[] args) {
    Breakout bo = new Breakout();
    bo.start();
  }
}
