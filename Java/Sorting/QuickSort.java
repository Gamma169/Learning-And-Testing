public class QuickSort {


	public static void Quick(int[] arr) {
		QuickSortHelper(arr, 1, arr.length-2);
	}


	public static void QuickSortHelper(int[] arr, int first, int last) {
		if(first < last) {
			int p = Partition2(arr, first, last);
			QuickSortHelper(arr, first, p);
			QuickSortHelper(arr, p+1, last);
		}
	}

	public static int Partition2(int[] arr, int first, int last) {
		int pivot = arr[first];
		int i = first - 1;
		int j = last + 1;
		while (true) {
			
			while (arr[i] < pivot) 
				i++;	
			while (arr[j] > pivot) 
				j--;

			if (i>=j)
				return j;
			
			int foo = arr[i];
			arr[i] = arr[j];
			arr[j] = foo;
		}


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