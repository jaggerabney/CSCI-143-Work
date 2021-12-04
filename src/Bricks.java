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
    double brickRows = config.getDoubleProp("BRICK_ROWS"),
        bricksPerRow = config.getDoubleProp("BRICKS_PER_ROW"),
        brickHeight = config.getDoubleProp("BRICK_HEIGHT"),
        windowWidth = config.getDoubleProp("WIDTH"),
        brickSep = config.getDoubleProp("BRICK_SEP"),
        brickYOffset = config.getDoubleProp("BRICK_Y_OFFSET"),
        // 2 pixels are removed from the brick width to account for the brick's borders
        brickWidth = ((windowWidth - bricksPerRow * brickSep) / bricksPerRow) - 2;
    bricks = new Brick[(int) brickRows][(int) bricksPerRow];

    System.out.println(Arrays.toString(
        new double[] { brickRows, bricksPerRow, brickHeight, windowWidth, brickSep, brickYOffset, brickWidth }));

    double brickX, brickY;

    for (int i = 0; i < brickRows; i++) {
      for (int j = 0; j < bricksPerRow; j++) {
        brickX = ((brickWidth + brickSep) * j) + brickSep;
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
