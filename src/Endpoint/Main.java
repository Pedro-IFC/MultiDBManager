package Endpoint;

import java.sql.SQLException;

import IDataBaseFactory.DataBaseFactory;
import MultiDBManager.QueryBuilder;

public class Main {

	public static void main(String[] args) throws SQLException {
		DataBaseFactory sqlS = QueryBuilder.getInstance().initQuery();
		sqlS.createDatabase("teste", "teste");
		QueryBuilder.getInstance().run();
	}

}
