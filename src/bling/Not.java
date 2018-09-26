package bling;

public class Not extends BoolExpr {

	final Expr operand;

	public Not(Expr operand) {
		this.operand = operand;
	}

	@Override
	public BoolValue evaluate() {
        if (operand.type() != Type.BOOL) {
            throw new RuntimeException("Expected boolean");
        }
        return  BoolValue.getBoolValue(!((BoolValue)operand.evaluate()).value);
	}

}
