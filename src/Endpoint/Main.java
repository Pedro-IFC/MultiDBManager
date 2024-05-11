package Endpoint;

import java.sql.SQLException;

import IAttr.IAttr;
import IAttr.MysqlInteger;
import IDataBaseFactory.DataBaseFactory;
import IDatabase.IDatabase;
import IPrimaryKey.IPrimaryKey;
import ITable.ITable;
import MultiDBManager.QueryBuilder;

public class Main {

	public static void main(String[] args) throws SQLException {
		DataBaseFactory sqlS = QueryBuilder.getInstance().initQuery();
		
		IDatabase db = sqlS.createDatabase("teste", "");
		
		ITable tb = db.createTable("tabela");
		tb.createAttr(MysqlInteger.create("Nome", 0));
		IAttr id = tb.createAttr(MysqlInteger.create("id", 0));
		tb.createAttr(MysqlInteger.create("s", 0));
		IPrimaryKey p = tb.createPrimaryKey(id);
		
		ITable tb2 = db.createTable("tabela2");
		IAttr id2 = MysqlInteger.create("id", 0);
		tb2.createPrimaryKey(id2);
			
		tb2.createForeignKey(p, id2);
		
		tb2.createAttr(MysqlInteger.create("Telefone", 0));

		QueryBuilder.getInstance().delete();
		QueryBuilder.getInstance().run();
	}

}
