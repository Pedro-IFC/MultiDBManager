package Postgre;

import java.util.ArrayList;
import java.util.List;

import interfaces.IAttr;
import interfaces.IForeignKey;
import interfaces.IPrimaryKey;
import interfaces.ITable;

public class PostgreTable extends ITable{
	public PostgreTable(String name) {
		super(name, new PostgreTableFactory());
	}
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
			PostgreAttr nAttr = new PostgreAttr(this.attrs.get(i));
			attrLogs.add(nAttr.toCreateLog());
		}
		return attrLogs;
	}
	public IAttr createAttr(IAttr attr) {
		attr.setTb(this);
		this.getAttrs().add(attr);
		return attr;
	}
	public IAttr createAttr(String name) {
		IAttr attr = new IAttr(name, null, 0);
		attr.setTb(this);
		this.getAttrs().add(attr);
		return attr;
	}
	public IPrimaryKey createPrimaryKey(IAttr attr) {
		IPrimaryKey r = getAttrFac().generatePrimaryKey(this.getName(), attr.getName(), attr.getType());
		this.getPrimarykeys().add(r);
		return r;
	}
	public IAttr createAttrFk(IAttr attr) {
		PostgreAttr nAttr = new PostgreAttr(attr);
		nAttr.setDefaultProp(false);
		nAttr.setNotnull(false);
		nAttr.setUnique(false);
		nAttr.setTb(this);
		this.getAttrs().add(nAttr);
		attr.setTb(this);
		return attr;
	}
	public IForeignKey createForeignKey(IPrimaryKey key, IAttr att) {
		att = this.createAttrFk(att);
		IForeignKey r= getAttrFac().generateForeignKey(att.getTb().getName(), att.getName(), key.getTb(), key.getName());
		this.getForeignkeys().add(r);
		return r;
	}
	public String[] toCreateLog() {
		String[] all = {"", ""};
		if(getAttrLogs().size()>0) {
			List<String> rep = new ArrayList<String>();
			all[0]+="CREATE TABLE "+getName()+ "(";
			for(int i = 0; i<getAttrLogs().size(); i++) {
				if(!rep.contains(getAttrLogs().get(i))) {
					all[0]+=getAttrLogs().get(i);
					if(i+1!=getAttrLogs().size()) {
						all[0]+=",";
					}
					rep.add(getAttrLogs().get(i));
				}
			}
			all[0]+= ");";
		}
		if(getPrimaryKeyLog().size()>0) {
			for(int i = 0; i<getPrimaryKeyLog().size(); i++) {
				all[0]+=getPrimaryKeyLog().get(i);
			}
		}
		if(getForeignKeyLog().size()>0) {
			for(int i = 0; i<getForeignKeyLog().size(); i++) {
				all[1]+=getForeignKeyLog().get(i);
			}
		}
		return all;
	}
	public IAttr createIndex(IAttr attr) {
		this.getIndexLog().add("CREATE INDEX idx_"+attr.getName()+" ON "+attr.getTb()+"("+attr.getName()+");");
		return attr;
	}

}
