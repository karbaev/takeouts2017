package PiratesSort;

import java.util.*;

/**
 * Created by Danila on 01.02.2017.
 */
public class PiratesMapDemo {
    public static void main(String[] args) {
        HashMap<String, Integer> pirates = new HashMap<>(); //Map<String, Integer> pirates = new TreeMap<>();
        pirates.put("Bill", 200);
        pirates.put("Bill", 200); //will not be added, key must be unique
        pirates.put("Silver", 100);
        pirates.put("One-leg", 5);
        pirates.put("Mini-we", 5);

        System.out.println(pirates);

        HashMap<Integer, String> pirates2 = new HashMap<>();
        pirates2.put(200, "Bill");
        pirates2.put(5, "One-leg");
        pirates2.put(100,"Silver");

        System.out.println(pirates2);

        //"sort" 1st map only by Keys
        TreeMap<String, Integer> tm = new TreeMap(pirates);
        System.out.println(tm);

        System.out.println();

        //"sort" 2nd map
        List<Integer> sortedKeys2 = new ArrayList<Integer>(pirates2.keySet());
        Collections.sort(sortedKeys2);
        for(Integer x : sortedKeys2){
            System.out.println(pirates2.get(x)+" "+x);
        }



    }
}
