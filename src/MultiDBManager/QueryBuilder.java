package MultiDBManager;

import java.sql.SQLException;

import IDataBaseFactory.DataBaseFactory;
import IDataBaseFactory.MySQLDatabaseFactory;

public class QueryBuilder {
	static QueryBuilder instance;
	private DataBaseFactory dbfac;
	private QueryBuilder() {
		setDbfac(new MySQLDatabaseFactory());
	}
	public DataBaseFactory initQuery() {
		return getDbfac();
	}
	public static QueryBuilder getInstance() {
		if(instance == null)
			instance = new QueryBuilder();
		return instance;
	}
	public void run() throws SQLException {
		getDbfac().toRun();
	}
	public void delete() throws SQLException {
		getDbfac().down();
	}
	public DataBaseFactory getDbfac() {
		return dbfac;
	}
	public void setDbfac(DataBaseFactory dbfac) {
		this.dbfac = dbfac;
	}

}
