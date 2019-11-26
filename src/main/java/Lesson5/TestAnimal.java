package Lesson5;

/**
 * Created by Izotov V.A. on 24.11.2019.
 */
public class TestAnimal {
    public static void main(String[] args) {

        Cat[] catArray = new Cat[5];

        catArray[0] = new Cat("Барсик", 35);
        catArray[1] = new Cat("Рыжик", 32);
        catArray[2] = new Cat("Серый", 30);
        catArray[3] = new Cat("Бампер", 25);
        catArray[4] = new Cat("BOSS", 45);

        System.out.println("Держите котики миску с едой! Кис кис кис!!!");
        System.out.println("\nСтавим котикам полную миску еды");
        Bowl bowl = new Bowl(150, "Миска");

        for (Cat cat: catArray){
            System.out.println(cat.getName() + " подбегает к миске");
            cat.eat(bowl,cat.getAppetite());

            if (cat.satiety(cat)) {
                System.out.println("Котик наелся");
            }
            else {
                System.out.println("Котику не хватило еды");
            }
        }

        System.out.println("\nНе всем хватило еды, вот еще");
        bowl.addFood(100);

        for (Cat cat: catArray){
            if (cat.getFullsatiation() == 0){
                System.out.println(cat.getName() + " подбегает к миске.");
                cat.eat(bowl,cat.getAppetite());

                if (cat.satiety(cat)) {
                    System.out.println("Котик наелся");
                }
                else {
                    System.out.println("Котику не хватило еды");
                }
            }
        }

        System.out.println("\nНу наконец-то , все котики наелись");

    }
}
