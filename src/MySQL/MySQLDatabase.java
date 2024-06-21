package MySQL;

import java.util.ArrayList;

import interfaces.IDatabase;
import interfaces.ITable;

public class MySQLDatabase extends IDatabase{

	public MySQLDatabase(String name, String colletion, String character) {
		super(name, colletion, character);
	}

	public ITable createTable(String name) {
		if(this.getTable()==null) {
			this.setTable(new ArrayList<ITable>());
		}
		this.getTable().add(new MySQLTable(name));
		return this.getTable().get(getTable().size()-1);
	}

	public String[] toCreateLog() {
		String[] r = {getName(), "", "", getColletion(), getCharacter()};
		if(this.getTable()!=null) {
			for(int i = 0; i<getTable().size();i++) {
				r[1]+=this.getTable().get(i).toCreateLog()[0];
				r[2]+=this.getTable().get(i).toCreateLog()[1];
			}
		}
		return r;
	}
}
