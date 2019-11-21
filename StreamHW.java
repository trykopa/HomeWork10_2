package HomeWork10_3;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class StreamHW {

	public static void main(String[] args) {
		// fill the array with 10 random integers from -100 to 100
		int[] my = randomAr(10);
		
		int result = findMinAbs(my);
		System.out.format("%n%d - is a number from Array with an ABS closest to 0%n%n", result);
		
		String myStr = "The String class represents character strings.";
		int[] array = myStr.chars().toArray();
		System.out.println(Arrays.toString(array));

		
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
