package interfaces;

public class IAttr {
	private String name;
	private String type;
	private int size;
	private ITable tb;
	private boolean unique=false;
	private boolean notnull=false;
	private boolean defaultProp=false;
	private String defaultvalue;
	public String toCreateLog() {
		return null;
	}
	public IAttr unique() {
		this.unique=true;
		return this;
	}
	public IAttr notnull() {
		this.notnull=true;
		return this;
	}
	public IAttr defaultProp(String defaultprop) {
		this.defaultProp=true;
		this.defaultvalue=defaultprop;
		return this;
	}
	public IAttr(String name, String type, int size) {
		this.name=name;
		this.type=type==null?"int":type;
		this.size=size;
	}
	public IAttr(String name, String type, int size, ITable tb, boolean unique, boolean notnull,boolean defaultProp,String defaultvalue) {
		this.name=name;
		this.type=type==null?"int":type;
		this.size=size;
		this.tb = tb;
		this.unique=unique;
		this.notnull=notnull;
		this.defaultProp = defaultProp;
		this.defaultvalue = defaultvalue;
	}
	public String getName() {
		return name;
	}
	public String getType() {
		return type;
	}
	public int getSize() {
		return size;
	}
	public ITable getTb() {
		return tb;
	}
	public void setTb(ITable tb) {
		this.tb = tb;
	}
	public boolean isUnique() {
		return unique;
	}
	public void setUnique(boolean unique) {
		this.unique = unique;
	}
	public boolean isNotnull() {
		return notnull;
	}
	public void setNotnull(boolean notnull) {
		this.notnull = notnull;
	}
	public boolean isDefaultProp() {
		return defaultProp;
	}
	public void setDefaultProp(boolean defaultProp) {
		this.defaultProp = defaultProp;
	}
	public String getDefaultvalue() {
		return defaultvalue;
	}
	public void setDefaultvalue(String defaultvalue) {
		this.defaultvalue = defaultvalue;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public String toString() {
		return "IAttr [name=" + name + ", type=" + type + ", size=" + size + ", tb=" + tb + "]";
	}
	public IAttr integer(int size) {
		this.type="int";
		this.size=size;
		
		return this;
	}
	public IAttr varchar(int size) {
		this.type="varchar";
		this.size=size;
		
		return this;
	}
	public IAttr date() {
		this.type="DATE";
		this.size=0;
		
		return this;
	}
}
