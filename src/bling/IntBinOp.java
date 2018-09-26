package bling;

public abstract class IntBinOp extends IntExpr {
	
	protected final IntExpr lhs;
	protected final IntExpr rhs;
	protected IntValue value;
	
	protected IntBinOp(IntExpr lhs, IntExpr rhs) {
		this.lhs = lhs;
		this.rhs = rhs;
		value = null;
	}

	/**
	 * Return the left operand of this binop expr
	 * @return
	 */
	public IntExpr lhs() {
		return lhs;
	}

	/**
	 * Return the right operand of this binop expr
	 * @return
	 */
	public IntExpr rhs() {
		return rhs;
	}


	@Override
	public IntValue evaluate() {
		if (value == null) {
            if (lhs.type() != Type.INT || rhs.type() != Type.INT) {
                throw new RuntimeException("Expected integer");
            }
            value = new IntValue(compute(((IntValue)lhs.evaluate()).value, ((IntValue)rhs).value));
		}
		return value;
	}

	protected abstract Integer compute(Integer l, Integer r);

}
