package bling;

public class IntTimes extends IntBinOp {

	protected IntTimes(Expr lhs, Expr rhs) {
		super(lhs, rhs);
	}

	@Override
	protected Integer compute(Integer l, Integer r) {
		return l * r;
	}
}
