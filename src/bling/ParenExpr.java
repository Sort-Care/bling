package bling;

public class ParenExpr implements Expr {
	
	final Expr expr;

	public ParenExpr(Expr expr) {
		this.expr = expr;
	}

	public Type type() {
		return expr.type();
	}

	@Override
	public Value evaluate() {
		return expr.evaluate();
	}

	@Override
	public void accept(ASTVisitor visitor) {
		visitor.visitParenExpr(this);
	}
}
