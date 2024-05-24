package interfaces;

public final class IInteger extends IAttr {
	public static IInteger create(String name, int size) {
		return new IInteger(name, size);
	}
	private IInteger(String name, int size) {
		super(name, "int", size);
	}
	public String toCreateLog() {
		return null;
	}
}
