package sudoku.view;

import javax.swing.*;

public class ScorePanel extends JPanel {

    private JLabel label;

    public ScorePanel() {
        label = new JLabel("Score: ");
        this.add(label);
    }


    public void updateScore(int score){
        label.setText("Score: " + score);
    }
}
