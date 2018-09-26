package bling;

public abstract class IntBinOp extends IntExpr {
	
	protected final Expr lhs;
	protected final Expr rhs;
	
	protected IntBinOp(Expr lhs, Expr rhs) {
		assert lhs != null  && rhs != null;
		this.lhs = lhs;
		this.rhs = rhs;
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
	public IntValue evaluate() {
        if (lhs.type() != Type.INT || rhs.type() != Type.INT) {
            throw new bling.exception.TypeError("Expected integer");
        }
        return new IntValue(compute(((IntValue)lhs.evaluate()).value, ((IntValue)rhs.evaluate()).value));
	}

	protected abstract Long compute(Long l, Long r);

}
