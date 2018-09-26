package bling;

public class Not extends BoolExpr {

	final BoolExpr operand;
	BoolValue value = null;

	public Not(BoolExpr operand) {
		this.operand = operand;
	}

	@Override
	public BoolValue evaluate() {
		if (value == null) {
            if (operand.type() != Type.BOOL) {
                throw new RuntimeException("Expected boolean");
            }
			value = BoolValue.getBoolValue(!operand.evaluate().value);
		}
		return value;
	}

}
