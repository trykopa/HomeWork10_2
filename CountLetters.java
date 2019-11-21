package HomeWork10_3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountLetters {

	public static void main(String[] args) throws IOException {
		String file = "/Users/at/eclipse-workspace/oop/HomeWork10_3/test.txt";
		String myString = fileToString(file).replaceAll("[^\\p{L}\\p{Nd}]+", "");
		System.out.println(myString);
		
		Map<Character, Integer> frequency =
				myString.chars()
	               .mapToObj(c -> (char)c)
	               .collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(c -> 1)));
		
		System.out.println(frequency);
		
		frequency.entrySet().stream()
	    .sorted(Comparator.comparing(Map.Entry<Character, Integer>::getValue).reversed())
	    .forEach(entry -> System.out.printf("'%c' : %d%n", entry.getKey(), entry.getValue()));

	}
	
	public static String fileToString(String file) throws IOException {
		String line = "";
		BufferedReader reader = new BufferedReader(new FileReader(file));
		StringBuilder sb = new StringBuilder();
		
        while( ( line = reader.readLine() ) != null ) {
            sb.append( line );
        }
        
        sb.deleteCharAt(sb.length()-1);
        reader.close();
        return sb.toString().toLowerCase();
		
	}
	
}

