package sudoku.controller;

import gridframework.controller.ControllerBasicImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import sudoku.model.ModelSudokuImpl;

@Controller
public class ControllerSudokuImpl extends ControllerBasicImpl{

    @Autowired
    private ModelSudokuImpl model;


    public void reset(){
        ((ModelSudokuImpl) model).reset();
        updateViews();
    }



}
