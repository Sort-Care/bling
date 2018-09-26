package bling;

public class BoolAnd extends BoolBinOp {

	protected BoolAnd(BoolExpr lhs, BoolExpr rhs) {
		super(lhs, rhs);
	}

	protected BoolValue compute(Expr l, Expr r) {
		Boolean b = ((BoolValue)l.evaluate()).value && ((BoolValue)r.evaluate()).value;
		return BoolValue.getBoolValue(b);
	}
}
