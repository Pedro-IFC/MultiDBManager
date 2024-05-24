package MySQL;

import interfaces.IForeignKey;

public class MySQLForeignKey extends IForeignKey{

	public MySQLForeignKey(String tb, String name, String tableRef, String nameRef) {
		super(tb, name, tableRef, nameRef);
	}
	public String toCreateLog() {
		return "ALTER TABLE "+this.getTb()+" ADD FOREIGN KEY ("+this.getName()+") REFERENCES "+this.getTableRef()+" ("+this.getNameRef()+");";
	}

}
