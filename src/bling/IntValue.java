package bling;

public class IntValue extends IntExpr implements Value {
	final Integer value;

	public IntValue(Integer n) {
		this.value = n;
	}

	@Override
	public IntValue evaluate() {
		return this;
	}
	
	public boolean equals(Object other) {
		if (other instanceof IntValue) {
			return value.equals(((IntValue)other).value);
		}
		return false;
	}
	
	@Override
	public Integer baseValue() {
		return value;
	}

	@Override
	public String toString() {
		return value.toString();
	}
}
