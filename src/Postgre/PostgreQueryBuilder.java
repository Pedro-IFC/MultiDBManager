package Postgre;

import java.sql.SQLException;

import interfaces.DataBaseFactory;
import interfaces.QueryBuilder;

public class PostgreQueryBuilder implements QueryBuilder{
	private DataBaseFactory dbfac;
	public PostgreQueryBuilder(String host, String port, String user, String pass) {
		this.dbfac = new PostgreDatabaseFactory(host, port, user, pass);
	}
	public DataBaseFactory initQuery() {
		return dbfac;
	}
	public void run() throws SQLException {
		dbfac.toRun();
	}
	public void delete() throws SQLException {
		dbfac.down();
	}
	public String getString() {
		return dbfac.getString();
	}
}
