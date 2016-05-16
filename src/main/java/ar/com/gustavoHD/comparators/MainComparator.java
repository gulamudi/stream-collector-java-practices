package ar.com.gustavoHD.comparators;

import java.util.function.Function;

/**
 * Created by gdohara on 16/05/2016.
 */
public class MainComparator {

    public static void main(String[] args){
        Comparator<Person> cmpAge = (p1, p2) -> p2.getAge() - p1.getAge();
        Comparator<Person> cmpFirstName = (p1, p2) -> p1.getFirstName().compareTo(p2.getFirstName());
        Comparator<Person> cmpLastName = (p1, p2) -> p1.getSecondName().compareTo(p2.getSecondName());

        Function<Person, Integer> f1 = p -> p.getAge();
        Function<Person, String> f2 = p-> p.getFirstName();
        Function<Person, String> f3 = p-> p.getSecondName();

        Comparator<Person> cmpPersonAge = Comparator.comparing(Person::getAge);
        //or Comparator<Person> cmpPersonAge = Comparator.comparing(f1);
        //or Comparator<Person> cmpPersonAge = Comparator.comparing(p.getAge());
        //or Comparator<Person> cmpPersonAge = Comparator.comparing(Person::getAge);
        Comparator<Person> cmpPersonLastName = Comparator.comparing(Person::getSecondName);

        Comparator<Person> cmp = cmpAge.thenComparing(cmpPersonLastName);

        Comparator<Person> cmpPerson = Comparator.comparing(Person::getSecondName)
                                            .thenComparing(Person::getFirstName)
                                            .thenComparing(Person::getAge);

    }

}
