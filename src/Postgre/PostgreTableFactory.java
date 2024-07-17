package Postgre;

import interfaces.IAttr;
import interfaces.IForeignKey;
import interfaces.IPrimaryKey;
import interfaces.ITableFactory;

public class PostgreTableFactory implements ITableFactory {
	public IAttr generateAttr(String name, String type, int size) {
		return new PostgreAttr(name, type, size);
	}
	public IPrimaryKey generatePrimaryKey(String tb, String name, String type) {
		return new PostgrePrimaryKey(tb, name, type);
	}

	public IForeignKey generateForeignKey(String tb, String name, String tabelaRef, String atributoRef) {
		return new PostgreForeignKey(tb, name, tabelaRef, atributoRef);
	}

}
