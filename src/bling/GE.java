package bling;
public class GE extends RelOp {

	public GE(IntExpr lhs, IntExpr rhs) {
		super(lhs, rhs);
	}

	@Override
	protected Boolean compute(Integer l, Integer r) {
		return l >= r;
	}
}