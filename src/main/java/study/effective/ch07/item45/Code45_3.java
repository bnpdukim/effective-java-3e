package study.effective.ch07.item45;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

@Slf4j
public class Code45_3 {
    public static void main(String[] args) throws IOException, URISyntaxException {
        Path path = Paths.get(ClassLoader.getSystemResource("news.txt").toURI());
        int minGroupSize = 1;

        try(Stream<String> words = Files.lines(path)) {
            words.collect(
                groupingBy(word->alphabetize(word))
            )
            .values().stream()
            .filter(group->group.size()>=minGroupSize)
            .forEach(group->log.info("{} : {}", group.size(), group));
        }
    }

    private static String alphabetize(String word) {
        char[] charsWord = word.toCharArray();
        Arrays.sort(charsWord);
        return new String(charsWord);
    }
}
