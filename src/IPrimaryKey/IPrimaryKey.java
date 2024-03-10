package IPrimaryKey;

public abstract class IPrimaryKey {
	private String name;
	public IPrimaryKey(String name) {
		this.name=name;
	}
	public abstract String toCreateLog();
	public String getName() {
		return name;
	}
}
