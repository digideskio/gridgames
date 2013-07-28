package gridframework.model;

public abstract class Cell {

    private boolean inputCell;
    private boolean empty;
    private boolean selected = false;
    private int x;
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
