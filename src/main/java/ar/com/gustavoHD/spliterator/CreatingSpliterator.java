package ar.com.gustavoHD.spliterator;



import ar.com.gustavoHD.spliterator.model.Person;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Spliterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * Created by gustavo on 09/05/16.
 */
public class CreatingSpliterator {

    public static void main(String[] args){
        Path path = Paths.get("/tmp/people.txt");

        try (Stream<String> lines = Files.lines(path);) {
            Spliterator<String> lineSpliterator = lines.spliterator();
            Spliterator<Person> peopleSpliterator = new PersonSpliterator(lineSpliterator);

            Stream<Person> peoples = StreamSupport.stream(peopleSpliterator, false);
            peoples.forEach(System.out::println);


        } catch (IOException e) {
            e.printStackTrace();
        }

    }



}
