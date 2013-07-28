package sudoku.view;

import gridframework.view.GridPanelBasicImpl;

import java.awt.*;

@org.springframework.stereotype.Component
public class GridPanelSudokuImpl extends GridPanelBasicImpl {

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(4));
        for(int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                g2.drawRect(3*i*getCellWidth(), 3*j*getCellHeight(), 3*getCellWidth(), 3*getCellHeight());
            }
        }
    }

}
