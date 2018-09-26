package bling;

public abstract class BoolExpr implements Expr {

	@Override
	public Type type() {
		return Type.BOOL;
	}
	
	@Override
	public abstract BoolValue evaluate();
}
