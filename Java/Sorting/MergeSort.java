public class MergeSort {

	public static int[] array2;

	public static void MergeSort(int[] arr) {
		array2 = new int[arr.length];
		//MergeSortHelper2(arr, array2, 0, arr.length-1, false);
		MergeSortHelper(arr);
	}


	public static int[] MergeSortHelper(int[] arr) {
		if (arr.length <= 1)
			return arr;
		else {
			int[] left = new int[arr.length / 2];
			int[] right = new int[arr.length - left.length];
			for (int i = 0, j=0; i< arr.length; i++) {
				if (i < left.length) {
					left[i] = arr[i];
				}
				else {
					right[j] = arr[i];
					j++;
				}
			}
			left = MergeSortHelper(left);
			right = MergeSortHelper(right);

			/*
			int i=0, j=0, place = 0;
			while (i<left.length && j<right.length) {
				if (i < left.length) {
					if (j<right.length) {
						if (left[i] < right[j]) {
							arr[place] = left[i];
							i++;
							place++;
						}
						else {
							arr[place] = right[j];
							j++;
							place++;
						}
					}
					arr[place] = left[i];
					i++;
					place++;
				}
				else {
					arr[place] = right[i];
					j++;
					place++;
				}
			}

			*/
			return arr;
		}
	}

	public static int[] MergeArrays(int[] a, int[] b) {

	}


	public static int[] MergeSortHelper2(int[] arr, int[] arr2, int start, int end, boolean inSecond) {
		return arr;



	}





	public static void PrintArray(int[] arr) {
		for (int i=0; i<arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.print("\n");
	}

	public static void main(String[] args) {

		int[] array = new int[]{4, 3, 8, 1, 87, 34, 0, 0, 12, 53, 7, 305, 2540};

		//PrintArray(array);	
		//MergeSort(array);
		//PrintArray(array);
		


		int[] test1 = new int[]{1, 3, 5};
		int[] test2 = new int[]{2, 4}
		int[] test3 = MergeArrays(test1, test2);


		//int i = 4;
		//System.out.println(  (int)((1234 % Math.pow(10, i+1) / Math.pow(10, i)))  );

		//test = new LinkedList[4];
	}
}