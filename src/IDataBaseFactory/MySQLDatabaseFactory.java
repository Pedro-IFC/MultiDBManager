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
			boolean pass=false;
			try {
				Connection connG = createConnection("").getConnection();
				Statement p = connG.createStatement();
				p.executeUpdate("CREATE DATABASE " + args[0]);
				p.close();
				connG.close();
				System.out.println(args[0] + ".status = criado");
				pass=true;
			} catch (SQLException e) {
				System.out.println(args[0] + ".status = erro");
			}

			if(args[1]!=null && args[1]!="" && pass) {
				try {
					Connection connE = createConnection(args[0]).getConnection();
					String[] partes = args[1].split(";");
					for(String parte : partes) {
						Statement p = connE.createStatement();
							p.executeUpdate(parte+";");
							System.out.println(parte+";");
						p.close();
					}
					connE.close(); 
					System.out.println(args[0] + ".tabelas.status = criado");
					pass=true;
				}catch (SQLException e) {
					pass=false;
					System.out.println(args[0] + ".tabelas.status = erro");
				}
			}
		}
	}
	
}
