public class InsertionSort {
	
	/*
	public static void Insert(int[] arr, int a, int inPlace) {
		for (int i=arr.length-1; i>inPlace; i--)
			arr[i] = arr[i-1];
		arr[inPlace] = a;
	}

	public static void InsertInPosition(int[] arr, int a) {
		int inPlace = arr.length-1;
		while(a<arr[inPlace] && inPlace>0) {
			arr[inPlace] = arr[inPlace - 1]
			inPlace--;
		}
		arr[inPlace] = a;
	}
	*/

	public static void InsertionSortArray(int[] arr) {
		for(int i=1; i<arr.length; i++) {
			int j = i;
			while(j > 0 && arr[j-1] > arr[j]){
				Swap(arr, j-1, j);
				j--;
			}
		}
	}

	public static void InsertionSortArray2(int[] arr) {
		for (int i=1; i<arr.length; i++) {
			for (int j  = i-1, num = arr[i]; j>=0 && num < arr[j]; arr[j] = num, j--)
				arr[j+1] = arr[j];
		}
	}

	public static void Swap(int[] arr, int i1, int i2) {
		int temp = arr[i1];
		arr[i1] = arr[i2];
		arr[i2] = temp;
	}

	public static void PrintArray(int[] arr) {
		for (int i=0; i<arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.print("\n");
	}


public static void main(String[] args) {

		int[] array = new int[]{4, 3, 8, 1, 87, 34, 0, 0, 12, 53, 7};

		PrintArray(array);
		//InsertionSortArray(array);
		InsertionSortArray2(array);
		PrintArray(array);
		//System.out.println(numLoops);
	}


}

