package bling;

public class BoolValue extends BoolExpr implements Value {
	final Boolean value;
	
	public final static BoolValue TRUE  = new BoolValue(true);
	public final static BoolValue FALSE = new BoolValue(false);
	
	private BoolValue(Boolean v) {
		this.value = v;
	}

	@Override
	public BoolValue evaluate() {
		return this;
	}
	
	public static BoolValue getBoolValue(Boolean b) {
		return b ? TRUE : FALSE;
	}

	public boolean equals(Object other) {
		if (other instanceof BoolValue) {
			return value.equals(((BoolValue)other).value);
		}
		return false;
	}
	
	@Override
	public Boolean baseValue() {
		return value;
	}

	@Override
	public String toString() {
		return value.toString();
	}

	@Override
	public void accept(ASTVisitor visitor) {
		visitor.visitBoolValue(this);
	}
}
