package IAttr;

public final class MysqlInteger extends IAttr {
	public static MysqlInteger create(String name, int size) {
		return new MysqlInteger(name, size);
	}
	private MysqlInteger(String name, int size) {
		super(name, "int", size);
	}
	public String toCreateLog() {
		return getName()+" "+getType()+"("+getSize()+")";
	}
	
}
