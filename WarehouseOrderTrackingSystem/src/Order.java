import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

//employee variables- attributes
public class Order {
	private int orderid;
	private String orderdate;
	private int ordertotal;
	private String order_type;
	private String employeename;
	public Database db;
	private int Employee_employeeid;
	private WarehouseOrderTrackingApplication app;
	//ArrayList orders = new ArrayList();
	private String orderstatus;
	
    //create order product instance
  OrderProduct orderproduct;
  
	
	// overloading the constructor
	public Order(WarehouseOrderTrackingApplication app)
	{
		// initialise app
		this.app = app;
		//this.setApp(app);
		db = new Database();
		orderproduct = new OrderProduct();
	}
	
	//class constructor
	public Order(){
		orderid = 0;
		orderdate = null;
		ordertotal = 0;
		order_type = null;
		db = new Database();
		employeename = null;
		orderstatus = null;
		Employee_employeeid = 0;
		
	
	}
	/**
	 * @return the employeename
	 */
	public String getEmployeename() {
		return employeename;
	}

	/**
	 * @param employeename the employeename to set
	 */
	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}

	//get order id method
	public int getOrderid(){
		return orderid;
	}
	
	//get setting method
	public void setOrderid(int orderid){
		this.orderid = orderid;
		return;
	}
	
	//getter for order date
	public String getOrderdate(){
	return orderdate;
	}
	
	//setter for order date
	public void setOrderdate(String orderdate){
		this.orderdate = orderdate;
		return;
	}
	//getter for order total
	public int getOrdertotal() {
		return ordertotal;
	}
	 
	//setter for order total
	public void setOrdertotal(int ordertotal) {
		this.ordertotal = ordertotal;
	}
	//getter for order status
		public String getOrderstatus() {
			return orderstatus;
		}
		 
		//setter for order total
		public void setOrderstatus(String orderstatus) {
			this.orderstatus = orderstatus;
		}
	
	//getter for ordertype
	public String getOrder_type() {
		return order_type;
	}
	
	//setter for order type
	public void setOrder_type(String order_type) {
		this.order_type = order_type;
	}
	
	//getter for whota 
	public WarehouseOrderTrackingApplication getApp() {
		return app;
	}

	//setter for whota
	public void setApp(WarehouseOrderTrackingApplication app) {
		this.app = app;
	}
	
	//method for establishing database connection and retrieving order data
	public void establishOrderDatabase(){
		 try { 
			 	if(db.conn==null){
			 		db.connect();
			 	}
			 	System.out.println("All Orders");
			 	Statement stmt = db.getConn().createStatement();
			 	String sql1 = "SELECT orderid, orderdate, ordertotal, order_type, employeename, orderstatus "
			 			+ "FROM Orders, Employee WHERE Orders.Employee_employeeid = Employee.employeeid";
			 			
			 	ResultSet rs = stmt.executeQuery(sql1);
			 			
			 			while (rs.next()){
					    	int id = rs.getInt("orderid");
					    	String orderdate = rs.getString("orderdate");
					    	int total = rs.getInt("ordertotal");
					    	String order_type = rs.getString("order_type");
					    	String employeename = rs.getString("employeename");
					    	String orderstatus = rs.getString("orderstatus");
					    	System.out.println("\nOrder ID: " + id + "\nOrder Date: " + orderdate + 
					    						"\nTotal Price: " + total +
					    						"\nType of Order: " + order_type +
					    						"\nEmployee: " + employeename + "\nOrder Status: " + orderstatus);
					    } 
			 		
			 			Scanner scan = new Scanner(System.in);
			 			System.out.println("\nWhich order do you want to view?");
			 	
			 	try{
			 			orderproduct.establishorderproduct(scan.nextLine().toString());
			 		} catch (NumberFormatException e){
			 			
			 			System.out.println("Failed to select a correct Order ID.");
	
			 		}
	 		} catch (SQLException ex) {
		 	
	 			// Database error handling
	 			System.out.println("Failed to connect to Database...");
		 	}
		 return ;
		 
	}
	
	//method for establishing database connection and retrieving order data
		public void orderget(){
			 try { 
				 	if(db.conn==null){
				 		db.connect();
				 	}
				 	System.out.println("All Orders");
				 	Statement stmt = db.getConn().createStatement();
				 	String sql1 = "SELECT orderid, orderdate, ordertotal, order_type, employeename, orderstatus "
				 			+ "FROM Orders, Employee WHERE Orders.Employee_employeeid = Employee.employeeid";
				 			
				 	ResultSet rs = stmt.executeQuery(sql1);
				 			
				 			while (rs.next()){
						    	int id = rs.getInt("orderid");
						    	String orderdate = rs.getString("orderdate");
						    	int total = rs.getInt("ordertotal");
						    	String order_type = rs.getString("order_type");
						    	String employeename = rs.getString("employeename");
						    	String orderstatus = rs.getString("orderstatus");
						    	System.out.println("\nOrder ID: " + id + "\nOrder Date: " + orderdate + 
						    						"\nTotal Price: " + total +
						    						"\nType of Order: " + order_type +
						    						"\nEmployee: " + employeename + "\nOrder Status: " + orderstatus);
						    }
			 }
	 catch (SQLException ex) {
			 	
		 			// Database error handling
		 			System.out.println("Failed to connect to Database...");
			 	}
			 return ;
			 
		}
		
	
	//view customer orders
	public void establishOrderCustomer(){
		 try { 
			 	if(db.conn==null){
			 		db.connect();
			 	}
			 	System.out.println("Customer Orders");
			 	Statement stmt = db.getConn().createStatement();
			 	String sql1 = "SELECT orderid, orderdate, ordertotal, employeename, orderstatus "
			 			+ "FROM Orders, Employee Where order_type = 'customer' AND Orders.Employee_employeeid = Employee.employeeid ";
			 			ResultSet rs = stmt.executeQuery(sql1);
			 			
			 			while (rs.next()){
					    	int id = rs.getInt("orderid");
					    	String orderdate = rs.getString("orderdate");
					    	int total = rs.getInt("ordertotal");
					    	String employeename = rs.getString("employeename");
					    	String orderstatus = rs.getString("orderstatus");
					    	System.out.println("\n Order ID: " + id + "\n Order Date: " + orderdate + 
					    						"\n Total Price: " + total + "\n Employee: " + employeename + "\n Order Status: " + orderstatus);
					    } 
			 			Scanner scan = new Scanner(System.in);
			 			System.out.println("\nWhich order do you want to view?");
			 	
			 	try{
			 			orderproduct.establishorderproduct(scan.nextLine().toString());
			 			
			 		} catch (NumberFormatException e){
			 			
			 			System.out.println("Failed to select a correct Order ID.");
	
			 		}

			 			
	 		} catch (SQLException ex) {
		 	
	 			// Database error handling
	 			System.out.println("Failed to connect to Database...");
		 	}
		 
		 return;
	}
	
	
	//stock orders
	public void establishOrderstock(){
		 try { 
			 	if(db.conn==null){
			 		db.connect();
			 	}
			 	System.out.println("Stock Orders");
			 	Statement stmt = db.getConn().createStatement();
			 	String sql1 = "SELECT orderid, orderdate, ordertotal, employeename, orderstatus "
			 			+ "FROM Orders, Employee Where order_type = 'stock' AND Orders.Employee_employeeid = Employee.employeeid";
			 			ResultSet rs = stmt.executeQuery(sql1);
			 			
			 			while (rs.next()){
					    	int id = rs.getInt("orderid");
					    	String orderdate = rs.getString("orderdate");
					    	int total = rs.getInt("ordertotal");
					    	int totalDivBy5 = total / 5; 
					    	String employeename = rs.getString("employeename");
					    	String orderstatus = rs.getString("orderstatus");
					    	System.out.println("\n Order ID: " + id + "\n Order Date: " + orderdate + 
					    						"\n Total Price: " + totalDivBy5 +  "\n Employee: " + employeename + "\n Order Status: " + orderstatus);
					    } 
			 			Scanner scan = new Scanner(System.in);
			 			System.out.println("\nWhich order do you want to view?");

						
			 	try{
			 			orderproduct.establishorderproduct(scan.nextLine().toString());
			 		} catch (NumberFormatException e){
			 			
			 			System.out.println("Failed to select a correct Order ID.");
	
			 		}
			 	//need to add products to the order that is created 
	
	 		} catch (SQLException ex) {
		 	
	 			// Database error handling
	 			System.out.println("Failed to connect to Database...");
		 	}
		 
		 return;
	}

	
//create new order method 
	public void createneworder(){
		 try { 
			 	if(db.conn==null){
			 		db.connect();
			 	}
			 	Scanner scan = new Scanner(System.in);
			 	
			 	System.out.println("\n New Order ID?");
		 		int id = Integer.parseInt(scan.nextLine());
	 
	 			
	 			System.out.println("\n New Order Date?");
	 			String orderdate = scan.nextLine();
	 			
	 			System.out.println("\n New Order Total?");
	 			int ordertotal = Integer.parseInt(scan.nextLine());
	 			
	 			System.out.println("\n New Order Type?");
	 			String order_type = scan.nextLine();
	 			
	 			System.out.println("\n Employee ID?");
	 			int Employee_employeeid = Integer.parseInt(scan.nextLine());
	 			
	 			System.out.println("\n Order Status?");
	 			String orderstatus = scan.nextLine();
	 			
				System.out.println("Inserting records into the table...");
			 	Statement stmt = db.getConn().createStatement();
			 	String sql1 = "INSERT INTO Orders VALUES ('" + id +"','"+ orderdate + "','" + ordertotal + "','" + order_type + "','" + Employee_employeeid + "','" + orderstatus + "')";
			 	stmt.executeUpdate(sql1);
	 			System.out.println("Inserted Values.");
	
				System.out.println("\nOrder ID: " + id + "\nOrder Date: " + orderdate + "\nTotal Price: �" 
									+ ordertotal + "\nType of Order: " + order_type +
					    			"\nEmployee: " + Employee_employeeid + "\nOrder Status: " + orderstatus);
				//need to add products to the order that is created 
			 			orderproduct.createneworderline(id);
		 }catch(NumberFormatException e){
			 System.out.println("enter a valid number");
			 return;
		 } 
		 catch (SQLException ex) {
			 	
	 			// Database error handling
	 			System.out.println("Failed to connect to Database...");
	 			System.out.println(ex);
		 	}
		 
		 return;
	}
	
	
	//create new order method 
	public void changestatus(){
		 try { 
			 	if(db.conn==null){
			 		db.connect();
			 	}
			 	orderget();
			 	Scanner scan = new Scanner(System.in);
			 	
			 	System.out.println("\n Order ID?");
		 		int id = Integer.parseInt(scan.nextLine());
	 
	 			System.out.println("\nNew Order Status?");
	 			String orderstatus = scan.nextLine();
	 			
				System.out.println("Inserting records into the table...");
			 	Statement stmt = db.getConn().createStatement();
			 	String sql1 = "UPDATE Orders SET orderstatus = '" + orderstatus + "' WHERE orderid = " + id;
			 	stmt.executeUpdate(sql1);
	 			System.out.println("Inserted Values.");
	
		 }catch(NumberFormatException e){
			 System.out.println("enter a valid number");
			 return;
		 } 
		 catch (SQLException ex) {
			 	
	 			// Database error handling
	 			System.out.println("Failed to connect to Database...");
	 			System.out.println(ex);
		 	}
		 
		 return;
	}

	/**
	 * @return the employee_employeeid
	 */
	public int getEmployee_employeeid() {
		return Employee_employeeid;
	}

	/**
	 * @param employee_employeeid the employee_employeeid to set
	 */
	public void setEmployee_employeeid(int employee_employeeid) {
		Employee_employeeid = employee_employeeid;
	}


}
