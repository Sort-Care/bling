package bling;

public class StringValue extends StringExpr implements Value {
	final String value;
	
	public StringValue(String value) {
		this.value = value;
	}

	@Override
	public String baseValue() {
		return value;
	}

	@Override
	public StringValue evaluate() {
		return this;
	}
	
	@Override
	public String toString() {
		return value;
	}

}
