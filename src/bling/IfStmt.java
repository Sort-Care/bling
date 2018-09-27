package bling;

import bling.exception.*;

public class IfStmt implements Statement {
	final Expr cond;
	final Statement thenClause;
	final Statement elseClause;
	
	public IfStmt(Expr cond, Statement thenClause, Statement elseClause) {
		this.cond = cond;
		this.thenClause = thenClause;
		this.elseClause = elseClause;
	}
	
	@Override
	public void execute() {
		if (cond.type() != Type.BOOL) {
			throw new TypeError("If conditions must be booleans");
		}
		if (((BoolValue)cond.evaluate()).value) {
			thenClause.execute();
		} else {
			if (elseClause != null) {
				elseClause.execute();
			}
		}
	}

	@Override
	public void accept(ASTVisitor visitor) {
		visitor.visitIfStmt(this);
	}

}
