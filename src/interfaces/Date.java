package interfaces;

public class Date extends IAttr {
	public static Date create(String name) {
		return new Date(name);
	}
	private Date(String name) {
		super(name, "DATE", -1);
	}
	public String toCreateLog() {
		return "IAttr [name=" + getName() + ", type=" + getType()+ ", tb=" + getTb() + "]";
	}
}
