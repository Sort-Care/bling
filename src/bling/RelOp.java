package bling;

public abstract class RelOp extends BoolExpr {

	protected final Expr lhs;
	protected final Expr rhs;
	
	protected RelOp(Expr lhs, Expr rhs) {
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
	public BoolValue evaluate() {
        if (lhs.type() != Type.INT || rhs.type() != Type.INT) {
            throw new RuntimeException("Expected integer");
        }
        Boolean b = compute(((IntValue)lhs.evaluate()).value, 
                             ((IntValue)rhs.evaluate()).value );
        return  BoolValue.getBoolValue(b);
	}
	
	protected abstract Boolean compute(Long l, Long r);

}
