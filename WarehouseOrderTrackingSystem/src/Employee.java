import java.sql.*;

public class Employee {

	//employee variables- attributes
	private String username;
	private String password;
	private String name;
	private String jobtitle;
	private int phonenumber;
	private String address;
	public Database db;
	public boolean loggedIn;
	private WarehouseOrderTrackingApplication app;
	
	// overloading the constructor
	public Employee(WarehouseOrderTrackingApplication app)
	{
		// initialise app
		this.app = app;
		db = new Database();
	}
	
	// class constuctor 
	public Employee(){
		username = null;
		password = null;
		name = null;
		jobtitle = null;
		phonenumber = 0;
		address = null;
		loggedIn = false;
		db = new Database();
		
	}
	
	//method for getting username
	public String getUsername(){
		return username;
	}
	
	//method for setting username
	public void setUsername(String username){
		this.username = username;
		return;
	}
	
	//method for getting password
	public String getPassword(){
		return password;
	}
	
	//method for setting password
	public void setPassword(String password){
		this.password = password;
		return;
	}
	
//method for getting employeename
	public String getName(){
		return name;
	}
	
	//method for setting name
	public void setName(String name){
		this.name = name;
		return;
	}
	
	//method for  getting job
	public String getJobtitle(){
		return jobtitle;
	}
	
	//method for  setting job
	public void setJobtitle(String jobtitle){
		this.jobtitle = jobtitle;
		return;
	}
	
	//method for  getting phonenumber
	public int getPhonenumber(){
		return phonenumber;
	}
	
	//method for  setting phonenumber
	public void setPhonenumber(int phonenumber){
		this.phonenumber = phonenumber;
		return;
	}
	//method for  getting address
	public String getAddress(){
		return address;
	}
	
	//method for  setting address
	public void setAddress(String address){
		this.address = address;
		return;
	}
	
	public void establishEmployeeDatabase(){
		
		 try { 
			 	Statement stmt = db.getConn().createStatement();
			 	String sql1 = "SELECT employeeid, employeename, job, employeephone, employeeaddress, employeeusername, employeepassword FROM Employee";
			 			ResultSet rs = stmt.executeQuery(sql1);
			 			
			 			while(rs.next()) {
			 				
			 			if(login(getUsername(), getPassword(), rs.getString(6), rs.getString(7)))
			 			{
			 				// set logged in flag to true
			 				loggedIn = true;
			 				System.out.println("Welcome to NBgardens :"+ username);
			 			} 
			 			else if (!login(getUsername(), getPassword(), rs.getString(6), rs.getString(7)) 
			 					&& !loggedIn)
			 			{
			 				// set logged flag to false
			 				loggedIn = false;
			 				continue;
			 			}
			 		}
			 			
			 			// If login fails
			 			if (!loggedIn) {
			 				// print error message
			 				System.out.println("Login failed");
			 				
			 				// prompt user for details
			 				
			 				app.askLoginDetails();		
			 			}
	 		} catch (SQLException ex) {
		 	
	 			// Database error handling
	 			System.out.println("Failed to connect to Database...");
		 	}
		 
		 return;
	}
	
	public boolean login(String username, String password, String dbuser, String dbpassword){
		if(username.equalsIgnoreCase(dbuser) && password.equalsIgnoreCase(dbpassword)) {
			return true;
		} else
		{
			return false;
		}
	}
	
}
