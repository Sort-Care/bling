package bling;

public class IdExpr implements Expr {
	Id id;
	
	public IdExpr(Id id) {
		this.id = id;
	}
	
	@Override
	public Type type() {
		// Recall that all values are exprs, which we enforce through discipline
		// in our code (the Java type system doesn't enforce this, so we must).
		// Therefore the following cast is legal.
		return ((Expr)Program.state.get(id)).type();
	}

	@Override
	public Value evaluate() {
		// TODO Auto-generated method stub
		return null;
	}
}
