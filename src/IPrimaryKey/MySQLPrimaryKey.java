package IPrimaryKey;

public class MySQLPrimaryKey extends IPrimaryKey{

	public MySQLPrimaryKey(String name) {
		super(name);
	}

	public String toCreateLog() {
		return "CONSTRAINT "+getName()+" PRIMARY KEY("+getName()+")";
	}

}
