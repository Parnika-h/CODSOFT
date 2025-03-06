import java.util.*;
//ATM machine
class ATM 
{
	public static double withdraw(double amount,double accbal) 
	{
		 if (amount <= accbal && amount >= 0)
		 {
			 accbal -= amount;
			 System.out.println("Transaction was successfull");
		 }
		 else 
		 {
			 System.out.println("Not enough amount in bank account.Check balance and try again.");
		 }
		 return accbal;
	}
	public static double deposit(double amount,double accbal)
	{
		if (amount >= 0)
		{
			accbal += amount;
			System.out.println("Transaction was successfull");
		}
		return accbal;
	}
	public static void checkBalance(double accbal) 
	{
		if (accbal > 0)
		{
			System.out.println("Amount in your bank account: " + accbal);
		}
		else 
		{
			System.out.println("No amount in bank account.");
		}
	}
}
//User's Bank Account
public class BankAcc 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		String choice = "Yes";
		double accbal = 0.0;
		while (choice.equalsIgnoreCase("Yes"))
		{
			System.out.println("Welcome to ATM Machine: ");
			System.out.println("1. Withdraw Money.\n2. Deposit Money.\n3. Check Bank Balance.");
			System.out.print("Enter your choice: ");
			int ch = sc.nextInt();
			double amount = 0.0;
			ATM atm = new ATM();
			switch(ch) 
			{
				case 1: System.out.print("Enter the amount you want to withdraw: ");
						amount = sc.nextDouble();
						accbal = atm.withdraw(amount,accbal);
						break;
				case 2: System.out.print("Enter the amount you want to deposit:");
						amount = sc.nextDouble();
						accbal = atm.deposit(amount,accbal);
						break;
				case 3: atm.checkBalance(accbal);
						break;
				default: System.out.println("Invalid choice");
			}
			System.out.print("Do you want to continue?(Yes/No): ");
			choice = sc.next();
		}
		System.out.println("Thank You!!");
		
	}

}
