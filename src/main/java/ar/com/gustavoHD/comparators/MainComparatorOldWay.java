package ar.com.gustavoHD.comparators;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by gdohara on 16/05/2016.
 */
public class MainComparatorOldWay {

    Comparator<String> comparator = new Comparator<String>() {
        @Override
        public int compare(String t1, String t2) {
            return Integer.compare(t1.length(), t2.length());
        }
    };

    public static void main(String[] args){

        String[] myArrays= {"a", "abc", "ab"};

        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String t1, String t2) {
                return Integer.compare(t1.length(), t2.length());
            }
        };

        Arrays.sort(myArrays, comparator);

    }
}
