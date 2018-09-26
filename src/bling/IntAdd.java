package bling;

public class IntAdd extends IntBinOp {

	public IntAdd(Expr lhs, Expr rhs) {
		super(lhs, rhs);
	}

	@Override
	protected Long compute(Long l, Long r) {
		return l + r;
	}
}
