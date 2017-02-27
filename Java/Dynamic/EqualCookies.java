import java.util.*;

public class EqualCookies{
	

	public static int NumCookies(int[] arr) {

		//HashSet<Integer> hs = new HashSet<Integer>();

		int lowest = Integer.MAX_VALUE;
		for (int i=0; i<arr.length; i++) {
			lowest = Math.min(lowest, arr[i]);
		}


		int numCookies = 0;
		for (int i=0; i<arr.length; i++) {
			arr[i] = arr[i] - lowest;
			//if (!hs.contains(arr[i])) {
			numCookies += arr[i];
			//	hs.add(arr[i]);
			//}
		}
		//System.out.println(lowest);
		return numCookies;
	}


	public static void PrintArray(int[] arr) {
		for (int i=0; i<arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.print("\n");
	}

	public static void main(String[] args) {

		int[] array = new int[] {2, 2, 3, 7};

		int[] cookies = new int[] {1, 2, 5};

		int cookieDiff = NumCookies(array);

		//int numSteps = 0;

		int[] stepsToDiff = new int[cookieDiff+1];
		for (int i=1; i<stepsToDiff.length; i++) 
			stepsToDiff[i] = Integer.MAX_VALUE;


		for (int i=0; i<cookies.length; i++) {
			for(int j=1; j<stepsToDiff.length; j++) {
				if (j >= cookies[i] && stepsToDiff[j - cookies[i]] != Integer.MAX_VALUE )
					stepsToDiff[j] = Math.min(stepsToDiff[j], stepsToDiff[j - cookies[i]] + 1);
			}
		}

		//PrintArray(stepsToDiff);

		System.out.println(stepsToDiff[cookieDiff]);
		/*
		while(cookieDiff > 0) {
			if (cookieDiff - 5 >= 0) 
				cookieDiff-=5;
			else if (cookieDiff -2 >= 0)
				cookieDiff-=2;
			else
				cookieDiff--;
			numSteps++;
		}
		*/
		//System.out.println(numSteps);
	}


}