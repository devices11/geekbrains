package java_lvl1.Lesson2;

import java_lvl1.Base.Base;
/**
 * Created by Izotov V.A. on 22.11.2019.
 */
public class Task2 extends Base {
    //        2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;

    public static void main(String[] args) {
        int[] arr = new int[8];

        int value = 0;
        for (int i = 0; i <arr.length; i++){
            arr[i] = value;
            value += 3;
        }

        printArr(arr);
    }

}
