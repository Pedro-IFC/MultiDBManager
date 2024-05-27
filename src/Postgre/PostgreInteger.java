package Postgre;

import interfaces.IAttr;

public final class PostgreInteger extends IAttr {
	public static PostgreInteger create(IAttr attr) {
		return new PostgreInteger(attr);
	}
	private PostgreInteger(IAttr attr) {
		super(attr.getName(), "INTEGER", attr.getSize());
	}
	public String toCreateLog() {
		return getName()+" "+getType();
	}
}
