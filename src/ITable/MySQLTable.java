package ITable;

import TableFactory.MySQLTableFactory;

public class MySQLTable extends ITable{
	public MySQLTable(String name) {
		super(name, new MySQLTableFactory());
	}
	public ITable createAttr(String name, String type, int size) {
		this.getAttrLogs().add(this.getAttrFac().generateAttr(name, type, size).toCreateLog());
		return this;
	}
	public ITable createPrimaryKey(String name) {
		this.getAttrLogs().add(getAttrFac().generatePrimaryKey(name).toCreateLog());
		return this;
	}
	public ITable createForeignKey(String name, String tabelaRef, String atributoRef) {
		this.getAttrLogs().add(getAttrFac().generateForeignKey(name, tabelaRef, atributoRef).toCreateLog());
		return this;
	}
	public String toCreateLog() {
		String all = "CREATE TABLE "+getName()+ "(";
		for(int i = 0; i<getAttrLogs().size(); i++) {
			all+=getAttrLogs().get(i);
			if(i+1!=getAttrLogs().size()) {
				all+=",";
			}
		}
		all+= ");";
		return all;
	}

}
