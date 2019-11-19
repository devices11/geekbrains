package FirstBlock;

import java.util.Scanner;

public class FirstBlock {
    public static void main(String[] args) {

        // 1.
        byte b = 10;
        short s = 2404;
        int i = 1234;
        long l = 1500L;
        float f = 120.0f;
        double d = 15.75;
        boolean bool = true;
        char c = 'F';
        String str = "Vaska";

        System.out.println(b);
        System.out.println(s);
        System.out.println(i);
        System.out.println(l);
        System.out.println(f);
        System.out.println(d);
        System.out.println(bool);
        System.out.println(c);
        System.out.println(str);

        // 2.

        Scanner scanner = new Scanner(System.in);
        String op = scanner.nextLine();

        System.out.println(op);
    }
}
