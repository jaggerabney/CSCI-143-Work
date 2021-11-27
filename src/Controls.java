import javax.swing.event.MouseInputAdapter;
import acm.graphics.*;
import java.awt.event.*;

public class Controls extends MouseInputAdapter {
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