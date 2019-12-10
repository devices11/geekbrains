package java_lvl2.Lesson1.Marathon;

import java_lvl2.Lesson1.Marathon.Participants.Cat;
import java_lvl2.Lesson1.Marathon.Participants.Dog;
import java_lvl2.Lesson1.Marathon.Participants.Human;
import java_lvl2.Lesson1.Marathon.Sections.Cross;
import java_lvl2.Lesson1.Marathon.Sections.Wall;
import java_lvl2.Lesson1.Marathon.Sections.Water;

public class Main {

    public static void main(String[] args) {
        Course c = new Course(new Cross(80), new Wall(2), new Water(50), new Cross(120)); // Создаем полосу препятствий
        Team team = new Team("Победители", new Human("Боб"), new Human("Бенни"), new Cat("Барсик"), new Dog("Бобик")); // Создаем команду

        c.doIt(team); // Просим команду пройти полосу
        team.showResults(); // Показываем результаты
    }
}

