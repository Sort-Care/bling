package bling;

public class GT extends RelOp {
	
	public GT(IntExpr lhs, IntExpr rhs) {
		super(lhs, rhs);
	}

	@Override
	protected Boolean compute(Integer l, Integer r) {
		return l > r;
	}
}
