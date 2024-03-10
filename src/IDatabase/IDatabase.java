package IDatabase;

import ITable.ITable;

public abstract class IDatabase {
	private String name;
	private String colletion;
	private ITable Table;
	public IDatabase(String name, String colletion) {
		this.setName(name);
		this.setColletion(colletion);
	}
	public abstract ITable createTable(String name);
	public abstract String toCreateLog();
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColletion() {
		return colletion;
	}
	public void setColletion(String colletion) {
		this.colletion = colletion;
	}
	public ITable getTable() {
		return Table;
	}
	public void setTable(ITable table) {
		Table = table;
	}
	
}
