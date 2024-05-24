package MySQL;

import interfaces.IAttr;

public class MySQLAttr extends IAttr{
	public MySQLAttr(String name, String type, int size) {
		super(name, type, size);
	}
	public String toCreateLog() {
		return getName()+" "+getType()+"("+getSize()+")";
	}
}
