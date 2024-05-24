package MySQL;

import java.sql.SQLException;

import interfaces.DataBaseFactory;
import interfaces.QueryBuilder;

public class MySQLQueryBuilder implements QueryBuilder{
	private DataBaseFactory dbfac;
	public MySQLQueryBuilder(String host, String port, String user, String pass) {
		this.dbfac = new MySQLDatabaseFactory(host, port, user, pass);
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
