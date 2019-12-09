package java_lvl1.Lesson7.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Izotov V.A. on 30.11.2019.
 */
public class GameBoard extends JFrame {
    static int demension = 3;   //размерность
    static int cellSize = 150;  //размер клетки
    private char[][] gameField; //матрица игры
    private GameButton[] gameButtons; //массив кнопок

    private Game game;

    static char nullSymbol = '\u0000';

    public GameBoard (Game currentGame){
        this.game = currentGame;
        initField();
    }

    /**
     * Метод инициации и отрисовки игрового поля
     */
    private void initField(){
        setBounds(cellSize * demension, cellSize * demension, 400, 300);
        setTitle("Крестики-нолики");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        JPanel controlPanel = new JPanel(); //панель управления
        JButton newGameButton = new JButton("Новая игра");
        newGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                emptyField();
            }
        });

        controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.Y_AXIS));
        controlPanel.add(newGameButton);
        controlPanel.setSize(cellSize * demension, 150);

        JPanel gameFieldPanel = new JPanel(); //панель игры
        gameFieldPanel.setLayout(new GridLayout(demension, demension));
        gameFieldPanel.setSize(cellSize * demension,cellSize * demension);

        gameField = new char[demension][demension];
        gameButtons = new GameButton[demension * demension];

        //инициализируем игровое поле
        for (int i = 0; i < (demension * demension); i++){
            GameButton fieldButton = new GameButton(i, this);
            gameFieldPanel.add(fieldButton);
            gameButtons[i] = fieldButton;
        }

        getContentPane().add(controlPanel, BorderLayout.NORTH);
        getContentPane().add(gameFieldPanel,BorderLayout.CENTER);

        setVisible(true);
    }

    /**
     * Метод очистки поля и матрицы игры
     * */
    void emptyField(){
        for (int i = 0; i < (demension * demension); i++){
            gameButtons[i].setText("");

            int x = i / GameBoard.demension;
            int y = i % GameBoard.demension;

            gameField[x][y] = nullSymbol;
        }
    }

    Game getGame(){
        return game;
    }

    /**
     * Метод проверки доступности хода
     * @param x - по горизонтали
     * @param y - по вертикали
     * @return boolean
     * */
    boolean isTurnable(int x, int y){
        boolean result = false;

        if (gameField[y][x] == nullSymbol)
            result = true;

        return result;
    }

    /**
     * Обновление матрицы игры после хода
     * @param x - по горизонтали
     * @param y - по вертикали
     * */
    void updateGameField(int x, int y){
        gameField[y][x] = game.getCurrentPlayer().getPlayerSign();
    }

    /**
     *  Проверка победы по столбцам и линиям
     *  @return флаг победы*/
    boolean checkWin(){
        boolean result = false;

        char playerSymbol = getGame().getCurrentPlayer().getPlayerSign();

        if(
                (gameField[0][0] == playerSymbol && gameField[0][1] == playerSymbol && gameField[0][2] == playerSymbol) ||
                        (gameField[1][0] == playerSymbol && gameField[1][1] == playerSymbol && gameField[1][2] == playerSymbol) ||
                        (gameField[2][0] == playerSymbol && gameField[2][1] == playerSymbol && gameField[2][2] == playerSymbol) ||
                        (gameField[0][0] == playerSymbol && gameField[1][0] == playerSymbol && gameField[2][0] == playerSymbol) ||
                        (gameField[0][1] == playerSymbol && gameField[1][1] == playerSymbol && gameField[2][1] == playerSymbol) ||
                        (gameField[0][2] == playerSymbol && gameField[1][2] == playerSymbol && gameField[2][2] == playerSymbol) ||
                        (gameField[0][0] == playerSymbol && gameField[1][1] == playerSymbol && gameField[2][2] == playerSymbol) ||
                        (gameField[2][0] == playerSymbol && gameField[1][1] == playerSymbol && gameField[0][2] == playerSymbol)){
            result = true;
        }

        return result;
    }

    /**
     *  Перегруженный метод проверки победы по столбцам и линиям
     * @param playerSymbol - символ игрока
     *  @return флаг победы*/
    boolean checkWin(char playerSymbol){
        boolean result = false;

        if(
                (gameField[0][0] == playerSymbol && gameField[0][1] == playerSymbol && gameField[0][2] == playerSymbol) ||
                        (gameField[1][0] == playerSymbol && gameField[1][1] == playerSymbol && gameField[1][2] == playerSymbol) ||
                        (gameField[2][0] == playerSymbol && gameField[2][1] == playerSymbol && gameField[2][2] == playerSymbol) ||
                        (gameField[0][0] == playerSymbol && gameField[1][0] == playerSymbol && gameField[2][0] == playerSymbol) ||
                        (gameField[0][1] == playerSymbol && gameField[1][1] == playerSymbol && gameField[2][1] == playerSymbol) ||
                        (gameField[0][2] == playerSymbol && gameField[1][2] == playerSymbol && gameField[2][2] == playerSymbol) ||
                        (gameField[0][0] == playerSymbol && gameField[1][1] == playerSymbol && gameField[2][2] == playerSymbol) ||
                        (gameField[2][0] == playerSymbol && gameField[1][1] == playerSymbol && gameField[0][2] == playerSymbol)){
            result = true;
        }

        return result;
    }

    /**
     * Метод проверки заполнения поля
     * @return boolean
     * */
    boolean isFull(){
        boolean result = true;

        for (int i = 0; i < demension; i++){
            for (int j = 0; j < demension; j++){
                if (gameField[i][j] == nullSymbol)
                    result = false;
            }
        }

        return result;
    }

    public GameButton getButton(int buttonIndex){
        return gameButtons[buttonIndex];
    }
}
