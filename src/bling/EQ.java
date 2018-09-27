package bling;

public class EQ extends BoolExpr {
	
	protected final Expr lhs;
	protected final Expr rhs;
	
	protected EQ(Expr lhs, Expr rhs) {
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


	public BoolValue evaluate() {
        return BoolValue.getBoolValue(lhs.evaluate().equals(rhs.evaluate()));
	}

	@Override
	public void accept(ASTVisitor visitor) {
		visitor.visitEQ(this);
	}
}
