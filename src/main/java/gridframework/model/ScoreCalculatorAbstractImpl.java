package gridframework.model;

import org.springframework.stereotype.Component;

@Component
public abstract class ScoreCalculatorAbstractImpl implements ScoreCalculator{
    private long startTime;
    private long endTime;
    private boolean running = false;

    private int validInputsGiven;
    private int invalidInputsGiven;
    private int inputsChanged;

    @Override
    public void startClock(){
        if(running) return;
        startTime = System.currentTimeMillis();
        running = true;
    }

    @Override
    public void stopClock(){
        if(!running) return;
        endTime = System.currentTimeMillis();
        running = false;
    }

    @Override
    public long getTimeSpent(){
        if(running)
            return System.currentTimeMillis() - startTime;
        else
            return endTime - startTime;
    }

    @Override
    public long getStartTime() {
        return startTime;
    }

    @Override
    public long getEndTime() {
        return endTime;
    }

    @Override
    public int getInputsChanged() {
        return inputsChanged;
    }

    @Override
    public int getInvalidInputsGiven() {
        return invalidInputsGiven;
    }

    @Override
    public int getValidInputsGiven() {
        return validInputsGiven;
    }

    @Override
    public void inputChanged() {
        inputsChanged++;
    }

    @Override
    public void invalidInputGiven() {
        invalidInputsGiven++;
    }

    @Override
    public void validInputGiven() {
        validInputsGiven++;
    }


}
