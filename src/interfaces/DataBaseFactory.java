package interfaces;

import java.util.List;

public abstract class DataBaseFactory {
	private List<IDatabase> database;
	public DataBaseFactory(String host, String port, String user, String pass) {
		
	}
	public abstract IDatabase createDatabase(String name, String colletion, String character);
	public abstract IConnection createConnection(String DB);
	public abstract void toRun();
	public abstract void down();
	public List<IDatabase> getDatabase() {
		return database;
	}
	public void setDatabase(List<IDatabase> database) {
		this.database = database;
	}
	public abstract String getString();
}
