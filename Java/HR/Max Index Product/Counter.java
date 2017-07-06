import java.io.*;
import java.util.*;

public class Counter {
	


	public static void main(String[] args) {

		int num = 0;
		File f = new File("input00.txt");
		try {
			Scanner in = new Scanner(new File("input00.txt"));

			while (in.nextInt() != 0)
				num++;

			System.out.println(num);

		}
		catch (FileNotFoundException e) {
			System.out.println("Error: File not found");
			e.printStackTrace();
		}
	}


}