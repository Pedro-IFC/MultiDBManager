package ITable;

import java.util.ArrayList;
import java.util.List;

import TableFactory.ITableFactory;

public abstract class ITable{
	private String name;
	private ITableFactory attrFac;
	private List<String> attrLogs;
	public ITable(String name, ITableFactory attrFac) {
		this.setName(name);
		this.setAttrFac(attrFac);
		this.setAttrLogs(new ArrayList<String>());
	}
	public abstract ITable createAttr(String name, String type, int size);
	public abstract ITable createPrimaryKey(String name);
	public abstract ITable createForeignKey(String name, String tabelaRef, String atributoRef);
	public abstract String toCreateLog();
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ITableFactory getAttrFac() {
		return attrFac;
	}
	public void setAttrFac(ITableFactory attrFac) {
		this.attrFac = attrFac;
	}
	public List<String> getAttrLogs() {
		return attrLogs;
	}
	public void setAttrLogs(List<String> attrLogs) {
		this.attrLogs = attrLogs;
	}
}
