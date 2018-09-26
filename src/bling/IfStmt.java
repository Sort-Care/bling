package bling;

public class IfStmt extends Statement {
	final BoolExpr cond;
	final Statement thenClause;
	final Statement elseClause;
	
	public IfStmt(BoolExpr cond, Statement thenClause, Statement elseClause) {
		this.cond = cond;
		this.thenClause = thenClause;
		this.elseClause = elseClause;
	}

}
