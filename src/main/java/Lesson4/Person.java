package Lesson4;

/**
 * Created by Izotov V.A. on 24.11.2019.
 */

//1. Создать класс «Сотрудник» с полями: ФИО, должность, email, телефон, зарплата, возраст;
public class Person {
    private String FIO;
    private String position;
    private String email;
    private String phone;
    private int salary;
    private int age;

    //2. Конструктор класса должен заполнять эти поля при создании объекта;
    public Person(String FIO, String position, String email, String phone, int salary, int age) {
        this.FIO = FIO;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    //3. Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль;
    public void PersonInfo(){
        System.out.println("ФИО сотрудника: " + FIO);
        System.out.println("Должность сотрудника: " + position);
        System.out.println("Еmail сотрудника: " + email);
        System.out.println("Телефон сотрудника: " + phone);
        System.out.println("Зарплата сотрудника: " + salary);
        System.out.println("Возраст сотрудника: " + age);
    }

    public int getAge() {
        return age;
    }
}
