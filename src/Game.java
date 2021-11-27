import acm.graphics.*;

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
  }

  public void update() {
    // ball.update();
    // paddle.update();
    // bricks.update();
    // powerups.update();
    // scoreboard.update();
  }
}