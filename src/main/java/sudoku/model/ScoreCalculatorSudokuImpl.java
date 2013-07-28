package sudoku.model;

import gridframework.model.ScoreCalculatorAbstractImpl;
import org.springframework.stereotype.Component;

@Component
public class ScoreCalculatorSudokuImpl extends ScoreCalculatorAbstractImpl {

    @Override
    public double getScore() {
        double score = 1000 - getInvalidInputsGiven() - getInputsChanged() - (getTimeSpent()/1000);
        System.out.println(score);
        return 1*score;
    }

}
