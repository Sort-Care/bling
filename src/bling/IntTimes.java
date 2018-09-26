package bling;

public class IntTimes extends IntBinOp {

	protected IntTimes(Expr lhs, Expr rhs) {
		super(lhs, rhs);
	}

	@Override
	protected Long compute(Long l, Long r) {
		return l * r;
	}
}
