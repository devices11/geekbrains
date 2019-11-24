package Lesson2;

/**
 * Created by Izotov V.A. on 23.11.2019.
 */
public class Task6 {
    //        6. Написать метод, в который передается не пустой одномерный целочисленный массив,
    //        метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой
    //        части массива равны. Примеры: checkBalance([1, 1, 1, || 2, 1]) → true, checkBalance ([2, 1, 1, 2, 1]) → false,
    //        checkBalance ([10, || 10]) → true, граница показана символами ||, эти символы в массив не входят;

    public static void main(String[] args) {
        int[] arr1 = {1, 1, 1, 2, 1};
        int[] arr2 = {2, 1, 1, 2, 1};
        int[] arr3 = {10, 10};
        int[] arr4 = {1, 4, 1, 5, 1};
        int[] arr5 = {1, 0, 1, -3, 1};
        int[] arr6 = {1, 0, 1, -3, 5};

        System.out.println(checkBalance(arr1));
        System.out.println(checkBalance(arr2));
        System.out.println(checkBalance(arr3));
        System.out.println(checkBalance(arr4));
        System.out.println(checkBalance(arr5));
        System.out.println(checkBalance(arr6));
    }

    static boolean checkBalance(int[] arr) {
        int leftSum = 0;
        int rightSum = 0;
        int center;

        if(arr.length % 2 == 0)
            center = arr.length / 2;
        else
            center = arr.length / 2 + 1;

        for (int i = 0; i < arr.length; i++){
            if (i <= center - 1) {
                leftSum += arr[i];
            } else {
                rightSum += arr[i];
            }
        }

        if (leftSum == rightSum)
            return true;
        else
            return false;
    }
}
