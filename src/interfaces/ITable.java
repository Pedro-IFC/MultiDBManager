package interfaces;

import java.util.ArrayList;
import java.util.List;

public abstract class ITable{
	private String name;
	private ITableFactory attrFac;
	private List<String> attrLogs;
	private List<String> primaryKeyLog;
	private List<String> foreignKeyLog;
	private List<String> indexLog;
	public List<String> getPrimaryKeyLog() {
		return primaryKeyLog;
	}
	public void setPrimaryKeyLog(List<String> primaryKeyLog) {
		this.primaryKeyLog = primaryKeyLog;
	}
	public ITable(String name, ITableFactory attrFac) {
		this.setName(name);
		this.setAttrFac(attrFac);
		this.setAttrLogs(new ArrayList<String>());
		this.setPrimaryKeyLog(new ArrayList<String>());
		this.setForeignKeyLog(new ArrayList<String>());
		this.setIndexLog(new ArrayList<String>());
	}
	public String getName() {
		return name;
	}
	public List<String> getIndexLog() {
		return indexLog;
	}
	public void setIndexLog(List<String> indexLog) {
		this.indexLog = indexLog;
	}
	public List<String> getForeignKeyLog() { 
		return foreignKeyLog; 
	}
	public void setForeignKeyLog(List<String> foreignKeyLog) {
		this.foreignKeyLog = foreignKeyLog;
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
	public abstract IAttr createAttr(IAttr attr);
	public abstract IAttr createAttr(String name);
	public abstract IPrimaryKey createPrimaryKey(IAttr attr);
	public abstract IAttr createIndex(IAttr attr);
	public abstract IForeignKey createForeignKey(IPrimaryKey key, IAttr att);
	public abstract String[] toCreateLog();
}
