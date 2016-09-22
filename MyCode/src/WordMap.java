import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class WordMap {
	public static void getWordMapFromTextFile(Path filePath) throws IOException
	{
		
		// Read file
		
		Stream<String> linesInFile = Files.lines(filePath);
				
		Map<String, Long> wordMap = 
		linesInFile.flatMap(s->Stream.of(s.split("\\W+")))
				.filter(s -> s.length() > 0)
				.map(s->s.toLowerCase())
				.collect(Collectors.groupingBy(
						Function.identity(), 
						Collectors.counting()));
		
		wordMap.entrySet().stream()
				.sorted((a,b)->b.getValue().compareTo(a.getValue()))
				.limit(200)
				.forEach(o->System.out.println(o));			
										
		
	}
}
