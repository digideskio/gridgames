package gridframework.model;

public interface RuleChecker {
    public boolean isGameSolved();
    public boolean isInputValid(int x, int y, char c);
}
