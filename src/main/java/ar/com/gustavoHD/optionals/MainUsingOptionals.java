package main.java.ar.com.gustavoHD.optionals;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by gustavo on 15/05/16.
 */
public class MainUsingOptionals {

    public static void main(String[] args){
        List<Double> result = new ArrayList<>();

//        BAD PATTERN
//        ThreadLocalRandom.current()
//                .doubles(10_000).boxed().parallel()
//                .forEach(
//                        d -> NewMath.inv(d)
//                            .ifPresent(
//                                    inv -> NewMath.sqrt(inv)
//                                        .ifPresent(
//                                              sqrt -> result.add(sqrt)
//                                        )
//                            )
//                );
//
//        System.out.println("# result = " + result.size());

        Function<Double, Stream<Double>> flatMapper =
                d -> NewMath.inv(d)
                        .flatMap(inv -> NewMath.sqrt(inv))
                        .map(sqrt -> Stream.of(sqrt))
                        .orElseGet(() -> Stream.empty());

        final List<Double> rightResult = ThreadLocalRandom.current()
                .doubles(10_000).parallel()
                .boxed()
                .flatMap(flatMapper)
                .collect(Collectors.toList());

        System.out.println("# rightResult = " + rightResult.size());

    }
}
