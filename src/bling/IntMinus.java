package bling;

public class IntMinus extends IntBinOp {

	protected IntMinus(Expr lhs, Expr rhs) {
		super(lhs, rhs);
	}

	@Override
	protected Long compute(Long l, Long r) {
		return l - r;
	}
}
