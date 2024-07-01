package MySQL;

import interfaces.IPrimaryKey;

public class MySQLPrimaryKey extends IPrimaryKey{
	
	public MySQLPrimaryKey(String tb, String name, String type) {
		super(name, type);
		this.setTb(tb);
	}
	public String toCreateLog() {
		if(this.isAutoincrement()) {
			return "ALTER TABLE "+ this.getTb() +" MODIFY "+ this.getName() +" "+ this.getType()+ " AUTO_INCREMENT PRIMARY KEY;";
		}
		return "ALTER TABLE "+this.getTb()+" ADD PRIMARY KEY ("+this.getName()+");";
	}

}
