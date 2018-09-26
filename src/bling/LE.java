package bling;

public class LE extends RelOp {
	public LE(Expr lhs, Expr rhs) {
		super(lhs, rhs);
	}

	@Override
	protected Boolean compute(Integer l, Integer r) {
		return l <= r;
	}
}
