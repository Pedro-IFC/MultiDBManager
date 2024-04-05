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

	public String[] toCreateLog() {
		String[] r = {getName(), ""};
		if(this.getTable()!=null) {
			r[1]=this.getTable().toCreateLog();
		}
		return r;
	}
}
