package IConnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLConnection implements IConnection{
	protected String host ="localhost";
	protected String port ="3306";
	protected String user ="root";
	protected String pass ="";
	protected String db = "";
	
	public MySQLConnection(String name) {
		this.db=name;
	}
	public Connection getConnection() {
    	try {
    		Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/"+db,user, pass);
        } catch (Exception e) {
        	System.out.println("Erro ao conectar ao servidor");
            return null;
        }
	}
	@Override
	public String toString() {
		return "jdbc:mysql://"+host+":"+port+"/"+db;
	}
	
}
