package ar.com.gustavoHD.functionalInterfaces.predicates;

import java.util.function.Predicate;

/**
 * Created by gdohara on 17/05/2016.
 */
public class DiferentesWaysToCreatePredicates {

    public static void main(String[] args){
        Predicate<String> p = createPredicateLambdaExpresionWay();
        System.out.println(p.test("Hello World!"));
    }

    public Predicate<String> createPredicateJDK_7_old_way(){
        Predicate<String> p = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.length() < 20;
            }
        };
        return p;
    }

    public static Predicate<String> createPredicateLambdaExpresionWay(){
        Predicate<String> p = (s) -> s.length() < 20;
        //or Predicate<String> p = (String s) -> s.length() < 20;
        return p;
    }
}
