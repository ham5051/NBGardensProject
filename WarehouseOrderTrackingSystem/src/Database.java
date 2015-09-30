import java.sql.* ;

public class Database {
	 public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	 public static final String DB_URL = "jdbc:mysql://localhost/database";
	 public Connection conn = null;
	 public Statement stmt = null;
	 public static final String USER = "root";
	 public static final String PASS = "password";

	 //class constructor 
	 public Database(){
		  try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 
	 
	 public void connect(){
		 try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 
	 public String getJDBC_DRIVER(){
		 return JDBC_DRIVER;
	 }
	 
	 public String getDB_URL(){
		 return DB_URL;
	 }
	 
	 public Connection getConn(){
		 return conn;
	 }
	 
	 public Statement getStmt(){
		 return stmt;
	 }
	 
	 public String getUser(){
		 return USER;
	 }
	 
	 public String getPass(){
		 return PASS;
	 }
	 
	 public void setStmt(Statement stmt){
		 this.stmt = stmt;
	 }
	 
}


