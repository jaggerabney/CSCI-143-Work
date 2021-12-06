import java.awt.*;
import acm.graphics.*;

public class Scoreboard extends GCanvas {
  private int score, updatesUntilTextReset;
  private String activePowerupEffect;
  private GRect background;
  private GLabel text;

  public Scoreboard(int width, int height) {
    super();
    setSize(width, height);
    this.score = 0;
    this.background = new GRect(width, height);
    this.text = new GLabel("Score: " + score);
    background.setColor(Color.GRAY);
    background.setColor(new Color(248, 248, 248));
    background.setFilled(true);
    add(background);
    add(text, (getWidth() / 2) - (text.getWidth() / 2),
        (getHeight() / 2) + (text.getHeight() / 2));
    text.sendForward();
  }

  public void windowResize(int width, int height) {
    setSize(width, height);
    background.setSize(width, height);
    text.setLocation((width / 2) - (text.getWidth() / 2), (height / 2) + (text.getHeight() / 4));
  }

  public void addScore(int scoreToAdd, boolean doublePointsActive) {
    score += (doublePointsActive) ? scoreToAdd * 2 : scoreToAdd;
  }

  public void powerupActivated(String activePowerupEffect, int updatesUntilTextReset) {
    this.activePowerupEffect = activePowerupEffect;
    this.updatesUntilTextReset = updatesUntilTextReset;
  }

  public void update(Powerups powerups) {
    if (activePowerupEffect != null) {
      if (updatesUntilTextReset > 0) {
        text.setLabel(activePowerupEffect + " activated!");
        text.setLocation((background.getWidth() / 2) - (text.getWidth() / 2),
            (background.getHeight() / 2) + (text.getHeight() / 4));
        updatesUntilTextReset--;
      } else {
        text.setLabel("Score: " + score);
      }
    } else {
      text.setLabel("Score: " + score);
    }
  }
}
