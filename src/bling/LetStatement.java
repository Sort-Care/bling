package bling;

/**
 * Statement of the form
 * <pre>
 *     let id = expr;
 * </pre>
 * 
 * This updates the programs global state.
 * @author ben
 *
 */
public class LetStatement implements Statement {
	
	final Id id;
	final Expr expr;
	
	public LetStatement(Id id, Expr expr) {
		this.id = id;
		this.expr = expr;
	}
	
	@Override
	public void execute() {
		Program.state.set(id, expr.evaluate());
	}

	@Override
	public void accept(ASTVisitor visitor) {
		visitor.visitLetStmt(this);
	}


}
