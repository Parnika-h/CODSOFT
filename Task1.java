// Number Game
import java.util.*;
public class Task1
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to Number Game:");
		System.out.println("You will be provided with 3 choices only,so choose wisely.");
		System.out.println("All the best!!");
		int round = 1, win = 0 ;
		String ch = "Yes";
		while (ch.equalsIgnoreCase("Yes"))
		{
			System.out.println("Round "+round+" : ");
			int rand_num = (int)(Math.random()*100+1);
			int user_num = 0, count = 1;
			for (count = 1; count <= 3; count++) 
			{
				System.out.print("Enter the number of your choice:");
				user_num = sc.nextInt();
				if (user_num > 0 && user_num <= 100)
				{
					if(user_num == rand_num)
					{
						System.out.println("Good job , You guessed right.");
						win++;
						break;
					}
					else if(user_num > rand_num) 
					{
						System.out.println("Try again , too high!!");
					}
					else if(user_num < rand_num)
					{
						System.out.println("Try again , too low!!");
					}
				}
				else
				{
					System.out.println("Invalid Input.");
				}	
			}
			round++;
			System.out.print("Do you want to continue playing? (Yes/No): ");
			ch=sc.next();
		}
		System.out.println("Number of attempts: " + (round-1));
		System.out.println("Number of rounds won: "+ win);
		System.out.println("Thank you for playing with us!!");
	}

}

