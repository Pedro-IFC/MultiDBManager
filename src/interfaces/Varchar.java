package interfaces;

public class Varchar extends IAttr {
	public static Varchar create(String name, int size) {
		return new Varchar(name, size);
	}
	private Varchar(String name, int size) {
		super(name, "varchar", size);
	}
	public String toCreateLog() {
		return "IAttr [name=" + getName() + ", type=" + getType() + ", size=" + getSize() + ", tb=" + getTb() + "]";
	}
}
