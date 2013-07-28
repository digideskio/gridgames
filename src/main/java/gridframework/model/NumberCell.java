package gridframework.model;

public class NumberCell extends CharCell {

    private int digit;

    public NumberCell(int x, int y, boolean inputCell) {
        super(x, y, inputCell);
        digit = 0;
    }

    public NumberCell(int x, int y, boolean inputCell, int number) {
        super(x, y, inputCell);
        if(digit >= 0 && digit <= 9){
            digit = number;
            setEmpty(false);
        }
        else setEmpty(true);
    }

    public int getDigit() {
        return digit;
    }

    @Override
    public String getValue() {
        return "" + digit;
    }

    @Override
    public boolean setValue(char character) {
        if (Character.isDigit(character)){
            digit = Character.getNumericValue(character);
            setEmpty(false);
            return true;
        }
        else return false;
    }

    @Override
    public void erase() {
        setEmpty(true);
        this.digit = 0;
    }
}
