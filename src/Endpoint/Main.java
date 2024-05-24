package Endpoint;

import java.sql.SQLException;

import MySQL.MySQLQueryBuilder;
import interfaces.DataBaseFactory;
import interfaces.IAttr;
import interfaces.IDatabase;
import interfaces.IInteger;
import interfaces.IPrimaryKey;
import interfaces.ITable;

public class Main {

	public static void main(String[] args) throws SQLException {
		MySQLQueryBuilder mysqlC = new MySQLQueryBuilder("localhost", "3306", "root", "");
		DataBaseFactory sqlS = mysqlC.initQuery();
		
		IDatabase db = sqlS.createDatabase("teste4", "");
		
		ITable tb = db.createTable("tabela");
		tb.createAttr(IInteger.create("Nome", 0));
		IAttr id = tb.createAttr(IInteger.create("id", 0));
		tb.createAttr(IInteger.create("s", 0));
		IPrimaryKey p = tb.createPrimaryKey(id);
		
		ITable tb2 = db.createTable("tabela2");
		IAttr id2 = IInteger.create("id", 0);
		tb2.createPrimaryKey(id2);
			
		tb2.createForeignKey(p, id2);
		
		tb2.createAttr(IInteger.create("Telefone", 0));

		mysqlC.delete();
		mysqlC.run();
		System.out.print(mysqlC.getString());
	}

}
