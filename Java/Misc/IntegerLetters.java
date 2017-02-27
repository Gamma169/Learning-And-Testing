public class IntegerLetters{
	

	public static int FindCombos(int[] arr) {

		if (arr[0] == 0)
			return 0;

		for(int i=1; i<arr.length; i++) {
			if (arr[i] == 0 && (arr[i-1] != 1 && arr[i-1] != 2)) {
				System.out.println("test");
				return 0;
			}
		}

		return FindCombosHelper(arr, 0);
	}

	public static int FindCombosHelper(int[] arr, int checkingIndex) {

		if (checkingIndex >= arr.length)
			return 1;

		int ways = 1;
		while(checkingIndex < arr.length - 1) {
			if ((arr[checkingIndex] == 1 && arr[checkingIndex + 1] != 0) || (arr[checkingIndex] == 2 && arr[checkingIndex + 1] != 0 && arr[checkingIndex+1] <= 6)) {
				ways += FindCombosHelper(arr, checkingIndex+2);
			}
			checkingIndex++;
		}
		return ways;
	}




	public static void main(String[] args) {

		int[] a = new int[]{1,1,1,1};
		int[] b = new int[]{1,3,1,1};
		int[] c = new int[]{1,3,3,1};
		int[] d = new int[]{1,1,1,1,1};

		System.out.println(FindCombos(a));
		System.out.println(FindCombos(b));
		System.out.println(FindCombos(c));
		System.out.println(FindCombos(d));

	}

}