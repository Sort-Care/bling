package bling;

public abstract class BoolBinOp extends BoolExpr {
	protected final Expr lhs;
	protected final Expr rhs;
	protected BoolValue value;
	
	protected BoolBinOp(Expr lhs, Expr rhs) {
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
            if (lhs.type() != Type.BOOL) {
                throw new RuntimeException("Expected boolean");
            }
            if (rhs.type() != Type.BOOL) {
                throw new RuntimeException("Expected boolean");
            }
            value = compute(lhs, rhs);
		}
		return value;
	}
	
	/**
	 * Note that we have to allow for arbitrary Exprs to accommodate ParenExprs
	 * which may be either BoolExprs or IntExprs.
	 * 
	 * We assume that this is only ever accessed by evaluate() and that types
	 * have been checked. Therefore, when implementing this method, we can
	 * safely cast the result of l.evaluate().value and r.evaluate().value
	 * to BoolValues.
	 * 
	 * @param l
	 * @param r
	 * @return
	 */
	protected abstract BoolValue compute(Expr l, Expr r);
}
