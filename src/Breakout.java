import acm.graphics.*;
import acm.program.GraphicsProgram;
import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;

public class Breakout extends GraphicsProgram implements ComponentListener {
    private Config config;
    private Game game;
    private Scoreboard scoreboard;
    private boolean isRunning;
    public final static int MENU_BAR_HEIGHT = 23;

    @Override
    public void init() {
        // loads props
        this.config = new Config("/resources/config.properties");
        // inits Scoreboard, as it is rendered on a different GCanvas than Game
        this.scoreboard = new Scoreboard(config.getIntProp("WIDTH"), MENU_BAR_HEIGHT);
        // inits Game
        this.game = new Game(config, scoreboard);
        this.isRunning = true;

        // inits variables and adds the necessary components to the window
        Dimension windowSize = new Dimension(config.getIntProp("APPLICATION_WIDTH"),
                config.getIntProp("APPLICATION_HEIGHT"));

        this.setTitle(config.getStringProp("TITLE"));
        this.setSize(windowSize);

        this.add(scoreboard, new GPoint(0, 0));
        this.add(game, new GPoint(0, scoreboard.getHeight()));
        addComponentListener(this);
    }

    @Override
    public void run() {
        // inits a bunch of variables to do the following:
        // while the window is running, the time between game updates and
        // "frames" (invocations of game.repaint()) are kept track of
        // to ensure that the game doesn't go too fast.
        // by default, this code makes the game update 60 times a second.
        // frames are rendered in the meantime, but since no update occurs,
        // nothing happens, so in effect, this locks the game to 60fps
        final double nsPerUpdate = 1000000000.0 / config.getDoubleProp("FRAME_LIMIT");
        long lastTime = System.nanoTime();
        double unprocessedTime = 0;
        int frames = 0;
        int updates = 0;
        long frameCounter = System.currentTimeMillis();

        while (isRunning) {
            long currentTime = System.nanoTime();
            long passedTime = currentTime - lastTime;
            lastTime = currentTime;
            unprocessedTime += passedTime;

            if (unprocessedTime >= nsPerUpdate) {
                unprocessedTime = 0;
                updates++;
                game.update();
            }
            game.repaint();
            frames++;

            if (System.currentTimeMillis() - frameCounter >= 1000) {
                System.out.println("Frames: " + frames + ", updates: " + updates);
                frames = 0;
                updates = 0;
                frameCounter += 1000;
            }
        }
    }

    @Override
    public void componentResized(ComponentEvent e) {
        // updates Scoreboard and Game when the window is resized
        scoreboard.windowResize(e.getComponent().getWidth(), MENU_BAR_HEIGHT);
        game.windowResizeHandler(e);
    }

    @Override
    public void componentMoved(ComponentEvent e) {
    }

    @Override
    public void componentShown(ComponentEvent e) {
    }

    @Override
    public void componentHidden(ComponentEvent e) {
    }
}

// Helper class used to load constants from config.properties
class Config {
    private Properties props;

    public Config(String configPropertiesPath) {
        this.props = loadProps(configPropertiesPath);
    }

    private Properties loadProps(String path) {
        try {
            InputStream is = Breakout.class.getResourceAsStream(path);
            Properties props = new Properties();

            props.load(is);

            return props;
        } catch (IOException ioe) {
            ioe.printStackTrace();
            return null;
        }
    }

    public int getIntProp(String key) {
        return Integer.parseInt(props.getProperty(key));
    }

    public String getStringProp(String key) {
        return props.getProperty(key);
    }

    public double getDoubleProp(String key) {
        return Double.parseDouble(props.getProperty(key));
    }
}
