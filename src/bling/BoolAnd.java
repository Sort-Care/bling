package bling;

public class BoolAnd extends BoolBinOp {

	protected BoolAnd(Expr lhs, Expr rhs) {
		super(lhs, rhs);
	}

	protected BoolValue compute(Expr l, Expr r) {
		Boolean b = ((BoolValue)l.evaluate()).value && ((BoolValue)r.evaluate()).value;
		return BoolValue.getBoolValue(b);
	}
}
