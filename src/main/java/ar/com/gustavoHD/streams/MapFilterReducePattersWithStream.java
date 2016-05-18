package ar.com.gustavoHD.streams;

import ar.com.gustavoHD.streams.model.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by gdohara on 18/05/2016.
 */
public class MapFilterReducePattersWithStream {

    public static void main(String[] args){
        List<Person> people = createListOfPersons();

        people.stream()                             //Stream<Person>
                .map(p -> p.getAge())               //Stream<Integer>
                .filter(age -> age > 20)            //Stream<Integer> different stream
                .forEach(System.out::println);

        //second way to writing it
        people.stream()
                .filter(p -> p.getAge() > 20)       //Stream<Person>
                .forEach(System.out::println);

        //using peek
        System.out.println("Using peek");
        people.stream()
                .map(p -> p.getAge())
                //.forEach(System.out::println); //DOES NOT COMPILE !!!
                .peek(System.out::println)
                .filter(age -> age > 20)
                .forEach(System.out::println); //IF USE PEEK INSTEAD OF forEach NOTHING IS PRINTING, peek is an intermediate operation, if no terminal operation --> no data is ever processed


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
