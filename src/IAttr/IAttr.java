package IAttr;

public abstract class IAttr {
	private String name;
	private String type;
	private int size;
	public IAttr(String name, String type, int size) {
		this.name=name;
		this.type=type;
		this.size=size;
	}
	public abstract String toCreateLog();
	public String getName() {
		return name;
	}
	public String getType() {
		return type;
	}
	public int getSize() {
		return size;
	}
}
