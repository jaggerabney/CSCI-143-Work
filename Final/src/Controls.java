import javax.swing.event.MouseInputAdapter;
import acm.graphics.*;
import java.awt.event.*;

// helper class that implements MouseListener and MouseMotionListener
// by extending MouseInputAdapter. provides the mouse position
// to the Paddle so that it can be controlled
public class Controls extends MouseInputAdapter {
  private GPoint mousePos;
  private GPoint clickPos;

  public Controls() {
    this.mousePos = new GPoint(0, 0);
  }

  @Override
  public void mouseMoved(MouseEvent e) {
    this.mousePos = new GPoint(e.getX(), e.getY());
  }

  @Override
  public void mouseClicked(MouseEvent e) {
    this.clickPos = new GPoint(e.getX(), e.getY());
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

  public GPoint getClickPos() {
    return clickPos;
  }
}