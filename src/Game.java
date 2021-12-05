import acm.graphics.*;
import java.awt.*;
import java.awt.event.*;

public class Game extends GCanvas {
  private Config config;
  private Controls controls;
  private Ball ball;
  private Paddle paddle;
  private Bricks bricks;
  private Powerups powerups;
  private Scoreboard scoreboard;

  public Game(Config config) {
    super();
    this.config = config;
    this.controls = new Controls();
    this.bricks = new Bricks(config);
    this.scoreboard = new Scoreboard("bruh");
    addMouseMotionListener(controls);
    addMouseListener(controls);

    add(scoreboard);
    for (int i = 0; i < config.getIntProp("BRICK_ROWS"); i++) {
      for (int j = 0; j < config.getIntProp("BRICKS_PER_ROW"); j++) {
        add(bricks.getBrick(i, j));
      }
    }
  }

  public void update() {
    // ball.update();
    // paddle.update();
    if (bricks != null)
      bricks.update();
    // powerups.update();
    scoreboard.update();
  }

  public void windowResizeHandler(ComponentEvent e) {
    int windowWidth = e.getComponent().getWidth(),
        windowHeight = e.getComponent().getHeight();
    Dimension windowSize = new Dimension(windowWidth, windowHeight);

    this.setSize(windowSize);
    bricks.setBrickWidth(config, windowSize);
  }

  // helper method
  public void destroyBricks(MouseEvent e) {
    GPoint click = controls.getClickPos();

    for (int i = 0; i < config.getIntProp("BRICK_ROWS"); i++) {
      for (int j = 0; j < config.getIntProp("BRICKS_PER_ROW"); j++) {
        Brick brick = bricks.getBrick(i, j);

        if (brick.contains(click)) {
          brick.destroy();
        }
      }
    }
  }
}