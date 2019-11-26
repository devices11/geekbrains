package Lesson5;

/**
 * Created by Izotov V.A. on 24.11.2019.
 */
public class Cat  extends Animal implements Eating{
    public Cat(String name, int appetite){
        super(name);
        setAppetite(appetite);
    }

    public void Swim(int range) {
        System.out.println("Кот не плавает");
    }

    public void eat(Bowl bowl,int appetite){
        if ((bowl.getVolumeBowl() - appetite) < 0) {
            System.out.println("В миске мало еды! Нужно добавить.");
        }
        else {
            bowl.setVolumeBowl(bowl.getVolumeBowl() - appetite);
            setFullsatiation(getFullsatiation()+appetite);
            System.out.println("Кот довольно кушает. В миске осталось " + bowl.getVolumeBowl() + " еды");
        }
    }

    public boolean satiety(Cat cat) {
        return cat.getFullsatiation() > 0;
    }

}
