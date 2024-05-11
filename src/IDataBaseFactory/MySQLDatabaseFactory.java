package IDataBaseFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import IConnection.IConnection;
import IConnection.MySQLConnection;
import IDatabase.IDatabase;
import IDatabase.MySQLDatabase;

public class MySQLDatabaseFactory extends DataBaseFactory{

	public IDatabase createDatabase(String name, String colletion) {
		List<IDatabase> m = this.getDatabase()==null? new ArrayList<IDatabase>() : this.getDatabase();
		m.add(new MySQLDatabase(name, colletion));
		this.setDatabase(m);
		return m.get(m.size()-1);
	}

	public IConnection createConnection(String name) {
		return new MySQLConnection(name);
	}
	public void toRun(){
		for(int i=0; i<getDatabase().size();i++) {
			String[] args = this.getDatabase().get(i).toCreateLog();
			try {
				Connection connG = createConnection("").getConnection();
					Statement p = connG.createStatement();
						p.executeUpdate("CREATE DATABASE " + args[0]);
					p.close();
				connG.close();
				
				System.out.println(args[0] + ".status = criado");
			} catch (SQLException e) {
				System.out.println(args[0] + ".status = erro");
			}

			if(!args[1].isEmpty()) {
				try {
					Connection connE = createConnection(args[0]).getConnection();
					String[] partes = args[1].split(";");
					for(String parte : partes) {
						Statement p = connE.createStatement();
							p.executeUpdate(parte+";");
						p.close();
					}
					connE.close(); 
					System.out.println("+->" + args[0] + ".tabelas.status = criado");
				}catch (SQLException e) {
					System.out.println("+->" + args[0] + ".tabelas.status = erro");
				}
			}
			
			if(!args[2].isEmpty()) {
				try {
					Connection connE = createConnection(args[0]).getConnection();
					String[] partes = args[2].split(";");
					for(String parte : partes) {
						Statement p = connE.createStatement();
							p.executeUpdate(parte+";");
						p.close();
					}
					connE.close(); 
					
					System.out.println(" +->" + args[0] + ".foreignKey.status = criado");
				}catch (SQLException e) {
					System.out.println(" +->" + args[0] + ".foreignKey.status = erro");
				}
			}
		}
	}
	public void down() {
		for(int i=0; i<getDatabase().size();i++) {
			String name = this.getDatabase().get(i).getName();
			
			try {
				Connection connG = createConnection("").getConnection();
					Statement p = connG.createStatement();
						p.executeUpdate("DROP DATABASE " + name);
					p.close();
				connG.close();
				
				System.out.println(name + ".status = deletado");
			} catch (SQLException e) {
				System.out.println(name + ".status = erro");
			}
		}
	}
	
}
