import java.util.*;

public class DynamicCoins{
	

	public int[] coinValues;
	public int toValue;
	public int[] numCoinsToValue;


	public DynamicCoins(int[] coins, int toVal) {
		coinValues = coins;
		toValue = toVal;
		numCoinsToValue = new int[toVal+1];

		for (int i=1; i<numCoinsToValue.length; i++) {
			numCoinsToValue[i] = Integer.MAX_VALUE;
		}

		FindNumCoins2();

	}


	public void FindNumCoins1() {
		int checkingValue = 1;

		while(checkingValue <= toValue) {

			for (int i=coinValues.length -1; i>=0; i--) {
				if (checkingValue - coinValues[i] < 0) {
					if (i == 0)
						numCoinsToValue[checkingValue] = Integer.MAX_VALUE;
				}
				else if (checkingValue - coinValues[i] == 0)
					numCoinsToValue[checkingValue] = 1;
				else {
					if(numCoinsToValue[checkingValue - coinValues[i]] != Integer.MAX_VALUE) {
						numCoinsToValue[checkingValue] = Math.min(numCoinsToValue[checkingValue], numCoinsToValue[checkingValue - coinValues[i]] + 1);
					}
					//else if (i==0)
					//	numCoinsToValue[checkingValue] = -1;
				}
			}
			checkingValue++;
		}
	}

	public void FindNumCoins2() {
		for(int i=0; i<coinValues.length; i++) {
			for(int checkingVal=0; checkingVal<numCoinsToValue.length; checkingVal++) {
				if (checkingVal >= coinValues[i] && numCoinsToValue[checkingVal - coinValues[i]] != Integer.MAX_VALUE) {
					numCoinsToValue[checkingVal] = Math.min(numCoinsToValue[checkingVal], numCoinsToValue[checkingVal - coinValues[i]] + 1);
				}
			}
		}
	}

	public int MinCoinsToValue(int val) {
		if (val > toValue || val < 0)
			return -1;
		else 
			return numCoinsToValue[val];
	}


	public static void PrintArray(int[] arr) {
		for (int i=0; i<arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.print("\n");
	}


	public static void main(String[] args) {

		int[] coinVals = new int[]{3, 5, 7};

		int to = 11;

		DynamicCoins dc = new DynamicCoins(coinVals, to);
		System.out.println(dc.MinCoinsToValue(11));
		PrintArray(dc.numCoinsToValue);
		//PrintArray(numCoinsToValue);
		//PrintArray(coinValues);


	}


}