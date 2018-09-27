package bling;

public abstract class StringExpr implements Expr {

	@Override
	public Type type() {
		return Type.STRING;
	}

	@Override
	public abstract StringValue evaluate();

}
