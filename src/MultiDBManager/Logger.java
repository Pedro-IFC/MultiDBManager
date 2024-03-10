package MultiDBManager;

public class Logger {
	private static Logger instance;
	private StringBuilder query = new StringBuilder();
	
	private Logger() {}
	
	public static Logger getInstance() {
		if(instance==null)
			instance = new Logger();
		return instance;
	}
	
	public StringBuilder getQuery() {
		return query;
	}
	public boolean add(String sql) {
		try {
			getQuery().append(sql);
			return true;
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			return false;
		}
	}
	public String commit() {
		try {
			return getQuery().toString();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			return "";
		}
	}
	
	
}
