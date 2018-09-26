package bling;

public class LE extends RelOp {
	public LE(IntExpr lhs, IntExpr rhs) {
		super(lhs, rhs);
	}

	@Override
	protected Boolean compute(Integer l, Integer r) {
		return l <= r;
	}
}
