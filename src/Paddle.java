import acm.graphics.*;
import java.awt.event.*;
import javax.swing.event.*;

public class Paddle extends GRect implements Updateable {
  public Paddle(double width, double height) {
    super(width, height);
  }

  public Paddle(double x, double y, double width, double height) {
    super(x, y, width, height);
  }

  @Override
  public void update() {
    // TODO: add code here!
  }

  class Controls extends MouseInputAdapter {
    private GPoint mousePos;

    public Controls() {
      this.mousePos = new GPoint(0, 0);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
      this.mousePos = new GPoint(e.getX(), e.getY());
    }

    public double getMouseX() {
      return mousePos.getX();
    }

    public double getMouseY() {
      return mousePos.getY();
    }

    public GPoint getMousePos() {
      return mousePos;
    }
  }
}
