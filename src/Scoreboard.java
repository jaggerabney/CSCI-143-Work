import java.awt.*;
import acm.graphics.*;

public class Scoreboard extends GCanvas {
  private int score;
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

  public void addScore(int scoreToAdd) {
    score += scoreToAdd;
  }

  public void update() {
    text.setLabel("Score: " + score);
  }
}
