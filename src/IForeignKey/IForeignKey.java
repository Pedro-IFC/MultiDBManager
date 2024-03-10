package IForeignKey;

public abstract class IForeignKey {
	private String name;
	private String tableRef;
	private String nameRef;
	public IForeignKey(String name, String tableRef, String nameRef) {
		this.name=name;
		this.tableRef=tableRef;
		this.nameRef=nameRef;
	}
	public abstract String toCreateLog();
	public String getName() {
		return name;
	}
	public String getTableRef() {
		return tableRef;
	}
	public String getNameRef() {
		return nameRef;
	}
}
