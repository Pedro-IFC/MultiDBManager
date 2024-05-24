package interfaces;

import java.sql.SQLException;

public interface QueryBuilder {
	public DataBaseFactory initQuery();
	public void run() throws SQLException;
	public void delete() throws SQLException;
	public String getString();
}
