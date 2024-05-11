package IDataBaseFactory;

import IDatabase.IDatabase;

import java.util.List;

import IConnection.IConnection;

public abstract class DataBaseFactory {
	private List<IDatabase> database;
	public abstract IDatabase createDatabase(String name, String colletion);
	public abstract IConnection createConnection(String DB);
	public abstract void toRun();
	public abstract void down();
	public  List<IDatabase> getDatabase() {
		return database;
	}
	public void setDatabase(List<IDatabase> database) {
		this.database = database;
	}
}
