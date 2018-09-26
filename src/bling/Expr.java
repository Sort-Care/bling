package bling;

public interface Expr extends ASTNode {

	/**
	 * Get the type of this Expr
	 * @return
	 */
	Type type();
	
	/**
	 * Recursively compute the value of this Expr
	 * @return
	 */
	public abstract Expr evaluate();
}
