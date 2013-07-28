package gridframework.view;

import gridframework.controller.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

@Component
public class ViewBasicImpl extends JFrame implements View{

    @Autowired
    private Controller controller;

    @Autowired
    private GridPanel panel;

    @PostConstruct
    private void init(){
        this.setLayout(new BorderLayout());

        KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        manager.addKeyEventDispatcher(new MyDispatcher());

        this.setSize(600, 600);
        this.add(panel, BorderLayout.CENTER);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }


    @Override
    public void updateView() {
        repaint();
    }

    private class MyDispatcher implements KeyEventDispatcher {
        @Override
        public boolean dispatchKeyEvent(KeyEvent e) {
            if (e.getID() == KeyEvent.KEY_PRESSED) {
                controller.keyPressed(e);
            }
            else if (e.getID() == KeyEvent.KEY_TYPED) {
                controller.keyTyped(e);
            }
            return false;
        }
    }
}
