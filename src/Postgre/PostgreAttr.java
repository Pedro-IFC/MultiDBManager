package Postgre;

import interfaces.IAttr;
import interfaces.InterfaceAttr;

public class PostgreAttr extends IAttr implements InterfaceAttr{
	public PostgreAttr(String name, String type, int size) {
		super(name, type, size);
	}
	public PostgreAttr(IAttr attr) {
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
			(getType()=="int"?"integer":getType())
			+(getType()=="int"?"":(getSize()>0?"("+getSize()+")":"")) + 
			(isUnique()?" UNIQUE ":"")+
			(isNotnull()?" NOT NULL ":"")+
			(isDefaultProp()?" DEFAULT '"+getDefaultvalue()+"'":"")
		;
	}
}
