import java.util.Scanner;

class Node
{
	String roll_number;
	double marks;
	String StudentName;
	Node(String s1,String s2,double d)
	{
		this.roll_number=s1;		
		this.StudentName=s2;
		this.marks=d;
	}
		 
}
 class Hash
{
	int k;

	public Hash(int n) {
		this.k=n;
	}

	public int hashfunction(String string) {
		

		int sum=0;
		for(int i = string.length()-1;i>0;i--) 
			
		{
			sum=sum*17+(i+i+1)*string.charAt(i);
		}
		sum=sum%k;
		
		return sum;
	}
	
}
public class Solution {
	public static void main(String args[])
	{
		Scanner sc= new Scanner(System.in);		
		System.out.println("No of Student Data Records");
		int N=sc.nextInt();
		Node Node[]=new Node[N*20];
		Hash h=new Hash(N*20);
		String st=sc.nextLine();
		String string[]=new String[N];
		for(int i = 0;i<N;i++)
		{
			String s1=sc.nextLine();			
			String s2[]=s1.split(",");
			int hc=h.hashfunction(s2[0]);
			string[i]=s2[0];
			Node stud=new Node(s2[1],s2[0],Double.parseDouble(s2[2]));
			Node[hc]=stud;	
		}
		int n2=sc.nextInt();
		String x=sc.next();
		int c=0;
		for(int i = 0;i<n2;i++)
		{
			String s1=sc.nextLine();
			 c=0;
			String s2[]=s1.split(" ");
			for(int j = 0;j<string.length;j++)
			{
				if(s2[1].equals(string[j]))
				{
					c++;
					break;
				}
			}
			if(c==1)
			{
			String s=sc.nextLine();
			String[] k=s.split(" ");
			switch (s2[2])
			{
			case "1":System.out.println(Node[h.hashfunction(s2[1])].StudentName);
				break;
			
			case "2":
				System.out.println(Node[h.hashfunction(s2[1])].marks);break;
			}
		}
			else
			{
				System.out.println("Student doesn't exists...");
			}
		}
		}
	}

