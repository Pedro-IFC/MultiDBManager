package interfaces;

import java.util.ArrayList;
import java.util.List;

public abstract class ITable{
	private String name;
	private ITableFactory attrFac;
	protected List<IAttr> attrs;
	protected List<IPrimaryKey> primarykeys;
	protected List<IForeignKey> foreignkeys;
	protected List<String> indexLog;
	public List<String> getPrimaryKeyLog() {
		List<String> primaryKeyLog = new ArrayList<>();
		for(int i=0; i<this.primarykeys.size();i++) {
			primaryKeyLog.add(this.primarykeys.get(i).toCreateLog());
		}
		return primaryKeyLog;
	}
	public List<String> getForeignKeyLog() { 
		List<String> foreignKeyLog = new ArrayList<>();
		for(int i=0; i<this.foreignkeys.size();i++) {
			foreignKeyLog.add(this.foreignkeys.get(i).toCreateLog());
		}
		return foreignKeyLog;
	}
	public List<String> getAttrLogs() {
		List<String> attrLogs = new ArrayList<>();
		for(int i=0; i<this.attrs.size();i++) {
			attrLogs.add(this.attrs.get(i).toCreateLog());
		}
		return attrLogs;
	}
	public ITable(String name, ITableFactory attrFac) {
		this.setName(name);
		this.setAttrFac(attrFac);
		this.setAttrs(new ArrayList<IAttr>());
		this.setPrimarykeys(new ArrayList<IPrimaryKey>());
		this.setForeignkeys(new ArrayList<IForeignKey>());
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
	public void setName(String name) {
		this.name = name;
	}
	public ITableFactory getAttrFac() {
		return attrFac;
	}
	public void setAttrFac(ITableFactory attrFac) {
		this.attrFac = attrFac;
	}
	public List<IAttr> getAttrs() {
		return attrs;
	}
	public void setAttrs(List<IAttr> attrs) {
		this.attrs = attrs;
	}
	public List<IPrimaryKey> getPrimarykeys() {
		return primarykeys;
	}
	public void setPrimarykeys(List<IPrimaryKey> primarykeys) {
		this.primarykeys = primarykeys;
	}
	public List<IForeignKey> getForeignkeys() {
		return foreignkeys;
	}
	public void setForeignkeys(List<IForeignKey> foreignkeys) {
		this.foreignkeys = foreignkeys;
	}
	public abstract IAttr createAttr(String name);
	public abstract IPrimaryKey createPrimaryKey(IAttr attr);
	public abstract IAttr createIndex(IAttr attr);
	public abstract IForeignKey createForeignKey(IPrimaryKey key, IAttr att);
	public abstract String[] toCreateLog();
}
