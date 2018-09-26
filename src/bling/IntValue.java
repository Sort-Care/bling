package bling;

public class IntValue extends IntExpr implements Value {
	final Long value;

	public IntValue(Integer n) {
		this.value = (long)n;
	}

	public IntValue(Long n) {
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
	public Long baseValue() {
		return value;
	}

	@Override
	public String toString() {
		return value.toString();
	}
}
