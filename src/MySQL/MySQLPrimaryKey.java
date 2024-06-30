package MySQL;

import interfaces.IPrimaryKey;

public class MySQLPrimaryKey extends IPrimaryKey{
	
	public MySQLPrimaryKey(String tb, String name) {
		super(name);
		this.setTb(tb);
	}
	public String toCreateLog() {
		return "ALTER TABLE "+this.getTb()+" ADD PRIMARY KEY ("+this.getName()+");";
	}

}
