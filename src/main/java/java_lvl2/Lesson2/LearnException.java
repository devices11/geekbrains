package java_lvl2.Lesson2;

/**
 * Created by Izotov V.A. on 12.12.2019.
 */
public class LearnException {

    public static void main(String[] args){
        String[][] arr = {{"1", "1", "1", "1"},{"1", "1", "1", "1"},{"1", "1", "1", "1"},{"1", "1", "1", "1"}};
        String[][] arr2 = {{"1", "2", "3", "4"},{"1", "2", "3", "4"},{"1", "2", "c", "4"},{"1", "2", "3", "d"}};
        String[][] arr3 = {{"1", "2", "3", "4", "5"},{"1", "2", "3", "4"},{"1", "2", "c", "4"},{"1", "2", "3", "d"}};
        String[][] arr4 = {{"1", "2", "3", "4"},{"1", "2", "3", "4"},{"1", "2", "c", "4"},{"1", "2", "3", "d"},{"1", "2", "3", "d"}};


        try {
            System.out.println(myArraySizeMethod(arr));
            System.out.println(myArraySizeMethod(arr2));
            System.out.println(myArraySizeMethod(arr3));
            System.out.println(myArraySizeMethod(arr4));
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        } catch (MyArrayDataException e) {
            e.printStackTrace();
        }

    }


    private static int myArraySizeMethod(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        if (arr.length > 4 || arr[0].length > 4 || arr[1].length > 4 || arr[2].length > 4 || arr[3].length > 4) {
            throw new MyArraySizeException("-----------Массив имеет больший размер чем 4х4-----------");
        }

        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    sum += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e){
                    throw new MyArrayDataException("-----------В ячейке [" + i + "][" + j + "] лежит символ или текст вместо числа-----------");
                }
            }
        }

        return sum;
    }


    static class MyArraySizeException extends Exception{
        MyArraySizeException(){}
        MyArraySizeException(String msg){
            super(msg);
        }
    }


    static class MyArrayDataException extends Exception{
        MyArrayDataException(){}
        MyArrayDataException(String msg){
            super(msg);
        }
    }
}
