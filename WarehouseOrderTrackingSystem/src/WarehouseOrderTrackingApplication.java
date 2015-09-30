import java.util.Scanner;

public class WarehouseOrderTrackingApplication {

	 static Scanner scan = new Scanner(System.in);
	
	// attributes and instances
	public static String username = null;
    public static String password = null;
    
    // Create instance of employee
    Employee emp;
    //create initialised instance of product
    Product product = new Product(this);
    // create instance of Orders
    Order order = new Order(this);
    // create instance of Orders
    Inventory inventory = new Inventory(this);
    //create order product instance
    OrderProduct orderproduct = new OrderProduct(this);
    
    // class constructor
    public WarehouseOrderTrackingApplication(){
    	
    	askLoginDetails();
    	askOptions();
    	
    }
    
    public static void main(String[]args) 
    {
    	new WarehouseOrderTrackingApplication();
	}
    
    public void askLoginDetails()
    {	
		System.out.println("-------------------------------");
		System.out.println("Warhouse Order Tracking System:");
		System.out.println("-------------------------------");

		
		System.out.println("-------------------------------");
		System.out.println("Please Enter username:");
		username = scan.nextLine();
		System.out.println("Please Enter Password:");
		password = scan.nextLine();
		
		// create instance of employee
		emp = new Employee(this);
		emp.setUsername(username);
		emp.setPassword(password);
		emp.establishEmployeeDatabase();

    }
    
    
    public void askOptions()
    {
    	while(true){
    	String optionLog = null;
    	System.out.println("-------------------------------");
		System.out.println("--------Choose Options---------");
    	System.out.println("#1 to go to Products");	
    	System.out.println("#2 to go to All Orders");
    	System.out.println("#3 to go to Customer Orders");
    	System.out.println("#4 to go to Stock Orders");
    	System.out.println("#5 to go to Inventory");
    	System.out.println("#6 to go to Inventory with name");
    	System.out.println("#7 Create New Order");
    	System.out.println("#8 Log Out");
    	System.out.println("-------------------------------");
    	optionLog = scan.nextLine();
    	
    	switch (optionLog){
    	
    	case "1":product.establishProductDatabase();
    	break;
    	case "2":order.establishOrderDatabase();
    	break;
    	case "3":order.establishOrderCustomer();
    	break;
    	case "4":order.establishOrderstock();
    	break;
    	case "5":inventory.establishInventory();
    	break;
    	case "6":inventory.establishInventory1();
    	break;
    	case "7": order.createneworder();
    	break;
    	case "8": askLoginDetails();
    	break;
    	default: System.out.println("No option chose.");
    		break;
    	}
    }
    }
    
    
  }