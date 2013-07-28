package gridframework.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ModelBasicImpl implements Model{

    private int width;
    private int height;
    private Cell selected = null;
    private Cell[][] cells;
    private boolean horizontalSelection;

    @Autowired
    private RuleChecker ruleChecker;

    @Autowired
    private ScoreCalculator scoreCalculator;


    @Override
    public void setSize(int width, int height) {
        this.width = width;
        this.height = height;
        cells = new Cell[width][height];
    }

    @Override
    public int getGridWidth() {
        return width;
    }

    @Override
    public int getGridHeight() {
        return height;
    }

    @Override
    public Cell getSelectedCell() {
        return selected;
    }

    @Override
    public Cell getCell(int x, int y) {
        Cell cell = null;

        try{
            cell = cells[x][y];
        }
        catch (IndexOutOfBoundsException e){
            return null;
        }

        return cell;
    }

    @Override
    public boolean isHorizontalSelection() {
        return horizontalSelection;
    }

    @Override
    public boolean selectCell(int x, int y) {
        Cell cell = getCell(x, y);
        if(cell != null && cell.select()){
            if(selected!=null) selected.deselect();
            selected = cell;
            return true;
        }
        else return false;
    }

    @Override
    public boolean inputChar(char c) {
        if(ruleChecker != null && !ruleChecker.isInputValid(selected.getX(), selected.getY(), c)) {
            scoreCalculator.invalidInputGiven();
            return false; //check if rules of the game are broken
        }

        boolean empty = selected.isEmpty();

        if(selected.setValue(c)){ //value is of valid type
            scoreCalculator.validInputGiven();
            if(!empty) scoreCalculator.inputChanged();
            if(horizontalSelection) move(direction.RIGHT, false);
            else move(direction.DOWN, false);
            return true;
        }
        else return false;
    }

    @Override
    public void turnSelectionDirection() {
        horizontalSelection = !horizontalSelection;
    }

    @Override
    public void move(direction dir, boolean jumpOverNonInputCells) {
        int x = selected.getX();
        int y = selected.getY();
        do{
            if (dir == direction.LEFT) x -= 1;
            else if (dir == direction.RIGHT) x += 1;
            else if (dir == direction.UP) y -= 1;
            else if (dir == direction.DOWN) y += 1;

            if(selectCell(x, y)) return;
        } while (jumpOverNonInputCells && x >= 0 && y >= 0 && x <= width-1 && y <= width-1);
    }

    @Override
    public void eraseCell() {
        selected.erase();
        if(horizontalSelection) move(direction.LEFT, false);
        else move(direction.UP, false);
    }

    @Override
    public RuleChecker getRuleChecker() {
        return ruleChecker;
    }

    @Override
    public void selectFirstInputCell(){
        for(int i=0; i<width; i++){
            for(int j=0; j<height; j++){
                if (cells[i][j] != null && cells[i][j].isInputCell()){
                    selectCell(i, j);
                    return;
                }
            }
        }
    }

    @Override
    public void setCell(int x, int y, Cell cell){
        try{
            cells[x][y] = cell;
        }
        catch (IndexOutOfBoundsException e){
            System.out.println("ERROR: Trying to add cell outside of grid.");
        }
    }

    @Override
    public void reset(){
        for(int i=0; i<getGridWidth(); i++){
            for (int j=0; j<getGridHeight(); j++){
                Cell cell = getCell(i, j);
                if(cell!=null && cell.isInputCell())
                    cell.erase();
            }
        }
    }

}
