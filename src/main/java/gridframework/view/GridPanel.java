package gridframework.view;

import javax.swing.*;
import java.awt.*;

/**
 * Panel for drawing the game grid
 */
public abstract class GridPanel extends JPanel {
    public abstract void draw(Graphics g);
}
