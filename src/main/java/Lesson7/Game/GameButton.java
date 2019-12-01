package Lesson7.Game;

import javax.swing.*;

/**
 * Created by Izotov V.A. on 30.11.2019.
 */
public class GameButton extends JButton {
    private int buttonIndex;
    private GameBoard board;

    public GameButton(int gameButtonIndex, GameBoard currentGameBoard) {
        buttonIndex = gameButtonIndex;
        board = currentGameBoard;

        int rowNum = buttonIndex / GameBoard.demension;
        int cellNum = buttonIndex % GameBoard.demension;

        setSize(GameBoard.cellSize - 5,GameBoard.cellSize - 5);
        addActionListener(new GameActionListener(rowNum, cellNum, this));
    }

    public GameBoard getBoard() {
        return board;
    }
}
