import java.io.*;
import java.util.*;

public class AStar{
	




	public static void PrintArray(int[] arr) {
		for (int i=0; i<arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.print("\n");
	}



	public static void main(String[] args) {


		File test = new File("test.txt");

	try {
		Scanner in = new Scanner(test);

		System.out.println(in.nextLine());

		int n = in.nextInt();
		int[] array = new int[n];

		for (int i=0; i<n; i++)
			array[i] = in.nextInt();

		PrintArray(array);



	}
	catch (FileNotFoundException e) {
		System.out.println("Error: File '" + test + "' not found");
		e.printStackTrace();
	}

	}


}