package bling;

public class GT extends RelOp {
	
	public GT(Expr lhs, Expr rhs) {
		super(lhs, rhs);
	}

	@Override
	protected Boolean compute(Long l, Long r) {
		return l > r;
	}

	@Override
	public void accept(ASTVisitor visitor) {
		visitor.visitGT(this);
	}
}
