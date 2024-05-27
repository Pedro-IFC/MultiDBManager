package Postgre;

import java.sql.Connection;
import java.sql.DriverManager;

import interfaces.IConnection;

public class PostgreConnection implements IConnection{
	protected String host ="";
	protected String port ="";
	protected String user ="";
	protected String pass ="";
	protected String db = "";
	
	
	public PostgreConnection(String host, String port, String user, String pass, String db) {
		this.host = host;
		this.port = port;
		this.user = user;
		this.pass = pass;
		this.db = db;
	}
	public Connection getConnection() {
    	try {
            return DriverManager.getConnection("jdbc:postgresql://"+host+":"+port+"/"+db,user, pass);
        } catch (Exception e) {
        	System.out.println("Erro ao conectar ao servidor Postgree");
            return null;
        }
	}
	@Override
	public String toString() {
		return "jdbc:postgresql://"+host+":"+port+"/"+db;
	}
	
}
