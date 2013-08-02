package gridframework.model;

/**
 * Interface for calculating score
 */
public interface ScoreCalculator {

    /**
     * Implement this for game specific scoring mechanism
     */
    double getScore();

    /**
     * call when game starts
     */
    void startClock();

    /**
     * call when game ends
     */
    void stopClock();

    /**
     * @return the amount of milliseconds the player has been playing
     */
    long getTimeSpent();

    long getStartTime();

    long getEndTime();

    /**
     * @return number of times the player has changed input
     */
    int getInputsChanged();

    /**
     * @return number of times the player has given invalid input
     */
    int getInvalidInputsGiven();

    /**
     * @return number of times the player has given valid input
     */
    int getValidInputsGiven();

    /**
     * increments the specified counter
     */
    void inputChanged();

    /**
     * increments the specified counter
     */
    void invalidInputGiven();

    /**
     * increments the specified counter
     */
    void validInputGiven();
}
