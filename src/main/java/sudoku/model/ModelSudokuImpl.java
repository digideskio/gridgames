package sudoku.model;

import gridframework.model.ModelBasicImpl;
import gridframework.model.NumberCell;
import org.springframework.stereotype.Component;

@Component
public class ModelSudokuImpl extends ModelBasicImpl {


    public void build(int[][] sudoku){
        for(int i=0; i<9; i++){
            for (int j=0; j<9; j++){
                if(sudoku[i][j] == 0)
                    setCell(i, j, new NumberCell(i, j, true));
                else
                    setCell(i, j, new NumberCell(i, j, false, sudoku[i][j]));
            }
        }

        selectFirstInputCell();
    }

}
