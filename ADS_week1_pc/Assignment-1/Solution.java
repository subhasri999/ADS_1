import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
class AddLargeNumbers
{
	public static LinkedList numberToDigits(String number)
	{	
		String x=number;		
		int result=Integer.parseInt(x);
		LinkedList<Integer> k = new LinkedList<Integer>();
		while(result>0)
		{
			 k.add(result%10);
			result=result/10;			
		}
		Iterator<Integer> itr=k.iterator();
		while(itr.hasNext())
		{
			System.out.println(itr.next());
		}
		return k;		
	}
	public static String digitsToNumber(LinkedList list)
	{
		String numbers ="";
		Iterator<Integer> itr1 = list.iterator();
		while(itr1.hasNext()) {
			numbers+=itr1.next();
		}
		return numbers;

    }

	public static LinkedList addLargeNumbers(LinkedList list1, LinkedList list2)
	{
		return list2;

    }
}
	

public class Solution {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //AddLargeNumbers AddLargeNumbers=new AddLargeNumbers();
       // System.out.println("Enter your choice-1.numberToDigits,2.addLargeNumbers");
        String input = sc.nextLine();
       // System.out.println("Enter p");
        String p = sc.nextLine();
      //  System.out.println("Enter q");
        String q = sc.nextLine();
        switch(input){
            case "numberToDigits":
                LinkedList pDigits = AddLargeNumbers.numberToDigits(p);
                LinkedList qDigits = AddLargeNumbers.numberToDigits(q);
                System.out.println(AddLargeNumbers.digitsToNumber(pDigits));
                System.out.println(AddLargeNumbers.digitsToNumber(qDigits));
                break;

            case "addLargeNumbers":
                LinkedList pDigits1 = AddLargeNumbers.numberToDigits(p);
                LinkedList qDigits1 = AddLargeNumbers.numberToDigits(q);
                LinkedList result = AddLargeNumbers.addLargeNumbers(pDigits1, qDigits1);
              //  System.out.println(AddLargeNumbers.digitsToNumber(result));
                break;
        }
    }
    
}
