import acm.graphics.*;
import acm.program.GraphicsProgram;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.event.MouseInputAdapter;
import java.io.*;

public class Breakout extends GraphicsProgram {
    private Config config;
    private Game game;
    private Controls controls;
    private boolean isRunning;

    @Override
    public void init() {
        // inits necessary components
        this.config = new Config("/resources/config.properties");
        this.game = new Game();
        this.controls = new Controls();
        this.isRunning = true;

        // configures the window
        this.setSize(config.getIntProp("APPLICATION_WIDTH"), config.getIntProp("APPLICATION_HEIGHT"));
        this.setTitle(config.getStringProp("TITLE"));

        // configures game (the GCanvas where the actual game components are drawn)
        game.setSize(config.getIntProp("WIDTH"), config.getIntProp("HEIGHT"));

        // adds game to the window, and a MouseMotionListener to game
        this.add(game, new GPoint(0, 0));
        game.addMouseMotionListener(controls);
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
                update();
            }
            render();
            frames++;

            if (System.currentTimeMillis() - frameCounter >= 1000) {
                System.out.println("Frames: " + frames + ", updates: " + updates);
                frames = 0;
                updates = 0;
                frameCounter += 1000;
            }
        }
    }

    public void update() {
        game.update(controls.getMousePos());
    }

    public void render() {
        game.repaint();
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

class Controls extends MouseInputAdapter {
    private GPoint mousePos;

    public Controls() {
        this.mousePos = new GPoint(0, 0);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        this.mousePos = new GPoint(e.getX(), e.getY());
        // System.out.println(e);
    }

    public GPoint getMousePos() {
        return mousePos;
    }
}
