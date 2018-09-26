package bling;

public class IntUMinus extends IntExpr {

	final Expr operand;
	IntValue value = null;
	
	IntUMinus(Expr operand) {
		this.operand = operand;
	}
	
	@Override
	public IntValue evaluate() {
		if (value == null) {
			if (operand.type() != Type.INT) {
                throw new RuntimeException("Expected integer");
			}
			value = new IntValue(-((IntValue)operand.evaluate()).value);
		}
		return value;
	}

}
