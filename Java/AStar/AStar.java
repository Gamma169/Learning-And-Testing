import java.io.*;
import java.util.*;

public class AStar{
	
	public static int[][] map;
	public static int numSteps;


	public static int[][] ReadMaze(String s){

		File file = new File(s);
		try {
		Scanner in = new Scanner(file);

		int x = in.nextInt();
		int y = in.nextInt();

		int[][] maze = new int[x][y];

		for (int j=0; j<y; j++){
			for (int i=0; i<x; i++) {
				maze[i][j] = in.nextInt();
			}
		}
		
		in.close();

		return maze;
	}
		catch (FileNotFoundException e) {
			System.out.println("Error: File '" + s + "' not found");
			e.printStackTrace();
			return null;
		}
	}

	public static Coor FindNextPlace(int[][] vals, boolean[][] visited) {
		Coor coor = new Coor(-1,-1);
		int lowestVal = Integer.MAX_VALUE;
		for (int i=0; i<vals.length; i++) {
			for(int j=0; j<vals.[].length; j++) {
				if (map[i][j] != 1 && !visited[i][j] && vals[i][j] < lowestVal){
					lowestVal = vals[i][j];
					coor.x = i;
					coor.y = j;
				}
			}
		}
		return coor;
	}

	public static int CalculateHeuristicToCorner(int x, int y) {
		int distFromOrigin = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
		int distToCorner = Math.sqrt(Math.pow((map.length-1) - x) + Math.pow((map[0].length-1) - y));
		return distFromOrigin + distToCorner;
	}


	public static int ShortestPathCorners(int[][] maze) {

		boolean[][] visited = new boolean[maze.length][maze[0].length];

		int[][] values = new int[maze.length][maze[0].length];

		for (int i=0; i<values.length; i++) {
			for (int j=0; j<values[0].length; j++) 
				values[i][j] = Integer.MAX_VALUE;
		}
		values[0][0] = 0;
		Coor coor = FindNextPlace(values, visited);
		boolean finished = false;
		while(coor.x != -1 && !finished) {
			int xpos = coor.x;
			int ypos = coor.y;

			visited[xpos][ypos] = true;

			if (xpos == maze.length-1 && ypos = maze[0].length-1){
				finished=true;
				break;
			}

			//Check Top Bot Left and Right and set their heuristic

		}

	}



	public static void PrintArray(int[] arr) {
		for (int i=0; i<arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.print("\n");
	}

	public static void PrintArray(int[][] arr) {
		for(int j=0; j<arr[0].length; j++) {
			for (int i = 0; i<arr.length; i++) {
				
				if(arr[i][j] >= 0)
					System.out.print(" ");
				
				System.out.print(arr[i][j]);
				
				if(Math.abs(arr[i][j]) < 10)
					System.out.print("  ");
				else
					System.out.print(" ");
			}
			System.out.print("\n");
		}
	}



	public static void main(String[] args) {



		map = ReadMaze("maze1.txt");
		PrintArray(map);













		/*
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
		*/
	}

}

class Coor{

	int x;
	int y;

	public Coor(int a, int b) {
		x=a;
		y=b;
	}
}