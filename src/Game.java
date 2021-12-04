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
    addMouseMotionListener(controls);
    addMouseListener(controls);

    bricks = new Bricks(config);

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
    // scoreboard.update();
    destroyBricks();
  }

  public void destroyBricks() {
    GPoint mousePos = controls.getMousePos();

    for (int i = 0; i < config.getIntProp("BRICK_ROWS"); i++) {
      for (int j = 0; j < config.getIntProp("BRICKS_PER_ROW"); j++) {
        Brick brick = bricks.getBrick(i, j);

        if (brick.contains(mousePos)) {
          brick.destroy();
        }
      }
    }
  }
}