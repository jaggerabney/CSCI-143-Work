import acm.graphics.*;
import java.awt.event.*;

public class Game extends GCanvas {
  private GRect rect;

  public Game() {
    super();
    this.rect = new GRect(0, 0, 25, 25);
    this.add(rect);
  }

  public void update(GPoint mousePos) {
    rect.setLocation(mousePos.getX(), mousePos.getY());
  }
}
