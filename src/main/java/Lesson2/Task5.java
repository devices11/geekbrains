package Lesson2;

/**
 * Created by Izotov V.A. on 22.11.2019.
 */
public class Task5 {
    //        5. Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);

    public static void main(String[] args) {

        int[] arr = {-1, 5, -7, 2, 11, -5, 5, 2, 0, 8, 23, 1};
        min_max(arr);
    }

    static void min_max(int[] arr){
        int min = arr[0];
        int max = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min)
                min = arr[i];
            else if (arr[i] > max)
                max = arr[i];
        }
        System.out.println("Минимум массива = " + min);
        System.out.println("Максимум массива = " + max);
    }
}
