import java.util.Scanner;

public class WarehouseOrderTrackingApplication {

	public static   String username = null;
    public static   String password = null;
	public static void main(String[]args) {
		
		System.out.println("-------------------------------");
		System.out.println("Warhouse Order Tracking System:");
		System.out.println("-------------------------------");
		System.out.println("Please Enter username to Start:");
		
		Database database = new Database();
		database.accessBD();
		
		//Scanner scan = new Scanner(System.in);

//		System.out.println(scan.nextLine());
		
		

		
		}
}
