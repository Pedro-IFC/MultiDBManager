package IForeignKey;

public class MySQLForeignKey extends IForeignKey{

	public MySQLForeignKey(String name, String tableRef, String nameRef) {
		super(name, tableRef, nameRef);
	}
	public String toCreateLog() {
		return "FOREIGN KEY ("+getName()+") REFERENCES "+getTableRef()+" ("+getNameRef()+")";
	}

}
