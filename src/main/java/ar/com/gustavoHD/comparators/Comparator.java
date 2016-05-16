package ar.com.gustavoHD.comparators;

import java.util.function.Function;

/**
 * Created by gdohara on 16/05/2016.
 */
public interface Comparator<T> {

    int compare(T t1, T t2);

    static <U> Comparator<U> comparing(Function<U, Comparable> f) {
        return (p1, p2) -> f.apply(p1).compareTo(f.apply(p2));
    }

    default Comparator<T> thenComparing(Function<T, Comparable> f){
        return thenComparing(comparing(f));
    }

    default Comparator<T> thenComparing(Comparator<T> cmp){
        return (p1, p2) -> compare(p1, p2) == 0 ? cmp.compare(p1, p2) : compare(p1, p2);
    }
}
