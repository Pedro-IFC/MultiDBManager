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
	public IAttr createAttr(IAttr attr) {
		attr.setTb(this.getName());
		this.getAttrLogs().add(PostgreInteger.create(attr).toCreateLog());
		return attr;
	}
	public IPrimaryKey createPrimaryKey(IAttr attr) {
		IPrimaryKey r = getAttrFac().generatePrimaryKey(this.getName(), attr.getName());
		this.getPrimaryKeyLog().add(r.toCreateLog());
		return r;
	}
	public IForeignKey createForeignKey(IPrimaryKey key, IAttr att) {
		att = this.createAttr(att);
		IForeignKey r= getAttrFac().generateForeignKey(att.getTb(), att.getName(), key.getTb(), key.getName());
		this.getForeignKeyLog().add(r.toCreateLog());
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

}
