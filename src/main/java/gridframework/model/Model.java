package gridframework.model;

public interface Model {
    /**
     * sets the first input cell in reading direction as selected
     */
    void selectFirstInputCell();

    void setCell(int x, int y, Cell cell);

    void setSize(int width, int height);

    void reset();

    public enum direction {LEFT, RIGHT, UP, DOWN}

    public int getGridWidth();
    public int getGridHeight();
    public Cell getSelectedCell();
    public Cell getCell(int x, int y);

    /**
     * Gets the current direction of selection. If true, then after input the selection moves to right, else downwards.
     */
    public boolean isHorizontalSelection();

    public boolean selectCell(int x, int y);

    /**
     * input characted to currently selected cell
     * @param c character to input
     * @return true if successful
     */
    public boolean inputChar(char c);

    /**
     * changes input direction from horizontal to vertical or vice versa.
     */
    public void turnSelectionDirection();

    /**
     * Move selection in grid.
     * @param dir direction for moving
     * @param jumpOverNonInputCells if true, the movement will be continued over static non-input cells to the next input cell in the same column/row
     */
    public void move(direction dir, boolean jumpOverNonInputCells);

    public void eraseCell();

    public RuleChecker getRuleChecker();

}
