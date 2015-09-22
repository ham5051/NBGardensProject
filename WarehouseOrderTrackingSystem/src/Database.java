import java.sql.* ;

public class Database {
	 static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	 static final String DB_URL = "jdbc:mysql://localhost/database";

	 static final String USER = "root";
	 static final String PASS = "password";


	public void accessBD() {
		 Connection conn = null;
		 Statement stmt = null;
		 try {
		  Class.forName( "com.mysql.jdbc.Driver");
		  System.out.println("Connecting to database...");
		  conn = DriverManager.getConnection(DB_URL, USER, PASS);
		  

			
			
		 }
		  catch (SQLException | ClassNotFoundException ex) {
		     System.out.println("failure to connect"); // Seperate routine to display errors.
		  }
		 }
	}

