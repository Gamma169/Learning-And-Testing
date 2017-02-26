import java.util.*;

public class ZigZag {
	
	public ArrayList<Chain> chains;


	public ZigZag() {
		chains = new ArrayList<Chain>();
	}


	public int FindLongestChain(int[] arr) {
		if (arr.length == 0)
			return 0;
		else if (arr.length == 1)
			return 1;
		

		CreateChain(arr[0]);

		for(int i=1; i<arr.length; i++) {
			
			
			while(i<arr.length-1 && arr[i] == arr[i-1])
				i++;
			if (i == arr.length-1 && arr[i] == arr[i-1])
				break;
			

			boolean updatedChain = false;
			for(int j=0; j<chains.size() && !updatedChain; j++) {
				if(chains.get(j).zigzag == 0) {
					if (arr[i] > chains.get(j).lastValue) {
						UpdateChain(chains.get(j), arr[i], -1);
						updatedChain = true;
					}
					else if (arr[i] < chains.get(j).lastValue) {
						UpdateChain(chains.get(j), arr[i], 1);
						updatedChain = true;
					}
				}
				else if (chains.get(j).zigzag == 1) {
					if (arr[i] > chains.get(j).lastValue) {
						UpdateChain(chains.get(j), arr[i], -1);
						updatedChain = true;
					}
				}
				else {
					if (arr[i] < chains.get(j).lastValue) {
						UpdateChain(chains.get(j), arr[i], 1);
						updatedChain = true;
					}
				}
			}

			if(!updatedChain) {
				CreateChain(arr[i]);
			}
		

		}


		int longest = 0;
		for(int i=0; i<chains.size(); i++)
			longest = Math.max(longest, chains.get(i).length);
		return longest;
	}

	public void CreateChain(int num) {
		chains.add(new Chain(1, num, 0));
	}

	public void UpdateChain(Chain c, int newVal, int newZig) {
		c.lastValue = newVal;
		c.zigzag = newZig;
		c.length++;
	} 


	public static void main(String[] args) {

		
		int[] array = new int[]{ 1, 7, 4, 9, 2, 5 };

		int[] array2 = new int[]{ 1, 17, 5, 10, 13, 15, 10, 5, 16, 8 };

		int[] array3 = new int[]{ 1, 2, 3, 4, 5, 6, 7, 8, 9 , 8, 7, 6, 10};

		int[] array4 = new int[]{ 70, 55, 13, 2, 99, 2, 80, 80, 80, 80, 100, 19, 7, 5, 5, 5, 1000, 32, 32 };

		int[] array5 = new int[]{ 374, 40, 854, 203, 203, 156, 362, 279, 812, 955, 
									600, 947, 978, 46, 100, 953, 670, 862, 568, 188, 
									67, 669, 810, 704, 52, 861, 49, 640, 370, 908, 
									477, 245, 413, 109, 659, 401, 483, 308, 609, 120, 
									249, 22, 176, 279, 23, 22, 617, 462, 459, 244 };


	ZigZag zig = new ZigZag();

	int longest = zig.FindLongestChain(array5);

	System.out.println("Num Chains: " + zig.chains.size());
	System.out.println("Longest Chain: " + longest);
	}

}





class Chain {
	public int length;
	public int lastValue;
	public int zigzag;


	public Chain(int len, int val, int zz) {
		length = len;
		lastValue = val;
		zigzag = zz;
	}
}