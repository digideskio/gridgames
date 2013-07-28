package sudoku.view;

import gridframework.model.Model;
import gridframework.model.ScoreCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import sudoku.controller.ControllerSudokuImpl;
import gridframework.view.ViewBasicImpl;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.Timer;

@org.springframework.stereotype.Component
public class ViewSudokuImpl extends ViewBasicImpl {

    @Autowired
    private Model model;
    @Autowired
    private ControllerSudokuImpl controller;
    @Autowired
    private ScoreCalculator scoreCalculator;

    private JButton resetButton;
    private JLabel solvedLabel;
    private ScorePanel scorePanel;
    private Timer timer;

    @PostConstruct
    private void init(){
        JPanel sidePanel = new JPanel();
        sidePanel.setLayout(new GridLayout(6, 1));

        sidePanel.add(new JPanel());

        solvedLabel = new JLabel(" Sudoku solved! ");
        solvedLabel.setForeground(new Color(30, 150, 30));
        sidePanel.add(solvedLabel);
        solvedLabel.setVisible(false);

        sidePanel.add(new JPanel());

        scorePanel = new ScorePanel();
        sidePanel.add(scorePanel);

        sidePanel.add(new JPanel());

        resetButton = new JButton("Reset");
        resetButton.setFocusable(false);
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               controller.reset();
            }
        });
        sidePanel.add(resetButton);

        this.add(sidePanel, BorderLayout.EAST);

        startScoreCalc();
    }

    private void startScoreCalc() {
        scoreCalculator.startClock();
        if(timer!=null) timer.cancel();
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                scorePanel.updateScore((int) scoreCalculator.getScore());
            }
        }, 1000, 1000);
    }


    @Override
    public void updateView() {
        boolean solved = model.getRuleChecker().isGameSolved();
        solvedLabel.setVisible(solved);
        if(solved) {
            scoreCalculator.stopClock();
            timer.cancel();
            scorePanel.updateScore((int) scoreCalculator.getScore());
        }
        repaint();
    }
}
