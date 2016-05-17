package ar.com.gustavoHD.functionalInterfaces.predicates.demo;

/**
 * Created by gdohara on 17/05/2016.
 */
@FunctionalInterface
public interface Predicate<T> {

    public boolean test(T t);

    default Predicate<T> and(Predicate<T> other){
        return t -> test(t) && other.test(t);
    }

    default Predicate<T> or(Predicate<T> other){
        return t -> test(t) || other.test(t);
    }

    static <U> Predicate<U> isEqualsTo(U u){
        return s -> s.equals(u);
    }
}
