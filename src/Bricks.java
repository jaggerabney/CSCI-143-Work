import java.awt.*;
import java.lang.reflect.Field;
import java.util.*;

public class Bricks implements Updateable {
  private Brick[][] bricks;
  private Color[] colors;

  public Bricks(Config config) {
    initBrickColors(config.getStringProp("BRICK_COLORS"));
    initBricks(config);

  }

  @Override
  public void update() {
    // TODO: add code here!
  }

  private void initBricks(Config config) {
    int brickHeight = config.getIntProp("BRICK_HEIGHT"),
        brickRows = config.getIntProp("BRICK_ROWS"),
        bricksPerRow = config.getIntProp("BRICKS_PER_ROW"),
        windowWidth = config.getIntProp("WIDTH"),
        brickSep = config.getIntProp("BRICK_SEP"),
        brickYOffset = config.getIntProp("BRICK_Y_OFFSET"),
        brickWidth = (windowWidth - (bricksPerRow - 1) * brickSep) / bricksPerRow;
    bricks = new Brick[brickRows][bricksPerRow];
    int brickX, brickY;

    System.out.println(windowWidth);

    for (int i = 0; i < brickRows; i++) {
      for (int j = 0; j < bricksPerRow; j++) {
        brickX = (brickWidth + brickSep) * j;
        brickY = (i * (brickHeight + brickSep)) + brickYOffset;
        bricks[i][j] = new Brick(brickX, brickY, brickWidth, brickHeight, colors[i]);
      }
    }
  }

  private void initBrickColors(String colorString) {
    String[] colorStrings = colorString.split(",");
    colors = new Color[colorStrings.length];

    for (int i = 0; i < colors.length; i++) {
      try {
        Field field = Class.forName("java.awt.Color").getField(colorStrings[i].toUpperCase());
        colors[i] = (Color) field.get(null);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  public Brick getBrick(int row, int column) {
    return bricks[row][column];
  }
}
