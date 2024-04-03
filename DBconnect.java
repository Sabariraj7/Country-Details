


import java.sql.DriverManager;
import java.sql.Connection;

public final class DBconnect{
	
    public static Connection createConnection(){
		Connection  con = null;
        try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/country_detail","root","root");
			//System.out.println("DB_Connected");
		}
		catch (Exception e){
                System.out.println(e);
		}
		return con;
    }
	
}