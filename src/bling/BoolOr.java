package bling;

public class BoolOr extends BoolBinOp {

	protected BoolOr(BoolExpr lhs, BoolExpr rhs) {
		super(lhs, rhs);
	}

	protected BoolValue compute(Expr l, Expr r) {
		Boolean b = ((BoolValue)l.evaluate()).value || ((BoolValue)r.evaluate()).value;
		return BoolValue.getBoolValue(b);
	}
}