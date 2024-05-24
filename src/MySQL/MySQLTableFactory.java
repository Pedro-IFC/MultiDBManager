package MySQL;

import interfaces.IAttr;
import interfaces.IForeignKey;
import interfaces.IPrimaryKey;
import interfaces.ITableFactory;

public class MySQLTableFactory implements ITableFactory {
	public IAttr generateAttr(String name, String type, int size) {
		return new MySQLAttr(name, type, size);
	}
	public IPrimaryKey generatePrimaryKey(String tb, String name) {
		return new MySQLPrimaryKey(tb, name);
	}

	public IForeignKey generateForeignKey(String tb, String name, String tabelaRef, String atributoRef) {
		return new MySQLForeignKey(tb, name, tabelaRef, atributoRef);
	}

}
