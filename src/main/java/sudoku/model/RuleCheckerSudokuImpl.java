package sudoku.model;

import gridframework.model.RuleChecker;
import gridframework.model.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.TreeSet;

@Component
public class RuleCheckerSudokuImpl implements RuleChecker {

    @Autowired
    private Model model;

    @Override
    public boolean isGameSolved() {
        Set<Integer> set = new TreeSet<Integer>();

        for(int i=0; i<9; i++){
            set.clear();
            for (int j=0; j<9; j++){
                if(!model.getCell(i, j).isEmpty())
                    set.add(Integer.parseInt(model.getCell(i, j).getValue()));
            }
            if(set.size() < 9) return false;
        }

        for(int j=0; j<9; j++){
            set.clear();
            for (int i=0; i<9; i++){
                if(!model.getCell(i, j).isEmpty())
                    set.add(Integer.parseInt(model.getCell(i, j).getValue()));
            }
            if(set.size() < 9) return false;
        }

        for(int x=0; x<3; x++){
            for (int y=0; y<3; y++){
                set.clear();
                for(int i=0; i<3; i++){
                    for (int j=0; j<3; j++){
                        if(!model.getCell(x*3+i, y*3+j).isEmpty())
                            set.add(Integer.parseInt(model.getCell(x*3+i, y*3+j).getValue()));
                    }

                }
                if(set.size() < 9) return false;
            }
        }

        return true;
    }

    @Override
    public boolean isInputValid(int x, int y, char c) {
        if(!Character.isDigit(c)) return false;

        int n = Character.getNumericValue(c);
        if (n == 0) return false;

        for(int i=0; i<9; i++){
            if(!model.getCell(i, y).isEmpty() && Integer.parseInt(model.getCell(i, y).getValue()) == n) return false;
        }

        for(int j=0; j<9; j++){
            if(!model.getCell(x, j).isEmpty() && Integer.parseInt(model.getCell(x, j).getValue()) == n) return false;
        }

        int i0 = 3*(x/3);
        int j0 = 3*(y/3);
        for(int i=i0; i<i0+3; i++){
            for(int j=j0; j<j0+3; j++){
                if(!model.getCell(i, j).isEmpty() && Integer.parseInt(model.getCell(i, j).getValue()) == n) return false;
            }
        }

        return true;
    }


}
