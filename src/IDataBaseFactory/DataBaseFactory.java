package IDataBaseFactory;

import IDatabase.IDatabase;
import IConnection.IConnection;

public abstract class DataBaseFactory {
	private IDatabase database;
	public abstract IDatabase createDatabase(String name, String colletion);
	public abstract IConnection createConnection();
	public abstract void toRun();
	public IDatabase getDatabase() {
		return database;
	}
	public void setDatabase(IDatabase database) {
		this.database = database;
	}
}
