package ar.com.gustavoHD.streams;

import ar.com.gustavoHD.streams.model.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by gdohara on 18/05/2016.
 */
public class RangesInSteramSkipAndLimit {

    public static void main(String[] arg){
        List<Person> people = createListOfPersons();

        people.stream()
                .skip(2)    //skip first two
                .limit(3)   //limit the result to 3 elements
                .filter(person -> person.getAge() > 20)
                .forEach(System.out::println);

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
