package bling;
public class GE extends RelOp {

	public GE(Expr lhs, Expr rhs) {
		super(lhs, rhs);
	}

	@Override
	protected Boolean compute(Integer l, Integer r) {
		return l >= r;
	}
}