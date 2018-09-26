package bling;

public class IntTimes extends IntBinOp {

	protected IntTimes(IntExpr lhs, IntExpr rhs) {
		super(lhs, rhs);
	}

	@Override
	protected Integer compute(Integer l, Integer r) {
		return l * r;
	}
}
