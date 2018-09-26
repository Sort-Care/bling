package bling;

public class IntValue extends IntExpr {
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

}
