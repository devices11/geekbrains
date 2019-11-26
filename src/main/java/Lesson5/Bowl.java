package Lesson5;

/**
 * Created by Izotov V.A. on 24.11.2019.
 */
public class Bowl{
    private int volumeBowl;
    private String nameBowl;

    public Bowl(int volumeBowl, String nameBowl) {
        this.volumeBowl = volumeBowl;
        this.nameBowl = nameBowl;
    }

    public void setNameBowl(String nameBowl) {
        this.nameBowl = nameBowl;
    }

    public int getVolumeBowl() {
        return volumeBowl;
    }

    public void setVolumeBowl(int volumeBowl) {
        this.volumeBowl = volumeBowl;
    }

    public void addFood( int food) {
        setVolumeBowl(getVolumeBowl() + food);
        System.out.println("В миске теперь " + getVolumeBowl() + " еды");
    }
}
