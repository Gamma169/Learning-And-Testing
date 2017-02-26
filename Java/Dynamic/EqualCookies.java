import java.util.*;

public class EqualCookies{
	

	public static int NumCookies(int[] arr) {

		HashSet<Integer> hs = new HashSet<Integer>();

		int lowest = Integer.MAX_VALUE;
		for (int i=0; i<arr.length; i++) {
			lowest = Math.min(lowest, arr[i]);
		}


		int numCookies = 0;
		for (int i=0; i<arr.length; i++) {
			arr[i] = arr[i] - lowest;
			if (!hs.contains(arr[i])) {
				numCookies += arr[i];
				hs.add(arr[i]);
			}
		}
		System.out.println(lowest);
		return numCookies;
	}



	public static void main(String[] args) {

		int[] array = new int[] {2, 2, 3, 7};

		int[] cookies = new int[] {1, 2, 5};

		int cookieDiff = NumCookies(array);

		int numSteps = 0;

		while(cookieDiff > 0) {
			if (cookieDiff - 5 >= 0) 
				cookieDiff-=5;
			else if (cookieDiff -2 >= 0)
				cookieDiff-=2;
			else
				cookieDiff--;
			numSteps++;
		}
		System.out.println(numSteps);
	}


}