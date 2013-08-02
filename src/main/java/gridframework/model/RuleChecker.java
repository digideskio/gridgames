package gridframework.model;


/**
 * Implement this interface for game specific rules.
 */
public interface RuleChecker {
    public boolean isGameSolved();
    public boolean isInputValid(int x, int y, char c);
}
