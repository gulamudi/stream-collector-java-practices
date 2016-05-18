package ar.com.gustavoHD.streams;

import java.io.IOException;
import java.util.stream.Stream;

/**
 * Created by gdohara on 18/05/2016.
 */
public class BuildStreamsPatternsExample {

    public static void main(String[] args){

        //first build a Stream.Builder
        Stream.Builder<String> builder = Stream.builder();

        //by chaining the add() method
        builder.add("one").add("two").add("three");
        //or by calling accept()
        builder.accept("four");

        //finally call the build() method
        Stream<String> stream = builder.build();

        //used it
        stream.forEach(System.out::println);


    }
}
