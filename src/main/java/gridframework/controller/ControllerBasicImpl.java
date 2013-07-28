package gridframework.controller;

import gridframework.model.Model;
import gridframework.view.View;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

@Component
public class ControllerBasicImpl implements Controller{

    @Autowired
    private Model model;

    @Autowired
    private View view;

    @Override
    public void cellClicked(int x, int y) {
        if(model.getSelectedCell() != null && model.getSelectedCell().getX()==x && model.getSelectedCell().getY()==y)
            model.turnSelectionDirection();
        else model.selectCell(x, y);
        updateViews();
    }

    @Override
    public void keyPressed(KeyEvent event) {
        switch (event.getKeyCode()){
            case KeyEvent.VK_LEFT: model.move(Model.direction.LEFT, true);
                break;
            case KeyEvent.VK_RIGHT: model.move(Model.direction.RIGHT, true);
                break;
            case KeyEvent.VK_UP: model.move(Model.direction.UP, true);
                break;
            case KeyEvent.VK_DOWN: model.move(Model.direction.DOWN, true);
                break;
            case KeyEvent.VK_SPACE: model.turnSelectionDirection();
                break;
            case KeyEvent.VK_BACK_SPACE: model.eraseCell();
                break;
            case KeyEvent.VK_DELETE: model.eraseCell();
                break;
        }
        updateViews();
    }

    @Override
    public void keyTyped(KeyEvent event) {
        char c = event.getKeyChar();
        if (Character.isLetterOrDigit(c))
            model.inputChar(c);
        updateViews();
    }

    @Override
    public void updateViews(){
        view.updateView();
    }
}
