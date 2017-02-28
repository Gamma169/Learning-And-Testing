public class BestPathCorners {
	

	public static int bestAddition;


	// Doesn't work
	public static int BruteForce(int[][] arr, int x, int y, int currentSum) {

		if (x==arr.length-1 && y==arr[0].length-1)
			return currentSum + arr[x][y];

		int sumRight = currentSum+=arr[x][y];
		int sumDown = currentSum+=arr[x][y];

		//if (x<arr.length)
		//	sumRight+= BruteForce(arr, x+1, y, sumRight);



		return 0;
	}



	public static int Dynamic(int[][] arr) {
		int arrX=arr.length;
		int arrY=arr[0].length;

		int[][] list = new int[arrX][arrY];

		list[arrX-1][arrY-1] = arr[arrX-1][arrY-1];

		for(int j=arrY-1; j>=0; j--) {
			for(int i=arrX-1; i>=0; i--){
				int valRight=0;
				int valDown=0;
				if(i<arrX-1) 
					valRight = list[i+1][j];
				else 
					valRight = -Integer.MAX_VALUE;

				if(j<arrY-1) 
					valDown = list[i][j+1];
				else
					valDown = -Integer.MAX_VALUE;

				if (i != arrX-1 || j != arrY-1) {
					int biggerVal = Math.max(valRight, valDown);
					list[i][j] = arr[i][j] + biggerVal;
				}

			}
			//Print2DArray(list);
			//System.out.println();

			//return 0;
		}
		Print2DArray(list);
		return list[0][0];

	}


	public static Coor FindNextElement(int[][] currentList) {
		int xCor = currentList.length-1;
		int yCor = currentList[0].length -1;
		int maxVal = currentList[xCor][yCor];
		for(int i=xCor; i>=0; i--) {
			for (int j=yCor; j>=0; j--) {
				if (currentList[i][j] > maxVal) {
					maxVal = currentList[i][j];
					xCor = i;
					yCor = j;
				}
			}
		}
		return new Coor(xCor, yCor);
	}

	public static void Print2DArray(int[][] arr) {

		for(int j=0; j<arr[0].length; j++) {
			for (int i = 0; i<arr.length; i++) {
				
				if(arr[i][j] >= 0)
					System.out.print(" ");
				
				System.out.print(arr[i][j]);
				
				if(Math.abs(arr[i][j]) < 10)
					System.out.print("  ");
				else
					System.out.print(" ");
				/*
				if (arr[i][j] < 10 && arr[i][j] > -1)
					System.out.print(arr[i][j] + "  ");
				else if(arr[i][j] < -9)
					System.out.print(arr[i][j]);
				else
					System.out.print(arr[i][j] + " ");
				*/
			}
			System.out.print("\n");
		}


	}

	public static void main(String[] args) {

		int[][] array1 = new int[][]{ {1, 2}, {-1 , 1}};
		int[][] array2 = new int[][]{ {3, 3, 3}, {0 , 0, 3}, {0, 0, 3}};

		int[][] array5 = new int[][]{  {1, -6, 5, 1, -3}, {4, 5, -7, -2, -1}, {1, 7, -3, 0, 1}, {3, -3, 0, 0, 5}, {2, 3, 7, -6, 2} };

		int[][] array6 = new int[6][6];
		for (int i =0; i<6; i++) {
			for(int j=0; j<6; j++)
				array6[i][j] = (int)(Math.random() * 41) - 20;
		}

		Print2DArray(array5);
		System.out.println();
		System.out.println(Dynamic(array5));

	}


}

class Coor{
	int x;
	int y;

	public Coor(int a, int b) {
		x=a;
		b=y;
	}
}