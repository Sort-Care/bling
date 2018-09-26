package bling;

public class Not extends BoolExpr {

	final Expr operand;
	BoolValue value = null;

	public Not(Expr operand) {
		this.operand = operand;
	}

	@Override
	public BoolValue evaluate() {
		if (value == null) {
            if (operand.type() != Type.BOOL) {
                throw new RuntimeException("Expected boolean");
            }
			value = BoolValue.getBoolValue(!((BoolValue)operand.evaluate()).value);
		}
		return value;
	}

}
