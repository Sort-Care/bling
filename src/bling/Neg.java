package bling;

public class Neg extends IntExpr {
	public Expr expr;

	public Neg(Expr e) {
		this.expr = e;
	}

	@Override
	public IntValue evaluate() {
		if (expr.type() != Type.INT) {
            throw new bling.exception.TypeError("Expected integer");
		}
		return new IntValue(-((IntValue)expr.evaluate()).value);
	}

}
