package IForeignKey;

public abstract class IForeignKey {
	private String name;
	private String tableRef;
	private String nameRef;
	private String tb;
	public IForeignKey(String tb,String name, String tableRef, String nameRef) {
		this.name=name;
		this.tableRef=tableRef;
		this.nameRef=nameRef;
		this.tb=tb;
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
	public String getTb() {
		return tb;
	}
	public void setTb(String tb) {
		this.tb = tb;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setTableRef(String tableRef) {
		this.tableRef = tableRef;
	}
	public void setNameRef(String nameRef) {
		this.nameRef = nameRef;
	}
	
}
