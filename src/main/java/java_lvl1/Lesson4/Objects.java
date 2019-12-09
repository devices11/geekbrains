package java_lvl1.Lesson4;

/**
 * Created by Izotov V.A. on 24.11.2019.
 */
public class Objects{

    //4. Создать массив из 5 сотрудников:
    //   С помощью цикла вывести информацию только о сотрудниках старше 40 лет;
    public static void main(String[] args) {
        Person[] persArray = new Person[5];

        persArray[0] = new Person("Ivanov Ivan", "Engineer", " ivivan@mailbox.com ", "892315342", 90000,23);
        persArray[1] = new Person("Petrov Ivan", "Engineer", " Petrov@mailbox.com ", "8922345312", 40000,30);
        persArray[2] = new Person("Sidorov Ivan", "Engineer", " Sidorov@mailbox.com ", "892312323", 20000,50);
        persArray[3] = new Person("Pupkin Ivan", "Engineer", " Pupkin@mailbox.com ", "892312345", 60000,31);
        persArray[4] = new Person("Semenov Ivan", "Engineer", " Semenov@mailbox.com ", "892312334", 130000,42);

        for (Person person : persArray) {
            if (person.getAge() > 40)
                person.PersonInfo();
            System.out.println("");
        }

    }
}
