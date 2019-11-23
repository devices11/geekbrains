package LoopsAndArrays;

import Base.Base;

/**
 * Created by Izotov V.A. on 23.11.2019.
 */
public class Task7 extends Base {
    //        7. *Написать метод, которому на вход подается одномерный массив и число n (может быть положительным или отрицательным),
    //        при этом метод должен сместить все элементы массива на n позиций. Нельзя пользоваться вспомогательными массивами.

    public static void main(String[] args) {
        int[] arr = {-1, 5, -7, 2, 11, -5, 5, 2, 0, 8, 23, 1};
        int[] arr2 = {-1, 5, -7, 2, 11, -5, 5, 2, 0, 8, 23, 1};

        System.out.println("Массив, который будем смещать");
        printArr(arr);
        System.out.println("\nСмещаем на n положительное (вправо)");
        printArr(rideArr(arr, 2));
        System.out.println("\nСмещаем на n отрицательное (влево)");
        printArr(rideArr(arr2, -3));

    }

    private static int[] rideArr(int[] arr, int n) {
        int current;
        int prev;
        int s = (n < 0) ? n * -1 : n;

        for (int i = 0; i < s; i++) {
            for (int k = arr.length - 1; k >= 0; k--) {
                current = arr[k];

                if (n < 0)
                    prev = 0;
                else prev = Math.max(k - 1, 0);

                arr[k] = arr[prev];
                arr[prev] = current;
            }
        }
        return arr;
    }
}
