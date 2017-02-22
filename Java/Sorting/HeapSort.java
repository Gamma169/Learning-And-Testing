public class HeapSort{
	
	public static int countSwaps;
	public static int countChecks;

	// Parent of index: floor((i-1)/2)
	// Child 1: 2i + 1
	// Child 2: 2i + 2
	public static void HeapifyDown(int[] arr) {
		countSwaps= 0;
		countChecks = 0;
		boolean swapped = true;
		while(swapped){
			swapped = false;
			for(int i=arr.length-1; i>0; i--) {
				
				/*
				int parent = (i-1)/2;
				int swap = parent;
				if (arr[parent] < arr[(2* parent) + 1])
					swap = (2*parent) + 1;
				if (arr[swap] < arr[2*parent] + 2)
					swap = (2*parent )+ 2;
				if (swap != parent) {
					Swap(arr, swap, parent);
					swapped = true;
				}
				*/
				
				if (arr[i] > arr[(i-1)/2]) {
					Swap(arr, i, (i-1)/2);
					swapped = true;
					countSwaps++;
				}
				
				//countChecks++;
			}
		}
	}

	public static void HeapifyPlace(int[] arr, int count) {

		int start = (count - 1) / 2;
		//int start = count - 1;
		countSwaps = 0;
		while (start >= 0) {
			SiftDown(arr, start, count);
			start--;
		}
	}

	public static void SiftDown(int[] arr, int start, int end) {
		int root = start;
		while((2 * root )+ 1 <= end) {
			int child = 2 * root + 1;
			int swap = root;
			if (arr[swap] < arr[child])
				swap = child;
			if (child + 1 <= end && arr[swap] < arr[child+1])
				swap = child+1;
			if (swap == root)
				return;
			else {
				Swap(arr, root, swap);
				root = swap;
				countSwaps++;
				//PrintArray(arr);
			}


		}
	}


	public static void HeapSortNow(int[] arr) {

		HeapifyPlace(arr, arr.length-1);

		int end = arr.length-1;
		while(end > 0) {
			Swap(arr, 0, end);
			end--;
			SiftDown(arr, 0, end);

		}
	}




	public static void Swap(int[] arr, int a, int b){
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

	public static void PrintArray(int[] arr) {
		for (int i=0; i<arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.print("\n");
	}

	public static void main(String[] args) {

		int[] array = new int[]{4, 3, 8, 1, 87, 34, 0, 2540, 0, 12, 53, 7, 305};
		int[] array2 = new int[]{4, 3, 8, 1, 87, 34, 0, 2540, 0, 12, 53, 7, 305};
		
		//int l = 0;
		//System.out.println((l-1)/2);


		PrintArray(array);	
		//HeapifyDown(array);
		//PrintArray(array);
		//System.out.println(countSwaps);
		//System.out.println();
		
		//HeapifyPlace(array2, array2.length-1);
		HeapSortNow(array2);
		PrintArray(array2);
		//System.out.println(countSwaps);

		

		/*
		int[] test1 = new int[]{1, 3, 5};
		int[] test2 = new int[]{2, 4, 6, 8};
		int[] test3 = MergeArrays(test1, test2);
		PrintArray(test3);
		*/

		//int i = 4;
		//System.out.println(  (int)((1234 % Math.pow(10, i+1) / Math.pow(10, i)))  );

		//test = new LinkedList[4];
	}


}