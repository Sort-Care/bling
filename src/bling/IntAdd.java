package bling;

public class IntAdd extends IntBinOp {

	public IntAdd(Expr lhs, Expr rhs) {
		super(lhs, rhs);
	}

	@Override
	protected Integer compute(Integer l, Integer r) {
		return l + r;
	}
}
