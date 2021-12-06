import java.awt.*;
import acm.graphics.*;

// Displays the player's score, and any Powerup messages
public class Scoreboard extends GCanvas {
  // fields
  private int score, updatesUntilTextReset, updatesUntilServe, numLives;
  private String activePowerupEffect;
  private GRect background;
  private GLabel text;

  public Scoreboard(int width, int height) {
    // inits fields and adds them accordingly
    super();
    setSize(width, height);
    this.score = 0;
    this.background = new GRect(width, height);
    this.text = new GLabel("Score: " + score);
    background.setColor(Color.GRAY);
    background.setColor(new Color(248, 248, 248));
    background.setFilled(true);
    add(background);
    // text is added to the center
    add(text, (getWidth() / 2) - (text.getWidth() / 2),
        (getHeight() / 2) + (text.getHeight() / 2));
    text.sendForward();
  }

  // used when the window is resized
  public void windowResize(int width, int height) {
    setSize(width, height);
    background.setSize(width, height);
    text.setLocation((width / 2) - (text.getWidth() / 2), (height / 2) + (text.getHeight() / 4));
  }

  // utilized by Bricks when a brick is destroyed
  public void addScore(int scoreToAdd, boolean doublePointsActive) {
    score += (doublePointsActive) ? scoreToAdd * 2 : scoreToAdd;
  }

  // utilized when a powerup is activated;
  // displays a message about what powerup was gained
  public void powerupActivated(String activePowerupEffect, int updatesUntilTextReset) {
    this.activePowerupEffect = activePowerupEffect;
    this.updatesUntilTextReset = updatesUntilTextReset;
  }

  public void serve(int numLives, int updatesUntilServe) {
    this.updatesUntilServe = updatesUntilServe;
    this.numLives = numLives;
  }

  // updates according to active powerups
  public void update(Powerups powerups) {
    if (activePowerupEffect != null) {
      if (updatesUntilTextReset > 0) {
        setText(activePowerupEffect + " activated!");
        updatesUntilTextReset--;
      } else {
        setText("Score: " + score);
      }
    } else {
      setText("Score: " + score);
    }
  }

  public void setText(String string) {
    text.setLabel(string);
    text.setLocation((background.getWidth() / 2) - (text.getWidth() / 2),
        (background.getHeight() / 2) + (text.getHeight() / 4));
  }
}
