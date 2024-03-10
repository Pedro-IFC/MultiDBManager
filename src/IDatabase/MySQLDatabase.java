package IDatabase;

import ITable.ITable;
import ITable.MySQLTable;

public class MySQLDatabase extends IDatabase{

	public MySQLDatabase(String name, String colletion) {
		super(name, colletion);
	}

	public ITable createTable(String name) {
		this.setTable(new MySQLTable(name));
		return this.getTable();
	}

	public String toCreateLog() {
		return "CREATE DATABASE " + getName() + ";USE "+ getName() + ";" + ( this.getTable()!=null?this.getTable().toCreateLog():"");
	}

}
