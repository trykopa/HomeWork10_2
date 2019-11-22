package HomeWork10_3;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamHW {

	public static void main(String[] args) throws IOException{
		// fill the array with 10 random integers from -100 to 100
		int[] my = randomAr(10);
		
		int result = findMinAbs(my);
		System.out.format("%n%d - is a number from Array with an ABS closest to 0%n%n", result);
		
		//String to stream of int 
		String myStr = "The String class represents character strings.";
		int[] array = myStr.chars().toArray();
		System.out.println(Arrays.toString(array));
		
		
		String intfile = "/Users/at/eclipse-workspace/oop/HomeWork10_3/intfile.txt";
		System.out.format("Max int in %s found - %n%d", intfile, findMaxIntinFile(intfile));
		
	}
	
	public static int findMaxIntinFile (String file) throws IOException {
		return Files.lines((new File(file)).toPath())
			 	.flatMap( s -> Stream.of(s.split(" ")))
				.map(Integer::valueOf)
				.max(Comparator.naturalOrder())
				.get();
	}
	
	public static int[] randomAr(int lim) {
		return IntStream.generate(() -> ThreadLocalRandom.current().nextInt(-100, 100))
				.limit(lim)
				.peek(n -> System.out.format("%d, ", n))
				.toArray();
	}
	
	public static int findMinAbs(int[] array) {
		return IntStream.of( array ).boxed().min((a,b) -> Math.abs(a)-Math.abs(b)).get();
	}
	

}
