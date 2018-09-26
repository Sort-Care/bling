package bling;

public class LT extends RelOp {
	
	public LT(IntExpr lhs, IntExpr rhs) {
		super(lhs, rhs);
	}

	@Override
	protected Boolean compute(Integer l, Integer r) {
		return l < r;
	}
}
