package concordance;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Concordance {
    public static void main(String[] args) throws Throwable {
        try (Stream<String> input = Files.lines(Paths.get("Pride.txt"))) {
            input.flatMap(s->Stream.of(s.split("\\W+")))
                    .filter(s->s.length() > 0)
                    .map(String::toLowerCase)
                    .collect(Collectors.groupingBy(Function.identity(), 
                            Collectors.counting()))
                    .entrySet().stream()
                    .sorted((a,b)->b.getValue().compareTo(a.getValue()))
                    .limit(200)
                    .forEach(System.out::println);
        }
    }
}
