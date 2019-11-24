package Lesson2;

import Base.Base;

/**
 * Created by Izotov V.A. on 22.11.2019.
 */
public class Task4 extends Base {
    //        4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
    //        и с помощью цикла(-ов) заполнить его диагональные элементы единицами;

    public static void main(String[] args) {

        printArr(matrix(8));
        System.out.println("");
        printArr(matrix(5));
        System.out.println("");
        printArr(matrix(2));
        System.out.println("");
        printArr(matrix(1));
        System.out.println("");
        printArr(matrix(0));
    }

    static int[][] matrix(int len) {
        int arr[][] = new int[len][len];

        if (len == 0){
            System.out.println("Введите четное больше нуля");
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (i == j) {
                    arr[j][i] = 1;
                    arr[i][(len-1) - j] = 1;
                }
            }
        }
        return arr;
    }
}
