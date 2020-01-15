package java_lvl2.Lesson5;

import java.util.Arrays;

public class Thread_learn{
    static final int size = 10000000;
    static final int h = size / 2;
    static float[] arr = new float[size];

    public static void main(String[] args) {
        Arrays.fill(arr, 1);

        oneThread(arr);
        twoThread(arr);
    }


    /** Метод изменения значений массива в один поток
     * @param arr основной массив над которым будут проведены преобразования
     */
    public static void oneThread(float[] arr){
        long a = System.currentTimeMillis();

        newValue(arr);

        System.out.println("Время работы в один поток: " + (System.currentTimeMillis() - a));
    }


    /** Метод изменения значений массива в два потока
     * @param arr основной массив над которым будут проведены преобразования
     */
    public synchronized static void twoThread(float[] arr){

        long a = System.currentTimeMillis();

        final float[] a1 = new float[h];
        final float[] a2 = new float[h];
        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);


        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                newValue(a1);
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                newValue(a2);
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);

        System.out.println("Время работы в два потока: " + (System.currentTimeMillis() - a));
    }


    /** Метод изменения значения для каждой ячейки массива
     * @param arr масиив, в котором будем менять значения*/
    public static void newValue(float[] arr){
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }
}
