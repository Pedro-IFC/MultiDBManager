package Postgre;

import interfaces.IPrimaryKey;

public class PostgrePrimaryKey extends IPrimaryKey{
	
	public PostgrePrimaryKey(String tb, String name) {
		super(name);
		this.setTb(tb);
	}

	public String toCreateLog() {
		return "ALTER TABLE "+this.getTb()+" ADD PRIMARY KEY ("+this.getName()+");";
	}

}
