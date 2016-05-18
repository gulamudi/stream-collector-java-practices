package ar.com.gustavoHD.streams;

import ar.com.gustavoHD.streams.model.Person;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by gdohara on 18/05/2016.
 */
public class MainBuildingStreams {

    public static void main(String[] args) throws IOException {
        Person p1 = new Person("Alice", 23);
        Person p2 = new Person("Brian", 56);
        Person p3 = new Person("Chelsen", 46);
        Person p4 = new Person("David", 28);
        Person p5 = new Person("Erica", 37);
        Person p6 = new Person("Pepe", 18);

        List<Person> people = new ArrayList(Arrays.asList(p1, p2, p3, p4, p5, p6));

        Stream<Person> stream = people.stream();

        // an empty Stream
        Stream.empty();

        //a singleton Stream
        Stream.of("one");

        //a stream with several elements
        Stream.of("one", "two", "tree");

        //a constant Stream
        Stream.generate(() -> "one");

        //a growing Stream
        Stream.iterate("+", s -> s + "+");
                //.limit(10)
                //.forEach(System.out::println);

        //a random Stream
        ThreadLocalRandom.current().ints();
            //.limit(10)
            //.forEach(System.out::println);

        //a Stream on the letters of a String
        IntStream streamChars = "hello".chars();
//        streamChars
//            .forEach(System.out::println);

        //a Stream on a regular expression
//        CharSequence book = null;
//        Stream<String> words =
//                Pattern.compile("^\\p{javaLetter}")
//                    .splitAsStream(book);

        //a Stream on the lines of a text file
        //Path path = Paths.get("/tmp/people.txt");
        //Stream<String> lines = Files.lines(path);

        Stream<String> streamOfStrings = Stream.generate(() -> "one");
        streamOfStrings.limit(5).forEach(System.out::println);
    }
}
