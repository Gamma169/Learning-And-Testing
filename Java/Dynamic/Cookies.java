import java.util.*;

public class Cookies{
	

 public static int MinCookies(int[] arr) {
        if (arr.length == 1)
            return 1;
        
        int n = arr.length;
        int[] cookies = new int[n];
        
        int numLocalMins = 0;
        HashSet<Integer> maxes = new HashSet<Integer>();
        
        if (arr[0] <= arr[1]) {
            cookies[0] = 1;
            numLocalMins++;
        }
        else
            maxes.add(0);
        
        for(int i=1; i<arr.length-1; i++) {
            if (arr[i] <= arr[i+1] && arr[i] <= arr[i-1]) {
                cookies[i] = 1;
                numLocalMins++;
            }
            else if (arr[i] > arr[i+1] && arr[i] > arr[i-1])
                maxes.add(i);
        }
        if (arr[n-1] <= arr[n-2]) {
            cookies[n-1] = 1;
            numLocalMins++;
        }
        else 
            maxes.add(n-1);
        
        int[] localMins = new int[numLocalMins];
        
        for (int i=0, ci=0; i<n; i++) {
            if (cookies[i] == 1) {
                localMins[ci] = i;
                ci++;
            }
        }
            
        for(int i=0; i<localMins.length; i++) {
            if (localMins[i] != 0) {
                int minPlace = localMins[i]-1;
                int cookieChain = 2;
                while(cookies[minPlace] != 1) {
                    if (!maxes.contains(minPlace)) {
                        cookies[minPlace] = cookieChain;
                        cookieChain++;
                        minPlace--;
                    }
                    else {
                        cookies[minPlace] = Math.max(cookies[minPlace], cookieChain);
                        break;
                    }   
                }
            }
            if (localMins[i] != arr.length-1) {
                int minPlace = localMins[i]+1;
                int cookieChain = 2;
                while(cookies[minPlace] != 1) {
                    if (!maxes.contains(minPlace)) {
                        cookies[minPlace] = cookieChain;
                        cookieChain++;
                        minPlace++;
                    }
                    else {
                        cookies[minPlace] = Math.max(cookies[minPlace], cookieChain);
                        break;
                    }
                }
            }
        }
        
        int numCookies = 0;
        for (int i=0; i<cookies.length; i++)
            numCookies += cookies[i];
        return numCookies;
    }
    
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        int min = Integer.MAX_VALUE;
        for(int i=0; i<n; i++) {
            arr[i] = in.nextInt();
            if (arr[i] < min)
                min = arr[i];
        }
        
        System.out.println(MinCookies(arr));
    }





}