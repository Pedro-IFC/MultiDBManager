package IDataBaseFactory;

import IConnection.IConnection;
import IConnection.MySQLConnection;
import IDatabase.IDatabase;
import IDatabase.MySQLDatabase;
import MultiDBManager.Logger;

public class MySQLDatabaseFactory extends DataBaseFactory{

	public IDatabase createDatabase(String name, String colletion) {
		IDatabase m = new MySQLDatabase(name, colletion);
		this.setDatabase(m);
		return m;
	}

	public IConnection createConnection() {
		return new MySQLConnection();
	}
	public void toRun(){
		Logger.getInstance().add(this.getDatabase().toCreateLog());
	}

}
