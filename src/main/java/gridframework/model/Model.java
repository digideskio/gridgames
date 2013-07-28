package gridframework.model;

public interface Model {
    void selectFirstInputCell();

    void setCell(int x, int y, Cell cell);

    void setSize(int width, int height);

    void reset();

    public enum direction {LEFT, RIGHT, UP, DOWN}

    public int getGridWidth();
    public int getGridHeight();
    public Cell getSelectedCell();
    public Cell getCell(int x, int y);
    public boolean isHorizontalSelection();

    public boolean selectCell(int x, int y);
    public boolean inputChar(char c);
    public void turnSelectionDirection();
    public void move(direction dir, boolean jumpOverNonInputCells);
    public void eraseCell();

    public RuleChecker getRuleChecker();

}
