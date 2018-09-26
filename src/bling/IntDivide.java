package bling;

public class IntDivide extends IntBinOp {

	protected IntDivide(IntExpr lhs, IntExpr rhs) {
		super(lhs, rhs);
	}

	@Override
	protected Integer compute(Integer l, Integer r) {
		return l / r;
	}
}
