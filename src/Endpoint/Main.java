package Endpoint;

import java.sql.SQLException;

import IDataBaseFactory.DataBaseFactory;
import IDatabase.IDatabase;
import ITable.ITable;
import MultiDBManager.QueryBuilder;

public class Main {

	public static void main(String[] args) throws SQLException {
		DataBaseFactory sqlS = QueryBuilder.getInstance().initQuery();
		IDatabase db = sqlS.createDatabase("teste", "");
		ITable tb = db.createTable("tabela")
			.createAttr("Nome", "varchar", 255)
			.createAttr("id", "int", 8)
			.createPrimaryKey("id");
		ITable tb2 = db.createTable("tabela2")
			.createAttr("Email", "varchar", 255)
			.createAttr("id", "int", 8)
			.createPrimaryKey("id");
		tb.createForeignKey("id", "tabela2", "id");
		tb2.createAttr("Telefone", "varchar", 14);
		IDatabase db2 = sqlS.createDatabase("teste2", "");
		ITable tb3 = db2.createTable("tabela2")
				.createAttr("Email", "varchar", 255)
				.createAttr("id", "int", 8)
				.createPrimaryKey("id");
		tb3.createAttr("Nome", "varchar", 255);
		IDatabase db3 = sqlS.createDatabase("teste3", "");
		
		QueryBuilder.getInstance().run();
	}

}
