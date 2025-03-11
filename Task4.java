// QUIZ APPLICATION WITH TIMER
import java.util.*;
public class Task4 
{
	private static boolean timeup = false;
	private static int score = 0;
	public static int quizquestions(String question,int ans,String[] mcq) 
	{
		timeup=false;
		Scanner sc = new Scanner(System.in);
		System.out.println(question);
		for (int i = 0 ; i <= 3 ; i++) 
		{
			System.out.println(( i + 1 ) + ". " + mcq[i]);
		}
		System.out.println("Enter your answer:");
		Thread inputThread = new Thread(() -> 
		{
            try 
            {
                int userans = sc.nextInt();
                if (userans >= 1 && userans <= 4)
                {
                    if (userans == ans) 
                    {
                        System.out.println("Good job, correct answer!!");
                        score++;
                    } 
                    else 
                    {
                        System.out.println("Incorrect answer.");
                    }
                } 
                else 
                {
                    System.out.println("Invalid choice. Please select a valid option (1-4).");
                }
                 
            } 
            catch (Exception e) 
            {
                System.out.println("Invalid input. Please enter an integer (1-4).");
                
            }
        });
		inputThread.start();

        try 
        {
            inputThread.join(10000); 

            if (inputThread.isAlive()) 
            {
                timeup = true;
                System.out.println("Time's up!!");
                inputThread.interrupt();
            }
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        return timeup ? 0 : 1; 
    }

	public static void main(String[] args)
	{
		System.out.println("Welcome to the quiz application with timer.\nYou will have 10 seconds to answer each questions.\nGood luck mate!!");
		String []arr1 = {"Bill Gates","James Gosling","Steve Jobs","Mark Zuckerberg"};
		String []arr2 = {"Spaghetti","Fusilli","Penne","Fettuccine"};
		String []arr3 = {"31","30","28","29"};
		quizquestions("Who is the \"father of java\"?",2,arr1);
		quizquestions("Which pasta, shaped like small tubes, is perfect for holding thick sauces?",3,arr2);
		quizquestions("What are the number of days in January?",1,arr3);
		System.out.println("Final Score:" + score + " out of 3.");
	}
	

}
