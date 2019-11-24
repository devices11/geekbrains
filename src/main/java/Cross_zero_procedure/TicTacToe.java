package Cross_zero_procedure;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by Izotov V.A. on 24.11.2019.
 */
public class TicTacToe {

    public static final String DOT_X = "X";
    public static final String DOT_O = "O";
    public static final String DOT_EMPTY = "•";
    public static int aiLevel = 2;
    public static final int SIZE = 3;

    public static String[][] map = new String[SIZE][SIZE];

    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();

    public static void main(String[] args) {
        System.out.println("Выберите сложность компьютера: ");
        System.out.println("1. Простой.");
        System.out.println("2. Продвинутый.");
        System.out.println("3. Выход.");
        int i = 0;
        Scanner sc = new Scanner(System.in);
        i = sc.nextInt();
        switch (i) {
            case 1: {
                aiLevel = 1;
                modeAgainstAI();
                break;
            }
            case 2: {
                aiLevel = 2;
                modeAgainstAI();
                break;
            }
            case 3: {
                System.exit(0);
                break;
            }
            default: {
                System.out.println("Было введено неверное значение!");
            }
        }
    }

    public static void modeAgainstAI() {
        int count = 0;
        initMap();
        while (true) {
            printMap();
            humanTurn(DOT_X, 1);
            count++;
            if (checkWin(DOT_X)) {
                System.out.println("Победил пользователь!!!");
                printMap();
                break;
            }
            computerTurn();
            count++;
            if (checkWin(DOT_O)) {
                System.out.println("Победил компьютер!!!");
                printMap();
                break;
            }
            if (count == Math.pow(SIZE, 2)) {
                printMap();
                break;
            }
        }
    }

    public static void initMap() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printMap() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void humanTurn(String sign, int i) {
        int x = -1;
        int y = -1;
        do {
            if (i == 0) {
                System.out.println("Введите координаты x y (1 - " + SIZE + "): ");
            } else {
                System.out.println("Игрок " + i + ". Введите координаты x y (1 - " + SIZE + "): ");
            }
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        }
        while (isCellValid(x, y));
        map[x][y] = sign;
    }

    public static void computerTurn() {
        int x = -1;
        int y = -1;
        boolean ai_win = false;
        boolean user_win = false;

        // Находим выигрышный ход
        if (aiLevel == 2) {
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    if (!isCellValid(i, j)) {
                        map[i][j] = DOT_O;
                        if (checkWin(DOT_O)) {
                            x = i;
                            y = j;
                            ai_win = true;
                        }
                        map[i][j] = DOT_EMPTY;
                    }
                }
            }
        }
        // Блокировка хода пользователя, если он побеждает на следующем ходу
        if (aiLevel == 2) {
            if (!ai_win) {
                for (int i = 0; i < SIZE; i++) {
                    for (int j = 0; j < SIZE; j++) {
                        if (!isCellValid(i, j)) {
                            map[i][j] = DOT_X;
                            if (checkWin(DOT_X)) {
                                x = i;
                                y = j;
                                user_win = true;
                            }
                            map[i][j] = DOT_EMPTY;
                        }
                    }
                }
            }
        }

        if (!ai_win && !user_win) {
            do {
                x = random.nextInt(SIZE);
                y = random.nextInt(SIZE);
            }
            while (isCellValid(x, y));
        }
        map[x][y] = DOT_O;
        System.out.println("Компьютер выбрал ячейку " + (x + 1) + " " + (y + 1));
    }


    public static boolean isCellValid(int x, int y) {
        if (x < 0 || y < 0 || x > SIZE - 1 || y > SIZE - 1) {
            return false;
        }
        return map[x][y] != DOT_EMPTY;
    }

    private static boolean checkWin(String playerSymbol) {
        boolean result = false;

        if(
                (map[0][0] == playerSymbol && map[0][1] == playerSymbol && map[0][2] == playerSymbol) ||
                        (map[1][0] == playerSymbol && map[1][1] == playerSymbol && map[1][2] == playerSymbol) ||
                        (map[2][0] == playerSymbol && map[2][1] == playerSymbol && map[2][2] == playerSymbol) ||
                        (map[0][0] == playerSymbol && map[1][0] == playerSymbol && map[2][0] == playerSymbol) ||
                        (map[0][1] == playerSymbol && map[1][1] == playerSymbol && map[2][1] == playerSymbol) ||
                        (map[0][2] == playerSymbol && map[1][2] == playerSymbol && map[2][2] == playerSymbol) ||
                        (map[0][0] == playerSymbol && map[1][1] == playerSymbol && map[2][2] == playerSymbol) ||
                        (map[2][0] == playerSymbol && map[1][1] == playerSymbol && map[0][2] == playerSymbol)){
            result = true;
        }

        return result;
    }
}
