package java_lvl1.Lesson4;

/**
 * Created by Izotov V.A. on 24.11.2019.
 */
public class TestAnimal {
    public static void main(String[] args) {

        System.out.println("Cat");
        Cat cat = new Cat("Барсик");
        cat.setJumpLimit(3);
        cat.setRunLimit(300);
        cat.Run(200);
        cat.Jump(7);
        cat.Swim(1);

        System.out.println("\nDog");
        Dog dog = new Dog("Barry");
        dog.Run(50);
        dog.Swim(56);
        dog.Jump(15);

    }
}
