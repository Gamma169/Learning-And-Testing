import java.util.*;
import java.lang.*;
import java.io.*;

public class Radix {
	
	private static ArrayList<LinkedList> bucketsEven;
	private static ArrayList<LinkedList> bucketsOdd;
	//private static LinkedList<Integer>[] buckets;
	
	private static LinkedList[] test;


	public static void RadixLSD(int[] arr) {
		int largest = 0;
		for (int i=0; i<arr.length; i++) 
			largest = largest > arr[i] ? largest : arr[i];
		
		int longestLength = 1;
		while ((float)largest / 10 > 1) {
			largest /= 10;
			longestLength++;
		}

		bucketsEven = new ArrayList<LinkedList>();
		bucketsOdd = new ArrayList<LinkedList>();

		for(int i=0; i<10; i++) {
			bucketsEven.add(i, new LinkedList<Integer>());
			bucketsOdd.add(i, new LinkedList<Integer>());
		}
		
		for (int i = 0; i < longestLength; i++) {
			if (i==0) {
				for(int j = 0; j < arr.length; j++) {		
					int buck = (int)(arr[j] % Math.pow(10, i+1));
					bucketsEven.get(buck).add(arr[j]);
				}
			}
			else {
				int onBuck = 0;
				while(onBuck < 10) {
					if (i % 2 == 0) {
						if (bucketsOdd.get(onBuck).isEmpty())
							onBuck++;
						else {
							int num = ((Integer)bucketsOdd.get(onBuck).remove()).intValue();
							int newBuck = (int)((num % Math.pow(10, i+1) / Math.pow(10, i)));
							bucketsEven.get(newBuck).add(num);
						}
					}
					else {
						if (bucketsEven.get(onBuck).isEmpty())
							onBuck++;
						else {
							int num = ((Integer)bucketsEven.get(onBuck).remove()).intValue();
							int newBuck = (int)((num % Math.pow(10, i+1) / Math.pow(10, i)));
							bucketsOdd.get(newBuck).add(num);
						}
					}
				}
			}
		}

		ArrayList<LinkedList> finalBucks;
		if ((longestLength - 1) % 2 == 0)
			finalBucks = bucketsEven;
		else 
			finalBucks = bucketsOdd;

		int onBuck = 0;
		int index = 0;
		while (onBuck < 10) {
			if (finalBucks.get(onBuck).isEmpty())
				onBuck++;
			else {
				arr[index] = ((Integer)finalBucks.get(onBuck).remove()).intValue();
				index++;
			}
		}

	}



	public static void PrintArray(int[] arr) {
		for (int i=0; i<arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.print("\n");
	}

	public static void main(String[] args) {

		int[] array = new int[]{4, 3, 8, 1, 87, 34, 0, 0, 12, 53, 7, 305, 2540};

		PrintArray(array);
		RadixLSD(array);
		PrintArray(array);
		
		//int i = 4;
		//System.out.println(  (int)((1234 % Math.pow(10, i+1) / Math.pow(10, i)))  );

		//test = new LinkedList[4];
	}
}