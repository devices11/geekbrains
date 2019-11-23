package LoopsAndArrays;

import Base.Base;

/**
 * Created by Izotov V.A. on 22.11.2019.
 */
public class Task1 extends Base {
    //        1. Задать целочисленный массив, состоящий из элементов 0 и 1.
    //        Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;

    public static void main(String[] args) {
        int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};

        for (int i = 0; i < arr.length; i++){
            if (arr[i] == 1)
                arr[i] = 0;
            else
                arr[i] = 1;
        }

        printArr(arr);
    }

}
