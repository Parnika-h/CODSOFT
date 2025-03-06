// Student Grade Calculator
import java.util.*;
public class Task2 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number of subjects: ");
		int sub = sc.nextInt();
		int sum = 0;
		for (int i = 0 ; i < sub ; i++) {
			System.out.print("Enter your marks out of 100: ");
			int marks = sc.nextInt();
			if (marks >= 0 && marks <= 100) 
			{
				sum += marks;
			}
			else
			{
				System.out.println("Invalid Input.");
			}
				
		}
		System.out.println("Total marks: " + sum);
		double avg = ((double)sum)/sub;
		System.out.println("Average percentage: " + avg);
		switch(((int)avg)/10)
		{
			case 10:System.out.println("O grade");
					break;
			case 9: System.out.println("O grade");
					break;
			case 8: System.out.println("A grade");
					break;
			case 7: System.out.println("B grade");
					break;
			case 6: System.out.println("C grade");
					break;
			case 5: System.out.println("D grade");
					break;
			case 4: System.out.println("E grade");
					break;
			default: System.out.println("Fail");
			
		}
	}

}
