package bling;

public abstract class RelOp extends BoolExpr {

	protected final Expr lhs;
	protected final Expr rhs;
	protected BoolValue value;
	
	protected RelOp(Expr lhs, Expr rhs) {
		this.lhs = lhs;
		this.rhs = rhs;
		value = null;
	}

	/**
	 * Return the left operand of this binop expr
	 * @return
	 */
	public Expr lhs() {
		return lhs;
	}

	/**
	 * Return the right operand of this binop expr
	 * @return
	 */
	public Expr rhs() {
		return rhs;
	}


	@Override
	public BoolValue evaluate() {
		if (value == null) {
            if (lhs.type() != Type.INT || rhs.type() != Type.INT) {
                throw new RuntimeException("Expected integer");
            }
            Boolean b = compute(((IntValue)lhs.evaluate()).value, 
            				     ((IntValue)rhs.evaluate()).value );
            value = BoolValue.getBoolValue(b);
		}
		return value;
	}
	
	protected abstract Boolean compute(Integer l, Integer r);

}
