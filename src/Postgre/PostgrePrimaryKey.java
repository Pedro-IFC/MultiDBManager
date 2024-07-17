package Postgre;

import interfaces.IPrimaryKey;

public class PostgrePrimaryKey extends IPrimaryKey{
	
	public PostgrePrimaryKey(String tb, String name, String type) {
		super(name, type);
		this.setTb(tb);
	}
	public String toCreateLog() {
		if(this.isAutoincrement()) {
			return "CREATE SEQUENCE "+this.getTb()+"_id_seq;\n" + " ALTER TABLE "+ this.getTb() +" ALTER COLUMN "+ this.getName() +" SET DEFAULT nextval('alunos_id_seq');" + "ALTER TABLE "+this.getTb()+" ADD PRIMARY KEY ("+this.getName()+");\n";
		}
		return "ALTER TABLE "+this.getTb()+" ADD PRIMARY KEY ("+this.getName()+");";
	}

}
