package interfaces;

public abstract class IPrimaryKey {
	private String name;
	private String type;
	private String tb;
	private boolean autoincrement;
	public IPrimaryKey autoincrement() {
		this.setAutoincrement(type.equals("int"));
		return this;
	}
	public IPrimaryKey(String name, String type) {
		this.name=name;
		this.type=type;
	}
	public String getName() {
		return name;
	}
	public String getTb() {
		return tb;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setTb(String tb) {
		this.tb = tb;
	}
	public void setName(String name) {
		this.name = name;
	}
	public abstract String toCreateLog();
	public boolean isAutoincrement() {
		return autoincrement;
	}
	public void setAutoincrement(boolean autoincrement) {
		this.autoincrement = autoincrement;
	}
}
