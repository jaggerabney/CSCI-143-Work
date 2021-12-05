import acm.graphics.*;

public class Scoreboard extends GCanvas implements Updateable {
  private GLabel text;

  public Scoreboard(String initialText) {
    this.text = new GLabel(initialText);
    add(text);
  }

  @Override
  public void update() {
    repaint();
  }
}
