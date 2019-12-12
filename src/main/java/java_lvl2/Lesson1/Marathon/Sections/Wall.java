package java_lvl2.Lesson1.Marathon.Sections;

import java_lvl2.Lesson1.Marathon.Participants.Competitor;

public class Wall extends Obstacle {
    private int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public void doIt(Competitor competitor) {
        competitor.jump(height);
    }
}