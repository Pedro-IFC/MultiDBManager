package IConnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLConnection implements IConnection{
	protected String host ="localhost";
	protected String port ="3306";
	protected String user ="root";
	protected String pass ="";
	public Connection getConnection() {
    	try {
    		Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://"+host+":"+port,user, pass);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
	}
}
