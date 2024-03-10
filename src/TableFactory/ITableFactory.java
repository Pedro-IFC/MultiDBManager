package TableFactory;

import IAttr.IAttr;
import IForeignKey.IForeignKey;
import IPrimaryKey.IPrimaryKey;

public interface ITableFactory {
	public abstract IAttr generateAttr(String name, String type, int size);
	public abstract IPrimaryKey generatePrimaryKey(String name);
	public abstract IForeignKey generateForeignKey(String name, String tabelaRef, String atributoRef);
}
