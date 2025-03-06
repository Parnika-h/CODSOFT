// STUDENT COURSE REGISTRATION SYSTEM
import java.util.*;
import java.sql.*;
public class Task5
{
	public static void main(String[]args) throws ClassNotFoundException, SQLException
	{
		String choice="Yes";
		while (choice.equalsIgnoreCase("Yes"))
		{
			Scanner sc = new Scanner (System.in);
			System.out.println("Welcome to Student Course Regisration System:");
			System.out.println("1.Check Course Details and available slots.\n2.Register for a course.\n3.Drop a course.");
			System.out.println("Enter your choice:");
			int ch = sc.nextInt(),id;
			String code;
			switch(ch)
			{
				case 1: System.out.println("Courses available: ");
						display();
						break;
				case 2: System.out.print("Enter your student ID: ");
						id = sc.nextInt();
						System.out.print("Enter the course code you want to register for: ");
						code = sc.next();
						reg_course(id,code);
						break;
				case 3: System.out.print("Enter your student ID: ");
						id = sc.nextInt();
						System.out.print("Enter the course code you want to drop: ");
						code = sc.next();
						drop_course(id,code) ;
						break;
				default:System.out.println("Invalid choice;");
			}
			System.out.print("Do you want to continue? (yes/no):");
			choice = sc.next();
		}
		System.out.println("Thank you for choosing us!!");
		
        
	}
	public static void display() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentcoursereg","root","carbonara@123"))
		{
			Statement stmt = con.createStatement();
			String query = "SELECT * FROM course WHERE Capacity>0";
			ResultSet rset = stmt.executeQuery(query);
			int i = 1;
			while (rset.next()) 
			{
	            String c_code = rset.getString("Course_Code"); 
	            String Title = rset.getString("Title");
	            String desc = rset.getString("Description");
	            String sd = rset.getString("Schedule");
	            int cap = rset.getInt("Capacity");
	            System.out.println(i+". "+c_code+" : "+ Title+"\nInfo: "+desc+"\nSchedule: "+sd+"\nSlots Available: "+cap);
	            i++;
	         }
		}
		catch(SQLException e) 
		{
			System.out.println("Error encountered while displaying courses!!");
		}
		
	}
	public static void reg_course(int id,String code) throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentcoursereg","root","carbonara@123"))
		{
			con.setAutoCommit(false);
			Statement stmt = con.createStatement();
			String query ="SELECT * FROM course WHERE Course_Code=\""+code+"\" AND Capacity>0";
			ResultSet rset = stmt.executeQuery(query);
			if (rset.next()) 
			{
				String rquery="INSERT INTO reg (ID,Course_Code) VALUES ("+id+",\""+code+"\")";
				stmt.executeUpdate(rquery);
				String uquery="UPDATE course SET Capacity=Capacity-1 WHERE Course_Code=\""+code+"\"";
				stmt.executeUpdate(uquery);
				System.out.println("You have succesfully registered yourself.");
				con.commit();
			}
			else 
			{
				System.out.println("The course is not available.");
			}
		}
		catch (SQLException e) 
		{
            System.out.println("Error encountered during registration.");
            e.printStackTrace();
        }
			
		
	}
	public static void drop_course(int id,String code) throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentcoursereg","root","carbonara@123"))
		{
			Statement stmt = con.createStatement();
			String query = "DELETE FROM reg WHERE ID="+id+" AND Course_Code=\""+code+"\"";
			int rset = stmt.executeUpdate(query);
			if (rset > 0) 
			{
	            System.out.println("Your code " + code + " has been successfully dropped.");
	        } 
			else 
	        {
	            System.out.println("You were not registered for this course.");
	        }
		}
		catch(SQLException e) 
		{
			System.out.println("Error encountered while displaying courses!!");
		}
	}
}
