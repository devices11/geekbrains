package Lesson4;

/**
 * Created by Izotov V.A. on 24.11.2019.
 */
public abstract class Animal {
    //5. Создать классы Собака и Кот с наследованием от класса Животное;
    //6. Животные могут выполнять действия: бежать, плыть, перепрыгивать препятствие.
    // В качестве параметра каждому методу передается величина, означающая или длину препятствия (для бега и плавания), или высоту (для прыжков);
    //9. * Добавить животным разброс в ограничениях. То есть у одной собаки ограничение на бег может быть 400 м., у другой – 600 м.

    public abstract void Run(int range, int limit);

    public abstract void Swim(int range, int limit);

    public abstract void Jump(float height, float limit);

}
