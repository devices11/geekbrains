package FirstBlock;

public class FirstBlock {

    // 3. Написать метод, вычисляющий выражение a * (b + (c / d)) и возвращающий результат, где a, b, c, d – входные параметры этого метода;
    static double task_3(double a, double b, double c, double d){
        return a * (b + (c / d));
    }

    //4. Написать метод, принимающий на вход два числа, и проверяющий, что их сумма лежит в пределах от 10 до 20 (включительно), если да – вернуть true, в противном случае – false;
    static boolean task_4(int a, int b){
        if((a + b) >= 10 && (a + b) <= 20)
            return true;
        else
            return false;
    }

    //5. Написать метод, которому в качестве параметра передается целое число, метод должен напечатать в
    // консоль положительное число передали или отрицательное (Замечание: ноль считаем положительным числом.);
    static void task_5(int a){
        if(a >= 0)
            System.out.println("Число положительное");
        else
            System.out.println("Число отрицательное");
    }

    //6. Написать метод, которому в качестве параметра передается целое число, метод должен вернуть true, если число отрицательное;
    static boolean task_6(int a){
        return a < 0;
    }

    //7. Написать метод, которому в качестве параметра передается строка, обозначающая имя, метод должен вывести в консоль сообщение «Привет, указанное_имя!»;
    static void task_7(String name){
        System.out.println("Привет, " + name + "!");
    }

    //8. *Написать метод, который определяет, является ли год високосным, и выводит сообщение в консоль.
    // Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
    static void task_8(int year){
        if(((year % 4 == 0) && !(year % 100 == 0)) || (year % 400 == 0))
            System.out.println(year + "г. - високосный год");
        else
            System.out.println(year + "г. - не високосный год");
    }

    //9. *Не набирая код в IDE, ответьте на следующий вопрос. Есть два метода:
    //void myMethod(int a, String b) {}
    //void myMethod(String b, int a) {}
    //
    //Это две разных сигнатуры одного метода или один и тот же метод?
    /**---Ответ: это два разных сигнатуры метода----*/


    //1. Создать пустой проект в IntelliJ IDEA и прописать метод main();
    public static void main(String[] args) {

        // 2. Создать переменные всех пройденных типов данных, и инициализировать их значения;
        byte bt = 10;
        short s = 2404;
        int i = 1234;
        long l = 1500L;
        float f = 120.0f;
        double db = 15.75;
        boolean bool = true;
        char ch = 'F';
        String str = "Vaska";

//        System.out.println(task_3(1,2,3,4));
//
//        System.out.println(task_4(1,2));
//        System.out.println(task_4(9,1));
//        System.out.println(task_4(25,0));
//
//        task_5(5);
//        task_5(-1);
//        task_5(0);
//
//        System.out.println(task_6(5));
//        System.out.println(task_6(0));
//        System.out.println(task_6(-1));
//
//        task_7("Васька");
//
//        task_8(2019);
//        task_8(2020);
//        task_8(2000);

    }
}
