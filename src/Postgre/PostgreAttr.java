package Postgre;

import interfaces.IAttr;

public class PostgreAttr extends IAttr{
	public PostgreAttr(String name, String type, int size) {
		super(name, type, size);
	}
	public String toCreateLog() {
		return getName()+" "+getType()+"("+getSize()+")";
	}
}
