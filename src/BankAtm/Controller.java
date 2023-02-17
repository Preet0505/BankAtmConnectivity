package BankAtm;

import java.util.Scanner;

public class Controller {
	
	static ServiceImple service = new ServiceImple();
	
	
	
	public static void main(String[] args) {
		service.createDBConnection();
		//service.adminLogin();
		mainMenu();
			
	}



	private static void mainMenu() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("------------------------------------------------------------");
		System.out.println("Mode: \n 1.Create Account \n 2.Update Account \n 3.Getting All_User \n 4.OneUseraccount  \n 5.Delete Account");
		System.out.println("------------------------------------------------------------");
	
		int Mode = sc.nextInt();
		System.out.println("------------------------------------------------------------");
	
		switch (Mode) {
		case 1:
			service.createDBConnection();
			service.createAccount();
			break;
		case 2:
			service.createDBConnection();
			service.updateAccountDetail();
			break;
		case 3:
			service.createDBConnection();
			service.getallUser();
			break;
		case 4:
			service.createDBConnection();
			service.OneUseraccount();
			break;
		case 5:
			service.createDBConnection();
			service.deleteAccount();
			break;
		default:
			break;
		}
	}


}
