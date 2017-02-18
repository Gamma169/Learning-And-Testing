public class QuickSort {


	public void Quick(int[] arr) {
		QuickSortHelper(arr, 0, arr.length-1);
	}


	public void QuickSortHelper(int[] arr, int first, int last) {


	}



public static void PrintArray(int[] arr) {
		for (int i=0; i<arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.print("\n");
	}


public static void main(String[] args) {

		int[] array = new int[]{4, 3, 8, 1, 87, 34, 0, 0, 12, 53, 7};

		PrintArray(array);
		Quick(array);
		PrintArray(array);
		//System.out.println(numLoops);
	}


}