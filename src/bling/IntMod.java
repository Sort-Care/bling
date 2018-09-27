package bling;

public class IntMod extends IntBinOp {

	public IntMod(Expr lhs, Expr rhs) {
		super(lhs, rhs);
	}

	@Override
	protected Long compute(Long l, Long r) {
		return l % r;
	}

	@Override
	public void accept(ASTVisitor visitor) {
		visitor.visitIntMod(this);
	}

}
