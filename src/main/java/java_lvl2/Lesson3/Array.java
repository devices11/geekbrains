package java_lvl2.Lesson3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Izotov V.A. on 19.12.2019.
 */
public class Array {

    private void countWords(ArrayList arrayList){
        Set<String> set = new HashSet<String>(arrayList);
        System.out.println(set);

        for (int i = 0; i < set.size(); i++){
            int count = 0;
            for (Object o : arrayList) {

                if (arrayList.get(i).equals(o)) {
                    count++;
                }
            }

            if (count == 2 || count == 3 || count == 4)
                System.out.println("Слово \"" + arrayList.get(i) + "\" встречается " + count + " раза.");
            else
                System.out.println("Слово \"" + arrayList.get(i) + "\" встречается " + count + " раз.");
        }
    }
    public static void main(String[] args) {
        ArrayList<String> arr = new ArrayList<String>();

        arr.add("ОСПАРИВАТЬ");
        arr.add("ЗЛОКОЗНЕННЫЙ");
        arr.add("БАРИЧ");
        arr.add("СОЧИНИТЬ");
        arr.add("СОЧИНИТЬ");
        arr.add("ДЖИНСЫ");
        arr.add("ОСПАРИВАТЬ");
        arr.add("ЗАСЛУШАТЬСЯ");
        arr.add("ЗЕЛЕНЩИЦА");
        arr.add("ЗЕЛЕНЩИЦА");
        arr.add("ЗЛОКОЗНЕННЫЙ");
        arr.add("ЗЛОКОЗНЕННЫЙ");
        arr.add("ЗЛОКОЗНЕННЫЙ");
        arr.add("ЗЛОКОЗНЕННЫЙ");
        arr.add("ЗЛОКОЗНЕННЫЙ");
        arr.add("ЗЛОКОЗНЕННЫЙ");

        new Array().countWords(arr);

    }
}
