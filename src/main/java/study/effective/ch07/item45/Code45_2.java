package study.effective.ch07.item45;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

@Slf4j
public class Code45_2 {
    public static void main(String[] args) throws IOException, URISyntaxException {
        Path path = Paths.get(ClassLoader.getSystemResource("news.txt").toURI());
        int minGroupSize = 1;

        try(Stream<String> words = Files.lines(path)) {
            words.collect(
                groupingBy(word->word.chars().sorted()
                    .collect(StringBuilder::new, (sb,c) ->sb.append((char)c), StringBuilder::append).toString())
            )
            .values().stream()
            .filter(group->group.size()>=minGroupSize)
            .map(group->group.size() + ":" + group)
            .forEach(s->log.info(s));
        }
    }
}
