package gridframework.model;

public class CharCell extends Cell {

    private char character;

    public CharCell(int x, int y, boolean inputCell) {
        super();
        setX(x);
        setY(y);
        setInputCell(inputCell);
        setEmpty(true);
        this.character = ' ';
    }

    public CharCell(int x, int y, boolean inputCell, char character) {
        this(x, y, inputCell);
        setEmpty(false);
        this.character = character;
    }

    @Override
    public String getValue() {
        return ""+character;
    }

    @Override
    public boolean setValue(char character) {
        if(!Character.isAlphabetic(character)) return false;
        this.character = character;
        setEmpty(false);
        return true;
    }

    @Override
    public void erase() {
        setEmpty(true);
        this.character = ' ';
    }
}
