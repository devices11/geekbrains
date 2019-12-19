package java_lvl2.Lesson3;

import java.util.*;

/**
 * Created by Izotov V.A. on 16.12.2019.
 */
public class PhoneBook {

    /** Создаем мапу для телефонного справочника. Т.к. ключи мапы уникальны,
     * для случаев однофомильцев value делаем List
     */
    private Map<String, List<String>> phoneMap = new HashMap<String, List<String>>();

    /** Добавление в справочник записи
     * @param surname фамилия
     * @param phone номер телефона
     */
    private void add(String surname, String phone){
        List<String> currentValue = phoneMap.get(surname);

        if (currentValue == null) {
            currentValue = new ArrayList<String>();
            phoneMap.put(surname, currentValue);
        }

        currentValue.add(phone);
    }

    /** Возвращает номера телефонов из справочника
     * @param surname искомая фамилия
     */
    private void get(String surname){
        if (phoneMap.containsKey(surname))
            System.out.println(surname + phoneMap.get(surname));
        else
            System.out.println("Запись с фамилией " + surname + " отсутствует");
    }


    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Иванов", "79998581112");
        phoneBook.add("Петров", "79992381113");
        phoneBook.add("Сидоров", "7 999 238 11 13");
        phoneBook.add("Петров", "+79992382223");

        phoneBook.get("Петров");
        phoneBook.get("Сидоров");
        phoneBook.get("Пупкин");
    }
}
