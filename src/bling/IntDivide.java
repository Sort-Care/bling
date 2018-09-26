package bling;

public class IntDivide extends IntBinOp {

	protected IntDivide(Expr lhs, Expr rhs) {
		super(lhs, rhs);
	}

	@Override
	protected Long compute(Long l, Long r) {
		return l / r;
	}
}
