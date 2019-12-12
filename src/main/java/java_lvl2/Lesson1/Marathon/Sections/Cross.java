package java_lvl2.Lesson1.Marathon.Sections;

import java_lvl2.Lesson1.Marathon.Participants.Competitor;

public class Cross extends Obstacle {
    private int length;

    public Cross(int length) {
        this.length = length;
    }

    @Override
    public void doIt(Competitor competitor) {
        competitor.run(length);
    }
}