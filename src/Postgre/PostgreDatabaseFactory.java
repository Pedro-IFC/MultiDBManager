package Postgre;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import interfaces.DataBaseFactory;
import interfaces.IConnection;
import interfaces.IDatabase;

public class PostgreDatabaseFactory extends DataBaseFactory{
	private String host;
	private String port;
	private String user;
	private String pass;
	public PostgreDatabaseFactory(String host, String port, String user, String pass) {
		super(host, port, user, pass);
		this.host = host;
		this.port = port;
		this.user = user;
		this.pass = pass;
	}
	public IDatabase createDatabase(String name, String colletion, String character) {
		List<IDatabase> m = this.getDatabase()==null? new ArrayList<IDatabase>() : this.getDatabase();
		m.add(new PostgreDatabase(name, colletion, character));
		this.setDatabase(m);
		return m.get(m.size()-1);
	}

	public IConnection createConnection(String name) {
		return new PostgreConnection(host, port, user, pass, name);
	}
	public void toRun(){
		for(int i=0; i<getDatabase().size();i++) {
			String[] args = this.getDatabase().get(i).toCreateLog();
			try {
				Connection connG = createConnection("").getConnection();
				if(connG!=null) {
					Statement p = connG.createStatement();
						p.executeUpdate("CREATE DATABASE " + args[0]);
					p.close();
					connG.close();
					System.out.println(args[0] + ".criado = sucess");
				}
			} catch (SQLException e) {
				System.out.println(args[0] + ".criado = error");
			}
			if(!args[1].isEmpty()) {
				try {
					Connection connE = createConnection(args[0]).getConnection();
					if(connE!=null) {
						String[] partes = args[1].split(";");
						for(String parte : partes) {
							Statement p = connE.createStatement();
								p.executeUpdate(parte+";");
							p.close();
						}
						connE.close(); 
						System.out.println("+->" + args[0] + ".tabelas.criado = sucess");
					}
				}catch (SQLException e) {
					System.out.println("+->" + args[0] + ".tabelas.criado = error");
				}
			}
			
			if(!args[2].isEmpty()) {
				try {
					Connection connE = createConnection(args[0]).getConnection();
					if(connE!=null) {
						String[] partes = args[2].split(";");
						for(String parte : partes) {
							Statement p = connE.createStatement();
								p.executeUpdate(parte+";");
							p.close();
						}
						connE.close(); 
						System.out.println(" +->" + args[0] + ".foreignKey.criado = sucess");
					}
				}catch (SQLException e) {
					System.out.println(" +->" + args[0] + ".foreignKey.criado = error");
				}
			}
		}
	}
	public void down() {
		for(int i=0; i<getDatabase().size();i++) {
			String name = this.getDatabase().get(i).getName();
			
			try {
				Connection connG = createConnection("").getConnection();
				if(connG!=null) {
					Statement p = connG.createStatement();
						p.executeUpdate("DROP DATABASE " + name);
					p.close();
					connG.close();
					System.out.println(name + ".deletar = sucess");
				}
			} catch (SQLException e) {
				System.out.println(name + ".deletar = error");
			}
		}
	}
	public String getString() {
		String R="";
		for(int i=0; i<getDatabase().size();i++) {
			String[] args = this.getDatabase().get(i).toCreateLog();
			R+="CREATE DATABASE " + args[0]+"\n";
			if(!args[1].isEmpty()) {
				String[] partes = args[1].split(";");
				for(String parte : partes) {
					R+=parte+";\n";
				}
			}
			if(!args[2].isEmpty()) {
				String[] partes = args[2].split(";");
				for(String parte : partes) {
					R+= parte+";\n";
				}
			}
		}
		return R;
	}
}
