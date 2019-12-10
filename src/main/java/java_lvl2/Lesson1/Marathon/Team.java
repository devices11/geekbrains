package java_lvl2.Lesson1.Marathon;

import java_lvl2.Lesson1.Marathon.Participants.*;

/**
 * Created by Izotov V.A. on 09.12.2019.
 */
class Team {

    private String name_party;
    private Competitor[] competitors;


    Team(String name_party, Competitor... competitors) {
        this.name_party = name_party;
        this.competitors = competitors;
    }

    Competitor[] getCompetitors() {
        return competitors;
    }

    /** Метод для вывода информации о членах команды прошедших дистанцию, метод вывода информации обо всех членах команды
     */
    void showResults(){
        System.out.println("\nКоманда: " + name_party);
        for (Competitor c : competitors) {
            c.info();
        }
    }

}
