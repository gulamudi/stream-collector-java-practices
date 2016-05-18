package ar.com.gustavoHD.streams;

import ar.com.gustavoHD.streams.model.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Created by gdohara on 18/05/2016.
 */
public class SimpleReductions {

    public static void main(String[] arg){
        List<Person> people = createListOfPersons();

        people.stream();

        //MATCH

        //anyMatch()
        boolean any = people.stream()
                .anyMatch(p -> p.getAge() > 20); //return true if at least one element matches the predicate

        boolean all = people.stream()
                .allMatch(p -> p.getAge() > 20); //return true if all the elements match the predicate

        boolean none = people.stream()
                .noneMatch(p -> p.getAge() > 20); //return true if no element matches the predicate


        //FIND REDUCTION

        Optional<Person> optFindFirst =
                people.stream()
                    .findFirst(); //the stream has to have a order if not any element is returned

        Optional<Person> optAnyFind =
                people.stream()
                        .findAny(); //return any person if it exist, and un empty optional if do not exist



        //REDUCE
        int sumOfAges = people.stream()
                            .map(p -> p.getAge())
                            .reduce(0, (a1, a2) -> a1 + a2);
        System.out.println("sum of ages " + sumOfAges);

        int maxOfAges = people.stream()
                .map(p -> p.getAge())
                .reduce(0, (a1, a2) -> Integer.max(a1, a2));
        System.out.println("max of ages " + maxOfAges);


        //this is for parallel purpos   es
        List<Integer> ages =
                people.stream()
                    .reduce(
                            new ArrayList<Integer>(),
                            (list, p) -> {list.add(p.getAge()); return list;},
                            (list1, list2) -> { list1.addAll(list2); return list1;}
                    );
        ages.forEach(System.out::println);


    }

    private static List<Person> createListOfPersons() {
        Person p1 = new Person("Alice", 23);
        Person p2 = new Person("Brian", 56);
        Person p3 = new Person("Chelsen", 46);
        Person p4 = new Person("David", 28);
        Person p5 = new Person("Erica", 37);
        Person p6 = new Person("Pepe", 18);

        List<Person> people = new ArrayList(Arrays.asList(p1, p2, p3, p4, p5, p6));
        return people;
    }
}
