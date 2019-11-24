package Lesson4;

/**
 * Created by Izotov V.A. on 24.11.2019.
 */
public class Dog extends Animal {
    //    7. У каждого животного есть ограничения на действия (бег: кот – 200 м., собака – 500 м.;
    //    прыжок: кот – 2 м., собака – 0.5 м.; плавание: кот не умеет плавать, собака – 10 м.);
    //    8. При попытке животного выполнить одно из этих действий, оно должно сообщить результат в консоль. (Например, dog1.run(150); -> результат: run: true);
    //    9* Добавить животным разброс в ограничениях. То есть у одной собаки ограничение на бег может быть 400 м., у другой – 600 м.

    public void Run(int range, int limit) {
        System.out.println((range > limit) ? "Run: false" : "Run: true");
    }

    public void Swim(int range, int limit) {
        System.out.println((range > limit) ? "Swim: false" : "Swim: true");
    }

    public void Jump(float height, float limit) {
        System.out.println((height > limit) ? "Jump: false" : "Jump: true");
    }
}
