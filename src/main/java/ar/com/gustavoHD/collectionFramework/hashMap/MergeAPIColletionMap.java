package ar.com.gustavoHD.collectionFramework.hashMap;

import ar.com.gustavoHD.collectionFramework.model.City;
import ar.com.gustavoHD.collectionFramework.model.Person;

import java.util.*;

/**
 * Created by gdohara on 18/05/2016.
 */
public class MergeAPIColletionMap {

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

        Map<City, List<Person>> map1 = new HashMap<>();
        map1.computeIfAbsent(newYork, city -> new ArrayList<>()).add(p1);
        map1.computeIfAbsent(shanghai, city -> new ArrayList<>()).add(p2);
        map1.computeIfAbsent(shanghai, city -> new ArrayList<>()).add(p3);

        System.out.println("Map 1");
        map1.forEach((city, people) -> System.out.println(city + " : " + people));

        Map<City, List<Person>> map2 = new HashMap<>();
        map2.computeIfAbsent(shanghai, city -> new ArrayList<>()).add(p4);
        map2.computeIfAbsent(bsas, city -> new ArrayList<>()).add(p5);
        map2.computeIfAbsent(bsas, city -> new ArrayList<>()).add(p6);

        System.out.println("Map 2");
        map2.forEach((city, people) -> System.out.println(city + " : " + people));

        map2.forEach(
                (city, people) -> {
                    map1.merge(
                            city, people, //if city do not exist!!!
                            (peopleFromMap1, peopleFromMap2) -> {           //if city exist!!!
                                peopleFromMap1.addAll(peopleFromMap2);
                                return peopleFromMap1;
                            }
                    );
                }
        );

        System.out.println("Map 1 merged with Map 2");
        map1.forEach((city, people) -> System.out.println(city + " : " + people));


    }
}
