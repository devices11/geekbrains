package java_lvl1.Lesson4;

/**
 * Created by Izotov V.A. on 24.11.2019.
 */
public class Dog extends Animal {
    public Dog(String name){
        super(" Пес" + name);
        setRunLimit(500);
        setJumpLimit(0.5);
        setSwimLimit(10);
    }
}
