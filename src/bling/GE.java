package bling;
public class GE extends RelOp {

	public GE(Expr lhs, Expr rhs) {
		super(lhs, rhs);
	}

	@Override
	protected Boolean compute(Long l, Long r) {
		return l >= r;
	}
}