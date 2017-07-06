import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static int[] Left(int[] arr) {
        int[] left = new int[arr.length];    
        
        Stack<int[]> stack = new Stack<int[]>();
        int[] pusher = new int[] {arr[0], 1};
        stack.push(pusher);
        
        for (int i=1; i<arr.length; i++) {
            //System.out.print((i+1) + ": ");
            if (arr[i] < arr[i-1]) {
                left[i] = i;
                //pusher[0] = arr[i];
                //pusher[1] = i+1;
                stack.push(new int[] {arr[i], i+1});
            }
            else if (arr[i] == arr[i-1]) {
                left[i] = left[i-1];
                stack.peek()[1] = i+1;
            }
            else {
                if (!stack.isEmpty()) {
                    while(!stack.isEmpty() && stack.peek()[0] <= arr[i]){
                        //System.out.print(stack.peek()[0]);
                        stack.pop();
                    }
                    if (!stack.isEmpty()) {
                        left[i] = stack.peek()[1];
                        
                    }
                    stack.push(new int[] {arr[i], i+1});
                }
                else {
                    stack.push(new int[] {arr[i], i+1});
                }                
            }
            //System.out.println();
        }
        
        return left;
    }
    
    public static int[] Right(int[] arr) {
        int[] right = new int[arr.length];
        
        Stack<int[]> stack = new Stack<int[]>();
        int[] pusher = new int[] {arr[arr.length - 1], arr.length};
        stack.push(pusher);
        
        for (int i=arr.length-2; i >=0; i--) {
            if (arr[i] < arr[i+1]) {
                right[i] = i+2;
                stack.push(new int[] {arr[i], i+1});
            }
            else if (arr[i] == arr[i+1]) {
                right[i] = right[i+1];
                stack.peek()[1] = i+1;
            }
            else {
                if (!stack.isEmpty()) {
                    while(!stack.isEmpty() && stack.peek()[0] <= arr[i])
                        stack.pop();
                    if (!stack.isEmpty())
                        right[i] = stack.peek()[1];
                    
                    stack.push(new int[] {arr[i], i+1});
                }
                else {
                    stack.push(new int[] {arr[i], i+1});
                }
                
            }
                
        }
        
        return right;
    }
    
    public static void PrintArr(int[] arr) {
        //System.out.println();
        for (int i=0; i<arr.length; i++) {
            System.out.print(arr[i]);
            System.out.print(" ");
        }
        System.out.println();
        
    }
    public static void PrintArr(int[] arr, int start, int end) {
        for (int i=start; i<end; i++) {
            System.out.print(arr[i]);
            System.out.print(" ");
        }
        System.out.println();
    }
    
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        File f = new File("input00.txt");
        try {
            Scanner in = new Scanner(f);
            
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int i=0; i < n; i++)
                arr[i] = in.nextInt();
                
            int[] left = Left(arr);
            int[] right = Right(arr);
            
            //PrintArr(arr, 49999, 50002);
            //PrintArr(left, 49999, 50002);
            //PrintArr(right, 49999, 50002);
            
            //System.out.println()


            double maxProduct = 0;
            for (int i=0; i<n; i++) {
                maxProduct = Math.max(maxProduct, (double)left[i] * (double)right[i]);
            }
            
            //double num = (float)50000 * (float)50002;

            //System.out.println(num);

            System.out.println((long)maxProduct);
        }
        catch (FileNotFoundException e) {
            System.out.println("Error: File not found");
            e.printStackTrace();
        }

    }
}