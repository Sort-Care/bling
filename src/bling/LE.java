package bling;

public class LE extends RelOp {
	public LE(Expr lhs, Expr rhs) {
		super(lhs, rhs);
	}

	@Override
	protected Boolean compute(Long l, Long r) {
		return l <= r;
	}

	@Override
	public void accept(ASTVisitor visitor) {
		visitor.visitLE(this);
		
	}
}
