package java_lvl1.Lesson7.Game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * Created by Izotov V.A. on 30.11.2019.
 */
public class GameActionListener implements ActionListener {
    private int row;
    private int cell;
    private GameButton button;


    public GameActionListener(int row, int cell, GameButton gameButton) {
        this.row = row;
        this.cell = cell;
        this.button = gameButton;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        GameBoard board = button.getBoard();

        if (board.isTurnable(row, cell)) {
            updateByPlayersData(board);

            if (board.isFull()) {
                board.getGame().showMessage("Ничья!");
                board.emptyField();
            } else {
                updateByAiData(board);
            }
        } else {
            board.getGame().showMessage("Некорректный ход!");
        }

    }

    /**
     * Ход человека
     *
     * @param board GameBoard - ссылка на тгровое поле
     */
    private void updateByPlayersData(GameBoard board) {
        //обновить матрицу игры
        board.updateGameField(row, cell);

        //обновить содержание кнопки
        button.setText(Character.toString(board.getGame().getCurrentPlayer().getPlayerSign()));

        if (board.checkWin()) {
            button.getBoard().getGame().showMessage("Вы выиграли!");
            board.emptyField();
        } else {
            board.getGame().passTurn();
        }

    }

    /**
     * Ход Ai
     *
     * @param board GameBoard - ссылка на игровое поле
     */
     private void updateByAiData(GameBoard board) {
        int x = 0;
        int y = 0;

        boolean ai_win = false;
        boolean user_win = false;
        Random rnd = new Random();

        char playerSign;
        if (board.getGame().getCurrentPlayer().getPlayerSign() == 'X')
            playerSign = '0';
        else
            playerSign = 'X';


        // Находим выигрышный ход
        for (int i = 0; i < GameBoard.demension; i++) {
            for (int j = 0; j < GameBoard.demension; j++) {
                if (board.isTurnable(i, j)) {
                    int cellIndex = GameBoard.demension * i + j;
                    board.getButton(cellIndex).setText(Character.toString(board.getGame().getCurrentPlayer().getPlayerSign()));
                    if (board.checkWin()) {
                        x = i;
                        y = j;
                        ai_win = true;
                    }

                    board.getButton(cellIndex).setText(Character.toString(GameBoard.nullSymbol));
                }
            }
        }

        // Блокировка хода пользователя, если он побеждает на следующем ходу
        if (!ai_win) {
            for (int i = 0; i < GameBoard.demension; i++) {
                for (int j = 0; j < GameBoard.demension; j++) {
                    if (board.isTurnable(i, j)) {
                        int cellIndex = GameBoard.demension * i + j;
                        board.getButton(cellIndex).setText(Character.toString(playerSign));
                        if (board.checkWin(playerSign)) {
                            x = i;
                            y = j;
                            user_win = true;
                        }
                         board.getButton(cellIndex).setText(Character.toString(GameBoard.nullSymbol));
                    }
                }
            }
        }

        if (!ai_win && !user_win) {
            do {
                x = rnd.nextInt(GameBoard.demension);
                y = rnd.nextInt(GameBoard.demension);
            }
            while (!board.isTurnable(x, y));
        }

        //обновить матрицу игры
        board.updateGameField(x, y);

        //проставляем AI в ячейку
        int cellIndex = GameBoard.demension * x + y;
        board.getButton(cellIndex).setText(Character.toString(board.getGame().getCurrentPlayer().getPlayerSign()));

        if (board.checkWin()) {
            button.getBoard().getGame().showMessage("Компьютер выиграл!");
            board.emptyField();
        } else {
            if (board.isFull()) {
                board.getGame().showMessage("Ничья!");
                board.emptyField();
            } else
                board.getGame().passTurn();
        }
    }
}
