package bling;

public class IntDivide extends IntBinOp {

	protected IntDivide(Expr lhs, Expr rhs) {
		super(lhs, rhs);
	}

	@Override
	protected Integer compute(Integer l, Integer r) {
		return l / r;
	}
}
