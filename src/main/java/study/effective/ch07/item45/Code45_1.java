package study.effective.ch07.item45;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

@Slf4j
public class Code45_1 {
    public static void main(String[] args) throws FileNotFoundException, URISyntaxException {
        Path path = Paths.get(ClassLoader.getSystemResource("news.txt").toURI());
        int minGroupSize = 1;

        Map<String, Set<String>> groups = new HashMap<>();
        try(Scanner scanner = new Scanner(path.toFile())) {
            int i = 0;
            while(scanner.hasNext()) {
                String word = scanner.next();
                groups.computeIfAbsent(alphabetize(word), (unused)->new TreeSet<>()).add(word);
            }
        }

        for(Set<String> group: groups.values())
            if(group.size() >= minGroupSize)
                log.info("{} : {}", group.size(), group);
    }

    private static String alphabetize(String word) {
        char[] charsWord = word.toCharArray();
        Arrays.sort(charsWord);
        return new String(charsWord);
    }
}
