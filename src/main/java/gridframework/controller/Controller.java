package gridframework.controller;

import gridframework.view.View;

import java.awt.event.KeyEvent;
import java.util.List;

public interface Controller {
    public void cellClicked(int x, int y);
    public void keyPressed(KeyEvent event);
    public void keyTyped(KeyEvent event);
    void updateViews();


}
