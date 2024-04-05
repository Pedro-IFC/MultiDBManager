package Endpoint;

import java.sql.SQLException;

import IDataBaseFactory.DataBaseFactory;
import MultiDBManager.QueryBuilder;

public class Main {

	public static void main(String[] args) throws SQLException {
		DataBaseFactory sqlS = QueryBuilder.getInstance().initQuery();
		sqlS.createDatabase("teste", "teste")
		.createTable("tabela")
		.createAttr("Nome", "varchar", 255)
		.createAttr("id", "int", 8)
		.createPrimaryKey("id");
		
		sqlS.createDatabase("teste2", "teste2");
		QueryBuilder.getInstance().run();
	}

}
