package interfaces;

public interface ITableFactory {
	public IAttr generateAttr(String name, String type, int size);
	public IPrimaryKey generatePrimaryKey(String tb, String name, String type);
	public IForeignKey generateForeignKey(String tb, String name, String tabelaRef, String atributoRef);
}
