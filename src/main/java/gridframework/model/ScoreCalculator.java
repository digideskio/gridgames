package gridframework.model;

public interface ScoreCalculator {

    double getScore();

    void startClock();

    void stopClock();

    long getTimeSpent();

    long getStartTime();

    long getEndTime();

    int getInputsChanged();

    int getInvalidInputsGiven();

    int getValidInputsGiven();

    void inputChanged();

    void invalidInputGiven();

    void validInputGiven();
}
