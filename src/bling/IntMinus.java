package bling;

public class IntMinus extends IntBinOp {

	protected IntMinus(Expr lhs, Expr rhs) {
		super(lhs, rhs);
	}

	@Override
	protected Integer compute(Integer l, Integer r) {
		return l - r;
	}
}
