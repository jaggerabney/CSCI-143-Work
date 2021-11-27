import acm.graphics.*;
import acm.program.GraphicsProgram;
import java.util.*;
import java.io.*;

public class Breakout extends GraphicsProgram {
    private Config config;
    private Game game;
    private boolean isRunning;

    @Override
    public void init() {
        this.config = new Config("/resources/config.properties");
        this.game = new Game(config);
        this.isRunning = true;

        this.setSize(config.getIntProp("APPLICATION_WIDTH"), config.getIntProp("APPLICATION_HEIGHT"));
        this.setTitle(config.getStringProp("TITLE"));
        game.setSize(config.getIntProp("WIDTH"), config.getIntProp("HEIGHT"));

        this.add(game, new GPoint(0, 0));
    }

    @Override
    public void run() {
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
}

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
