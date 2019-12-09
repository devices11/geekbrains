package java_lvl1.Lesson4;

/**
 * Created by Izotov V.A. on 24.11.2019.
 */
public abstract class Animal {
    //5. Создать классы Собака и Кот с наследованием от класса Животное;
    //6. Животные могут выполнять действия: бежать, плыть, перепрыгивать препятствие.
    // В качестве параметра каждому методу передается величина, означающая или длину препятствия (для бега и плавания), или высоту (для прыжков);
    //9. * Добавить животным разброс в ограничениях. То есть у одной собаки ограничение на бег может быть 400 м., у другой – 600 м.
    protected String name;

    protected int runLimit = 0;
    protected int swimLimit = 0;
    protected double jumpLimit = 0;

    public Animal(String name) {
        this.name = name;
    }

    public void setRunLimit(int runLimit) {
        this.runLimit = runLimit;
    }

    public void setSwimLimit(int swimLimit) {
        this.swimLimit = swimLimit;
    }

    public void setJumpLimit(double jumpLimit) {
        this.jumpLimit = jumpLimit;
    }

    public void Run(int range) {
        System.out.println((range > 0 && range > runLimit) ? "Run: false" : "Run: true");
    }

    public void Swim(int range) {
        System.out.println((range > 0 && range > swimLimit) ? "Run: false" : "Run: true");
    }

    public void Jump(double height) {
        System.out.println((height > 0 && height > jumpLimit) ? "Jump: false" : "Jump: true");
    }

}
