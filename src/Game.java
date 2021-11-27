import acm.graphics.*;

public class Game extends GCanvas {
  private Ball ball;
  private Paddle paddle;
  private Bricks bricks;
  private Powerups powerups;
  private Scoreboard scoreboard;

  public Game() {
    super();
  }

  public void update() {
    ball.update();
    paddle.update();
    bricks.update();
    powerups.update();
    scoreboard.update();
  }
}