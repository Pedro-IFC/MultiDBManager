package interfaces;

import java.util.List;

public abstract class IDatabase {
	private String name;
	private String colletion;
	private String character;
	private List<ITable> Table;
	public IDatabase(String name, String colletion, String character) {
		this.setName(name);
		this.setColletion(colletion);
		this.setCharacter(character);
	}
	public String getCharacter() {
		return character;
	}

	public void setCharacter(String character) {
		this.character = character;
	}

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
	public List<ITable> getTable() {
		return Table;
	}
	public void setTable(List<ITable> table) {
		Table = table;
	}
	public abstract ITable createTable(String name);
	public abstract String[] toCreateLog();
	
}
