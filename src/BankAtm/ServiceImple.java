package BankAtm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.Scanner;

public class ServiceImple implements Service {

//	static User user;
	static Connection connection;
	static Statement statement;

	public void createDBConnection() {
		try {
			connection = DriverManager.getConnection(
					"jdbc:sqlserver://;localhost=1433;DatabaseName=BankAtm;encrypt=false;trustServiceCertificate=true;",
					"sa", "Preet@123");
			statement = connection.createStatement();

		} catch (SQLException e) {
			System.out.println("Connection not created");
		}

	}

//	public void adminLogin() {
//		// TODO Auto-generated method stub
//		
//	}

	public void createAccount() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter id: ");
		int id = sc.nextInt();
		System.out.println("Enter the First-name: ");
		String Fn = sc.next();
		System.out.println("Enter the Last-name: ");
		String Ln = sc.next();
		System.out.println("Enter the city: ");
		String City = sc.next();
		System.out.println("Mobile no: ");
		String mobile_no = sc.next();
		System.out.println("Account number Generating: ...... ");
//		int accountNumber = sc.nextInt();
		Random random = new Random();
		int[] numbers = new int[10];

		for (int i = 1; i < numbers.length; i++) {
			numbers[i] = random.nextInt(10);
		}
		String number1 = "";

		System.out.print("Account number Generated: ");
		for (int num : numbers) {

			System.out.print(num);
			number1 = number1 + num;
		}
		// PreparedStatement
		// st1=createDBConnection().connection.prepareStatement("INSERT INTO ATM
		// VALUES("+num+") WHERE ");
		System.out.println("\nAccount number Confirm" + number1);
		System.out.println("\nGenerate Password: ");
		String pass = sc.next();
		try {
			statement.executeUpdate("insert into bank values('" + id + "', '" + Fn + "', '" + Ln + "', '" + City
					+ "', '" + mobile_no + "', '" + number1 + "', '" + pass + "')");

			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void updateAccountDetail() {
		// TODO Auto-generated method stub
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter id: ");
			int id = sc.nextInt();
			System.out.println("Enter the Last-name: ");
			String firstNmae = sc.next();
			System.out.println("Enter the Last-name: ");
			String last_name = sc.next();
			System.out.println("Enter the city: ");
			String city = sc.next();
			System.out.println("Mobile no: ");
			String mobile_no = sc.next();

			statement.executeUpdate("UPDATE bank SET first_name='"+firstNmae+"', last_name='" + last_name + "', city='" + city + "', mobile_no='"
					+ mobile_no + "'  WHERE id='"+id+"' ");
			
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
