public class Bubble {
	
	public static int numLoops = 0;

	public static void Bubble(int[] arr) {

		for (int i=0; i<arr.length; i++) {
			for (int j=1; j<arr.length; j++) {
				if (arr[j-1] > arr[j])
					Swap(arr, j-1, j);
					//Swap2(j-1, j);
				numLoops++;
			}
		}
	}

	public static void BubbleOp1(int[] arr) {
		boolean swapped = true;
		while(swapped) {
			swapped = false;
			for(int i=1; i<arr.length; i++) {
				if (arr[i-1] > arr[i]) {
					Swap(arr, i-1, i);
					swapped = true;
				}
				numLoops++;
			}
		}
	}

	
	public static void BubbleOp2(int[] arr) {
		boolean swapped = true;
		int sortedElements = 0;
		while (swapped) {
			swapped = false;
			for (int i=1; i< arr.length - sortedElements; i++) {
				if (arr[i-1] > arr[i]) {
					Swap(arr, i-1, i);
					swapped = true;
				}
				numLoops++;
			}
			sortedElements++;
		}
	}

	public static void BubbleOp3(int[] arr) {
		int swaps = 1;
		int upto = arr.length;
		while (swaps !=0) {
			swaps = 0;
			int lastSwap = arr.length;
			for (int i=1; i<upto; i++) {
				if (arr[i-1] > arr[i]) {
					Swap(arr, i-1, i);
					swaps++;
					lastSwap = i;
				}
				numLoops++;
			}
			upto = lastSwap;
		}
	}

	public static void Swap(int[] arr, int i1, int i2) {
		int temp = arr[i1];
		arr[i1] = arr[i2];
		arr[i2] = temp;
	}

	public static void Swap2(int a, int b) {
		int temp = a;
		a = b;
		b = temp; 
	}

	public static void PrintArray(int[] arr) {
		for (int i=0; i<arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.print("\n");
	}

	public static void main(String[] args) {

		int[] array = new int[]{4, 3, 8, 1, 87, 34, 0, 0, 12, 53, 7};

		PrintArray(array);
		//Bubble(array);
		//BubbleOp1(array);
		//BubbleOp2(array);
		BubbleOp3(array);
		PrintArray(array);
		System.out.println(numLoops);
	}


}