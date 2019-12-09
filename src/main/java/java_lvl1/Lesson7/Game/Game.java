package java_lvl1.Lesson7.Game;

import javax.swing.*;

/**
 * Created by Izotov V.A. on 30.11.2019.
 */
public class Game {
    private GameBoard board;    //ссылка на игровое поле
    private GamePlayer[] gamePlayers= new GamePlayer[2]; //массив игроков
    private int playerTurn = 0; //индекс текущего игрока

    public Game (){
        this.board = new GameBoard(this);
    }

    public void initGame(){
        gamePlayers[0] = new GamePlayer(true, 'X');
        gamePlayers[1] = new GamePlayer(false, '0');
    }

    /**
     * Метод передачи хода
     */
    void passTurn(){
        if (playerTurn == 0)
            playerTurn = 1;
        else
            playerTurn = 0;
    }

    /**
     * Получение объекта текущего игрока
     * @return GamePlayer объект игрока
     */
    GamePlayer getCurrentPlayer(){
        return  gamePlayers[playerTurn];
    }

    /**
     * Метод показа popup-a для пользователя
     * @param messageText - текст сообщения
     */
    void showMessage(String messageText){
        JOptionPane.showMessageDialog(board, messageText);
    }
}
