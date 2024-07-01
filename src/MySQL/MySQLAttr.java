package MySQL;

import interfaces.IAttr;
import interfaces.InterfaceAttr;

public class MySQLAttr extends IAttr implements InterfaceAttr{
	public MySQLAttr(String name, String type, int size) {
		super(name, type, size);
	}
	public MySQLAttr(IAttr attr) {
		super(
			attr.getName(),
			attr.getType(),
			attr.getSize(),
			attr.getTb(),
			attr.isUnique(),
			attr.isNotnull(),
			attr.isDefaultProp(),
			attr.getDefaultvalue()
		);
	}
	public String toCreateLog() {
		return  getName()+" "+
			getType()+(getSize()>0?"("+getSize()+")":"") +
			(isUnique()?" UNIQUE ":"") +
			(isNotnull()?" NOT NULL ":"")+
			(isDefaultProp()?" DEFAULT '"+getDefaultvalue()+"'":"")
		;
	}
}
