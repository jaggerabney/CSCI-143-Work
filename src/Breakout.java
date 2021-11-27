import acm.graphics.*;
import acm.program.GraphicsProgram;
import java.awt.*;
import java.util.*;
import java.io.*;

public class Breakout extends GraphicsProgram {
    @Override
    public void run() {
        Properties props = loadProps("../resources/config.properties");
        props.list(System.out);
    }

    private Properties loadProps(String path) {
        try {
            InputStream is = Breakout.class.getResourceAsStream("/resources/config.properties");
            Properties props = new Properties();

            props.load(is);

            return props;
        } catch (IOException ioe) {
            ioe.printStackTrace();
            return null;
        }
    }
}
