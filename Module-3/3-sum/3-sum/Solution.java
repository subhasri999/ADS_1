import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	 public static int count(int[] arr) {
	        int n = arr.length;
	        Arrays.sort(arr);
	        int count = 0;
	        for (int i = 0; i < n; i++) {
	            for (int j = i+1; j < n; j++) {
	                int x = Arrays.binarySearch(arr, -(arr[i] + arr[j]));
	                if (x > j) 
	                {
	                	count=count+1;
	                }
	                	
	            }
	        }
	        return count;
	    } 
	 public static void main(String[] args)  
	 { 
		int n;
	     Scanner scan = new Scanner (System.in);
		n=scan.nextInt();
	        int[] a = new int[n];
	        for(int i=0;i<n;i++)
	        {
			a[i]=scan.nextInt();
	        }
	        int count = count(a);
			//System.out.print("Number of Three sum number sets are:");
	        System.out.println(count);
	    } 
}



