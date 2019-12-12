package java_lvl2.Lesson1.Marathon;

import java_lvl2.Lesson1.Marathon.Sections.Obstacle;

/**
 * Created by Izotov V.A. on 09.12.2019.
 */
class Course {

    //массив препятствий
    private Obstacle[] course;

    Course(Obstacle... course) {
        this.course = course;
    }

    /** Метод который просит команду пройти всю полосу препятствий
     * @param team ссылка на команду
     */
    void doIt(Team team) {
        for (int i = 0; i < team.getCompetitors().length; i++) {
            System.out.println(" ");
            for (Obstacle o : course) {
                o.doIt(team.getCompetitors()[i]);
                if (!team.getCompetitors()[i].isOnDistance())
                    break;
            }
        }
    }
}
