package gridframework.view;

import gridframework.controller.Controller;
import gridframework.model.Model;
import gridframework.model.Cell;
import gridframework.model.ImageCell;
import org.springframework.beans.factory.annotation.Autowired;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class GridPanelBasicImpl extends GridPanel {
    @Autowired
    private Model model;
    @Autowired
    private Controller controller;

    public Color borderColor = Color.black;
    public Color backgroundColor = Color.white;
    public Color inputCellColor = new Color(250, 250, 250);
    public Color staticCellColor = new Color(200, 200, 200);
    public Color selectedRowColor = new Color(180, 200, 220);
    public Color selectedCellColor = new Color(150, 180, 220);
    public Color textColor = Color.black;

    private int cellWidth;
    private int cellHeight;


    public GridPanelBasicImpl() {

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mouseClicked(e);
                controller.cellClicked(e.getX()/cellWidth, e.getY()/cellHeight);
            }
        });
    }



    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    @Override
    public void draw(Graphics g) {
        if(model == null) return;

        cellWidth = this.getWidth() / model.getGridWidth();
        cellHeight = this.getHeight() / model.getGridHeight();

        g.setColor(backgroundColor);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        g.setColor(borderColor);
        g.drawRect(0, 0, this.getWidth()-1, this.getHeight()-1);

        colorCells(g);

        colorSelections(g);

        drawInputsAndHints(g);

    }


    private void colorCells(Graphics g) {
        for(int i=0; i<model.getGridWidth(); i++){
            for(int j=0; j<model.getGridHeight(); j++){
                Cell cell = model.getCell(i, j);
                if(cell==null) continue;

                if(cell.isInputCell()) g.setColor(inputCellColor);
                else g.setColor(staticCellColor);
                g.fillRect(i*cellWidth, j*cellHeight, cellWidth, cellHeight);
            }
        }
    }

    private void colorSelections(Graphics g) {
        for(int i=0; i<model.getGridWidth(); i++){
            for(int j=0; j<model.getGridHeight(); j++){
                Cell cell = model.getCell(i, j);
                if(cell==null) continue;

                if(cell.isSelected()){
                    colorSelection(g, i, j);
                }
            }
        }
    }


    private void drawInputsAndHints(Graphics g) {
        setFont(getFont().deriveFont(Font.BOLD).deriveFont((float) 0.5*Math.min(cellWidth, cellHeight)));
        for(int i=0; i<model.getGridWidth(); i++){
            for(int j=0; j<model.getGridHeight(); j++){
                Cell cell = model.getCell(i, j);
                if(cell==null) continue;

                if(cell instanceof ImageCell){
                    BufferedImage image = ((ImageCell) cell).getImage();
                    g.drawImage(image, i*cellWidth, j*cellHeight, (i+1)*cellWidth, (j+1)*cellHeight, 0, 0, image.getWidth(), image.getHeight(), null);
                }
                else drawText(g, i, j, cell);

                drawBorders(g, i, j);
            }
        }
    }

    private void drawText(Graphics g, double i, double j, Cell cell) {
        if(!cell.isEmpty()){
            g.setColor(textColor);
            int xOffSet = getFontMetrics(getFont()).stringWidth(cell.getValue())/2;
            int yOffSet = getFontMetrics(getFont()).getHeight()/3;

            g.drawString(cell.getValue(), (int)((i+0.5)*cellWidth)-xOffSet, (int)((j+0.5)*cellHeight)+yOffSet);
        }
    }

    private void drawBorders(Graphics g, int i, int j) {
        g.setColor(borderColor);
        g.drawRect(i*cellWidth, j*cellHeight, cellWidth, cellHeight);
    }





    private void colorSelection(Graphics g, int i, int j) {
        g.setColor(selectedCellColor);
        g.fillRect(i*cellWidth, j*cellHeight, cellWidth, cellHeight);

        g.setColor(selectedRowColor);
        if(model.isHorizontalSelection()){
            int d = 1;
            while(model.getCell(i-d, j) != null && model.getCell(i-d, j).isInputCell()){
                g.fillRect((i-d)*cellWidth, j*cellHeight, cellWidth, cellHeight);
                d++;
            }
            d = 1;
            while(model.getCell(i+d, j) != null && model.getCell(i+d, j).isInputCell()){
                g.fillRect((i+d)*cellWidth, j*cellHeight, cellWidth, cellHeight);
                d++;
            }
        }
        else{
            int d = 1;
            while(model.getCell(i, j-d) != null && model.getCell(i, j-d).isInputCell()){
                g.fillRect(i*cellWidth, (j-d)*cellHeight, cellWidth, cellHeight);
                d++;
            }
            d = 1;
            while(model.getCell(i, j+d) != null && model.getCell(i, j+d).isInputCell()){
                g.fillRect(i*cellWidth, (j+d)*cellHeight, cellWidth, cellHeight);
                d++;
            }
        }
    }

    public int getCellHeight() {
        return cellHeight;
    }

    public int getCellWidth() {
        return cellWidth;
    }
}
