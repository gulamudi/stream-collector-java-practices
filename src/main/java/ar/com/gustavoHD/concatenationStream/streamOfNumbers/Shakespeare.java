package ar.com.gustavoHD.concatenationStream.streamOfNumbers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.Set;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

/**
 * Created by gustavo on 15/05/16.
 */
public class Shakespeare {

    public static void main(String[] args) throws IOException {
        Set<String> shakespeareWords = Files. lines(Paths.get("files/words.shakespeare.txt"))
                .map(word -> word.toLowerCase())
                .collect(Collectors.toSet());

        Set<String> scrabbleWords = Files. lines(Paths.get("files/ospd.txt"))
                .map(word -> word.toLowerCase())
                .collect(Collectors.toSet());

        System.out.println("# words of shakespeare : " + shakespeareWords.size());
        System.out.println("# words of scrabble : " + scrabbleWords.size());

        final int [] scrabbleENScore = {
                // a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p,  q, r, s, t, u, v, w, x, y,  z
                1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10} ;

        Function<String, Integer> score =
                word -> word.chars().map(letter -> scrabbleENScore[letter - 'a']).sum();

        ToIntFunction<String> intScore =
                word -> word.chars().map(letter -> scrabbleENScore[letter - 'a']).sum();


        final String bestWord = shakespeareWords.stream()
                .filter(word -> scrabbleWords.contains(word))
                .max(Comparator.comparing(score))
                .get();

        System.out.println("Best word: " + bestWord);

        final IntSummaryStatistics summaryStatistics = shakespeareWords.stream().parallel()
                .filter(scrabbleWords::contains)
                .mapToInt(intScore)
                .summaryStatistics();

        System.out.println("Stats: " + summaryStatistics);

    }


}
