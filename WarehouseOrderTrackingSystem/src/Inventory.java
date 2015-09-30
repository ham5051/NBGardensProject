import java.sql.*;

public class Inventory {
	
	//attributes for inventory
	private int inventoryid;
	private int stocklevel;
	private String location;
	private String productname;
	private int Product_productid;
	public Database db;
	private WarehouseOrderTrackingApplication app;
	
	// overloading the constructor
	public Inventory(WarehouseOrderTrackingApplication app)
	{
		// initialise app
		this.setApp(app);
		db = new Database();
	}
	
	//class constructors
	public Inventory(){
		inventoryid = 0;
		stocklevel = 0;
		location = null;
		Product_productid = 0;
	}
	/**
	 * @return the product_productid
	 */
	public int getProduct_productid() {
		return Product_productid;
	}

	/**
	 * @param product_productid the product_productid to set
	 */
	public void setProduct_productid(int product_productid) {
		Product_productid = product_productid;
	}

	//get inventory id method
	public int getInventoryid(){
		return inventoryid;
	}
	
	//set inventory id method
	public void setInventoryid(int inventoryid){
		this.inventoryid = inventoryid;
		return;
	}
	
	//get stock level method
	public int getStocklevel(){
		return stocklevel;
	}
	
	//set stock level
	public void setStocklevel(int stocklevel){
		this.stocklevel = stocklevel;
		return;
	}
	
	//get location method
	public String getLocation(){
		return location;
	}
	
	//set location method
	public void setLocation(String location){
		this.location = location;
		return;
	}
	
	public void establishInventory(){
		 try { 
			 	if(db.conn==null){
			 		db.connect();
			 	}
			 	System.out.println("Inventory");
			 	Statement stmt = db.getConn().createStatement();
			 	String sql1 = "SELECT inventoryid, location, stocklevel, Product_productid FROM Inventory";
			 			//+ "FROM Inventory"; //, Product Where Product.productid = Inventory.Product_productid ";
			 			//+ "WHERE Order.Employee_employee_id = Employee.employeeid";
			 			ResultSet rs = stmt.executeQuery(sql1);
			 			
			 			while (rs.next()){
					    	int id = rs.getInt("inventoryid");
					    	String location = rs.getString("location");
					    	int stocklevel = rs.getInt("stocklevel");
					    	int Product_productid = rs.getInt("Product_productid");
					    	System.out.println("\n Inventory ID: " + id + "\n Location: " + location + 
					    						"\n Stock Level: " + stocklevel + "\n Product:" + Product_productid);
					    } rs.close();
			 			
	 		} catch (SQLException ex) {
		 	
	 			// Database error handling
	 			System.out.println("Failed to connect to Database...");
		 	}
		 
		 return;
	}
	
	public void establishInventory1(){
		 try { 
			 	if(db.conn==null){
			 		db.connect();
			 	}
			 	System.out.println("Inventory");
			 	Statement stmt = db.getConn().createStatement();
			 	String sql1 = "SELECT inventoryid, location, stocklevel, productname "
			 			+ "FROM Inventory, Product Where Product.productid = Inventory.Product_productid";
			 			
			 	ResultSet rs = stmt.executeQuery(sql1);
			 			
			 			while (rs.next()){
					    	int id = rs.getInt("inventoryid");
					    	String location = rs.getString("location");
					    	int stocklevel = rs.getInt("stocklevel");
					    	String productname = rs.getString("productname");
					    	System.out.println("\n Inventory ID: " + id + "\n Location: " + location + 
					    						"\n Stock Level: " + stocklevel + "\n Product: " + productname);
					    }  rs.close();
			 			
	 		} catch (SQLException ex) {
		 	
	 			// Database error handling
	 			System.out.println("Failed to connect to Database...");
		 	}
		 
		 return;
	}

	/**
	 * @return the productname
	 */
	public String getProductname() {
		return productname;
	}

	/**
	 * @param productname the productname to set
	 */
	public void setProductname(String productname) {
		this.productname = productname;
	}

	/**
	 * @return the product_product_id

	/**
	 * @return the app
	 */
	public WarehouseOrderTrackingApplication getApp() {
		return app;
	}

	/**
	 * @param app the app to set
	 */
	public void setApp(WarehouseOrderTrackingApplication app) {
		this.app = app;
	}

}
