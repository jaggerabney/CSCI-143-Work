import acm.graphics.*;
import acm.program.GraphicsProgram;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.event.MouseInputAdapter;

import java.io.*;

public class Breakout extends GraphicsProgram {
    private Config config;
    private GCanvas game;

    @Override
    public void init() {
        // inits necessary components
        this.config = new Config("/resources/config.properties");
        this.game = new GCanvas();

        // configures the window
        this.setSize(config.getIntProp("APPLICATION_WIDTH"), config.getIntProp("APPLICATION_HEIGHT"));
        this.setTitle(config.getStringProp("TITLE"));

        // configures game (the GCanvas where the actual game components are drawn)
        game.setSize(config.getIntProp("WIDTH"), config.getIntProp("HEIGHT"));

        // adds game to the window, and a MouseMotionListener to game
        this.add(game, new GPoint(0, 0));
        game.addMouseMotionListener(new MouseHandler());
    }

    @Override
    public void run() {
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
}

class MouseHandler extends MouseInputAdapter {
    @Override
    public void mouseMoved(MouseEvent e) {
        // System.out.println(e);
    }
}
