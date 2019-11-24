package Lesson2;

import Base.Base;

/**
 * Created by Izotov V.A. on 22.11.2019.
 */
public class Task3 extends Base {
    //        3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ], пройти по нему циклом, и числа, меньшие 6, умножить на 2;

    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        for (int i = 0; i < arr.length; i++){
            if (arr[i] < 6)
                arr[i] *= 2;
            else
                continue;;
        }

        printArr(arr);
    }
}
