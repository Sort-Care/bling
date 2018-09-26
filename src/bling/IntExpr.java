package bling;

public abstract class IntExpr implements Expr {

	@Override
	public Type type() {
		return Type.INT;
	}
	
	/**
	 * Refining the return type of our IntExpr.value()
	 */
	public abstract IntValue evaluate();
}
