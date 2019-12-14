package java_lvl2.Lesson2;

/**
 * Created by Izotov V.A. on 14.12.2019.
 */
public enum DayOfWeek {
    SUNDAY("Воскресенье", 0), MONDAY("Понедельник", 40), TUESDAY("Вторник", 32), WEDNESDAY
            ("Среда", 24), THURSDAY("Четверг", 16), FRIDAY("Пятница", 8), SATURDAY("Суббота", 0);

    private String rus;
    private int workingHours;

    public String getRus() {
        return rus;
    }

    public int getWorkingHours() {
        return workingHours;
    }

    DayOfWeek(String rus, int workingHours) {
        this.rus = rus;
        this.workingHours = workingHours;
    }
}


class DayOfWeekMain {

    public static void main(final String[] args) {
        System.out.println(getWorkingHours(DayOfWeek.SUNDAY));
        System.out.println(getWorkingHours(DayOfWeek.MONDAY));
        System.out.println(getWorkingHours(DayOfWeek.TUESDAY));
        System.out.println(getWorkingHours(DayOfWeek.WEDNESDAY));
        System.out.println(getWorkingHours(DayOfWeek.THURSDAY));
        System.out.println(getWorkingHours(DayOfWeek.FRIDAY));
        System.out.println(getWorkingHours(DayOfWeek.SATURDAY));
    }

    private static String getWorkingHours(DayOfWeek dayOfWeek){
        if (dayOfWeek.getWorkingHours() > 0)
            return "Сегодня " + dayOfWeek.getRus() + ". До конца рабочей недели осталось: " + dayOfWeek.getWorkingHours() + " часов.";
        else
            return "Сегодня выходной.";
    }
}