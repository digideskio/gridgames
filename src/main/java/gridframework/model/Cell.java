package gridframework.model;


/**
 * Abstract implementation of a cell in the grid. Can be user-editable input cell or static cell for displaying hints such as picture or character.
 */
public abstract class Cell {

    /**
     * Is this cell for user input and thus editable.
     */
    private boolean inputCell;

    private boolean empty;

    /**
     * Is this cell currently selected for giving input
     */
    private boolean selected = false;

    /**
     * Coordinate in grid
     */
    private int x;

    /**
     * Coordinate in grid
     */
    private int y;



    public boolean select() {
        if(this.inputCell){
            selected = true;
            return true;
        }
        else return false;
    }

    public void deselect(){
        selected = false;
    }

    public abstract String getValue();
    public abstract boolean setValue(char character);
    public abstract void erase();

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public boolean isEmpty() {
        return empty;
    }

    public void setEmpty(boolean empty) {
        this.empty = empty;
    }

    public boolean isInputCell() {
        return inputCell;
    }

    public void setInputCell(boolean inputCell) {
        this.inputCell = inputCell;
    }
}
