package IPrimaryKey;

public abstract class IPrimaryKey {
	private String name;
	private String tb;
	public IPrimaryKey(String name) {
		this.name=name;
	}
	public abstract String toCreateLog();
	public String getName() {
		return name;
	}
	public String getTb() {
		return tb;
	}
	public void setTb(String tb) {
		this.tb = tb;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
