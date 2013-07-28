package sudoku;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import sudoku.model.ModelSudokuImpl;
import sudoku.view.ViewSudokuImpl;

@Component
public class SudokuGame {

    @Autowired
    private ModelSudokuImpl model;

    @Autowired
    private ViewSudokuImpl view;

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        SudokuGame game = context.getBean(SudokuGame.class);
        game.start();
    }

    private void start(){
        model.setSize(9, 9);
        model.build(sudoku1);
        view.setVisible(true);
    }


    private static final int[][] sudoku1 = {
            {0, 9, 3, 1, 0, 5, 6, 4, 0},
            {7, 0, 0, 0, 0, 0, 0, 0, 5},
            {5, 0, 1, 2, 0, 9, 3, 0, 7},
            {2, 0, 0, 0, 0, 0, 0, 0, 3},
            {0, 3, 6, 9, 0, 7, 5, 2, 0},
            {9, 0, 0, 0, 0, 0, 0, 0, 1},
            {3, 0, 2, 4, 0, 8, 1, 0, 9},
            {6, 0, 0, 0, 0, 0, 0, 0, 4},
            {0, 4, 7, 3, 0, 2, 8, 5, 0}
    };
}
