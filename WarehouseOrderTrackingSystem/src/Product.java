import java.sql.*;

public class Product {
	
	//variables
	private int productid;
	private String productname;
	private int price; 
	public Database db;
	private WarehouseOrderTrackingApplication app;


	// overloading the constructor
			public Product(WarehouseOrderTrackingApplication app)
			{
				// initialise app
				this.app = app;
				db = new Database();
			}
			
	//class constructor
	public Product(){
		productid = 0;
		productname = null;
		price = 0;
	}
	
	//method for getting product id
	public int getProductid(){
		return productid;
	}
	
	//method for setting product id
	public void setProductid(int productid){
		this.productid = productid;
		return;
	}
	
	//method for getting productname 
	public String getProductname(){
		return productname;
	}

	//method for setting productname
	public void setProductname(String productname){
		this.productname = productname;
		return;
	}
	
	//method for setting price
	public int setPrice(){
		return price;
	}
	
	//method for getting price
	public void getPrice(int price){
		this.price = price;
	}
	
	//method for establishing product database
		public void establishProductDatabase(){
			
			 try { 
				 	if(db.conn==null){
				 		db.connect();
				 	}
				 
				 	Statement stmt = db.getConn().createStatement();
				 	String sql1 = "SELECT productid, productname, price FROM Product";
				 			ResultSet rs = stmt.executeQuery(sql1);
				 			
				 			while (rs.next()){
						    	int id = rs.getInt("productid");
						    	String productname = rs.getString("productname");
						    	int price = rs.getInt("price");
						    	System.out.println("\n Product id: " + id + "\n Product: " 
						    	+ productname + "\n Price: £" + price );
						    } 
				 			rs.close();
		 		} catch (SQLException ex) {
			 	
		 			// Database error handling
		 			System.out.println("Failed to connect to Database...");
			 	}
			 
			 return;
		}
	 

	/*public void accessBD() {

		  
		  System.out.println("Looking for records in the table...");
			stmt = conn.createStatement();
			String sql1 = "SELECT productid, productname, price FROM Product";
		    ResultSet rs = stmt.executeQuery(sql1);
		    while (rs.next()){
		    	int id = rs.getInt("productid");
		    	String productname = rs.getString("productname");
		    	int price = rs.getInt("price");
		    	System.out.println("Product id: " + id + " Product: " + productname + " Price: £" + price );
		    } 
			
		 }
		  catch (SQLException | ClassNotFoundException ex) {
		     System.out.println("failure to connect"); // Seperate routine to display errors.
		  }
		 }*/
	

}
