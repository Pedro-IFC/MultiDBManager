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
		this.getPrimaryKeyLog().add(getAttrFac().generatePrimaryKey(this.getName(), name).toCreateLog());
		return this;
	}
	public ITable createForeignKey(String name, String tabelaRef, String atributoRef) {
		this.getForeignKeyLog().add(getAttrFac().generateForeignKey(this.getName(),name, tabelaRef, atributoRef).toCreateLog());
		return this;
	}
	public String[] toCreateLog() {
		String[] all = {"", ""};
		if(getAttrLogs().size()>0) {
			all[0]+="CREATE TABLE "+getName()+ "(";
			for(int i = 0; i<getAttrLogs().size(); i++) {
				all[0]+=getAttrLogs().get(i);
				if(i+1!=getAttrLogs().size()) {
					all[0]+=",";
				}
			}
			all[0]+= ");";
		}
		if(getPrimaryKeyLog().size()>0) {
			for(int i = 0; i<getPrimaryKeyLog().size(); i++) {
				all[0]+=getPrimaryKeyLog().get(i);
			}
		}
		if(getForeignKeyLog().size()>0) {
			for(int i = 0; i<getForeignKeyLog().size(); i++) {
				all[1]+=getForeignKeyLog().get(i);
			}
		}
		return all;
	}

}
