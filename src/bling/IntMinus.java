package bling;

public class IntMinus extends IntBinOp {

	protected IntMinus(IntExpr lhs, IntExpr rhs) {
		super(lhs, rhs);
	}

	@Override
	protected Integer compute(Integer l, Integer r) {
		return l - r;
	}
}
