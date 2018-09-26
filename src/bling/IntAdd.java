package bling;

public class IntAdd extends IntBinOp {

	public IntAdd(IntExpr lhs, IntExpr rhs) {
		super(lhs, rhs);
	}

	@Override
	protected Integer compute(Integer l, Integer r) {
		return l + r;
	}
}
