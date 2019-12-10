package java_lvl2.Lesson1.Marathon.Sections;

import java_lvl2.Lesson1.Marathon.Participants.Competitor;

public class Water extends Obstacle {
    private int length;

    public Water(int length) {
        this.length = length;
    }

    @Override
    public void doIt(Competitor competitor) {
        competitor.swim(length);
    }
}