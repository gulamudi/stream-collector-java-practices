package ar.com.gustavoHD.parallelProcessing;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by gustavo on 15/05/16.
 */
public class ParallelStreams {

    public static void main(String[] args){

        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "2");

        List<String> strings = new CopyOnWriteArrayList<>(); //terrible performance

        final List<String> collect = Stream.iterate("+", s -> s + "+")
                .parallel()
                .limit(1_000)
//                .peek(s -> System.out.println(s + "Proccessed in the Thread " + Thread.currentThread().getName()))
                //.forEach(s -> strings.add(s));
                .collect(Collectors.toList());

        System.out.println("# of strings:" + collect.size());
    }
}
