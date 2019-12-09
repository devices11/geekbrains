package java_lvl1.Lesson4;

/**
 * Created by Izotov V.A. on 24.11.2019.
 */
public class Cat extends Animal{
    public Cat(String name){
        super("Кот: " + name);
        setRunLimit(200);
        setJumpLimit(2);

    }

    public void Swim(int range) {
        System.out.println("Кот не плавает");
    }

}
