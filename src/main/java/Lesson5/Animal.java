package Lesson5;

/**
 * Created by Izotov V.A. on 24.11.2019.
 */
public abstract class Animal {
    private String name;

    private int runLimit = 0;
    private int swimLimit = 0;
    private double jumpLimit = 0;
    private int appetite = 0;       //аппетит
    private int fullsatiation = 0;  //насыщенность

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
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

    public int getAppetite() {
        return appetite;
    }

    public void setAppetite(int appetite) {
        this.appetite = appetite;
    }


    public int getFullsatiation() {
        return fullsatiation;
    }

    public void setFullsatiation(int fullsatiation) {
        this.fullsatiation = fullsatiation;
    }

    public void Run(int range) {
        System.out.println((range > 0 && range > runLimit) ? "Run: false" : "Run: true");
    }

    public void Swim(int range) {
        System.out.println((range > 0 && range > swimLimit) ? "Run: false" : "Swim: true");
    }

    public void Jump(double height) {
        System.out.println((height > 0 && height > jumpLimit) ? "Jump: false" : "Jump: true");
    }

}
