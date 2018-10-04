import java.util.Arrays;

public class Pairs {
	int count;
	public void pair()
	{
		
		int[] a = {1,2,3,1,5,6,3,6,4,10};
		Arrays.sort(a);
		System.out.println("sorted order is: ");
		for(int j=0;j<a.length-1;j++)
		{
		
			System.out.print(" "+a[j]);
			if(a[j] == a[j+1])
			{     
				count++;			
			}
			
		}
		System.out.println("\n  no of equal pairs: "+count);
	}
}

