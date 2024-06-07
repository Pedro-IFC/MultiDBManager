package interfaces;

public abstract class IAttr {
	private String name;
	private String type;
	private int size;
	private String tb;
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
	public String getTb() {
		return tb;
	}
	public void setTb(String tb) {
		this.tb = tb;
	}
	public String toString() {
		return "IAttr [name=" + name + ", type=" + type + ", size=" + size + ", tb=" + tb + "]";
	}
}
