package bling;

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
		throw new RuntimeException("Not Implemented");
	}

}
