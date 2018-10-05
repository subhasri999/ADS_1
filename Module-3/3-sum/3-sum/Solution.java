

import java.util.Scanner;

public class Solution {


	
	public static void main(String[] args) {
		int count=0;
		Scanner sc = new Scanner(System.in);
		int n =sc.nextInt();
		int [] array = new int[n];
		
		for(int i=0;i<array.length;i++) {
			array[i]=sc.nextInt();
			
		}
		
		for(int i=0;i<array.length-2;i++) {
			for(int j=i+1;j<array.length-1;j++) {
				for(int k=j+1;k<array.length;k++) {
					int a =array[i];
					int b=array[j];
					int c =array[k];
					if(a+b+c==0) {
						count++;
					}
				}
			}
		}
		System.out.println(count);
		
	}
}
