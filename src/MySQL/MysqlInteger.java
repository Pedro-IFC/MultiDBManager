package MySQL;

import interfaces.IAttr;

public final class MysqlInteger extends IAttr {
	public static MysqlInteger create(IAttr attr) {
		return new MysqlInteger(attr);
	}
	private MysqlInteger(IAttr attr) {
		super(attr.getName(), "int", attr.getSize());
	}
	public String toCreateLog() {
		return getName()+" "+getType()+"("+getSize()+")";
	}
}
