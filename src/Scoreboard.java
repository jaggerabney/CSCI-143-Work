import acm.graphics.*;

public class Scoreboard extends GCanvas implements Updateable {
  private GLabel text;

  public Scoreboard() {
    this.text = new GLabel(null);
    add(text);
  }

  @Override
  public void update() {
    // TODO: add code here!
  }
}
