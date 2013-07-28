package gridframework.model;

public class RuleCheckerStubImpl implements RuleChecker{

    @Override
    public boolean isGameSolved() {
        return false;
    }

    @Override
    public boolean isInputValid(int x, int y, char c) {
        return true;
    }

}
