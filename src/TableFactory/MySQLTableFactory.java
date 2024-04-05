package TableFactory;

import IAttr.IAttr;
import IAttr.MySQLAttr;
import IForeignKey.IForeignKey;
import IForeignKey.MySQLForeignKey;
import IPrimaryKey.IPrimaryKey;
import IPrimaryKey.MySQLPrimaryKey;

public class MySQLTableFactory implements ITableFactory {
	public IAttr generateAttr(String name, String type, int size) {
		return new MySQLAttr(name, type, size);
	}
	public IPrimaryKey generatePrimaryKey(String tb, String name) {
		return new MySQLPrimaryKey(tb, name);
	}

	public IForeignKey generateForeignKey(String name, String tabelaRef, String atributoRef) {
		return new MySQLForeignKey(name, tabelaRef, atributoRef);
	}

}
