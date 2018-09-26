package bling;

public class GT extends RelOp {
	
	public GT(Expr lhs, Expr rhs) {
		super(lhs, rhs);
	}

	@Override
	protected Boolean compute(Integer l, Integer r) {
		return l > r;
	}
}
