package ar.com.gustavoHD.collectionFramework.hashMap;

import ar.com.gustavoHD.collectionFramework.model.City;
import ar.com.gustavoHD.collectionFramework.model.Person;

import java.util.*;

/**
 * Created by gdohara on 18/05/2016.
 */
public class MainAPIColletionMap {

    public static void main(String[] args) {
        Person p1 = new Person("Alice", 23);
        Person p2 = new Person("Brian", 56);
        Person p3 = new Person("Chelsen", 46);
        Person p4 = new Person("David", 28);
        Person p5 = new Person("Erica", 37);
        Person p6 = new Person("Pepe", 18);

        City newYork = new City("New York");
        City shanghai = new City("Shanghai");
        City bsas = new City("Buenos Aires");

        Map<City, List<Person>> map = new HashMap<>();

        map.putIfAbsent(bsas, new ArrayList<>());
        map.get(bsas).add(p1);

        map.computeIfAbsent(newYork, city -> new ArrayList<>()).add(p2);
        map.computeIfAbsent(newYork, city -> new ArrayList<>()).add(p3);

        System.out.println("People from bs as : " + map.getOrDefault(bsas, Collections.EMPTY_LIST));
        System.out.println("People from new york : " + map.getOrDefault(newYork, Collections.EMPTY_LIST));


    }
}
