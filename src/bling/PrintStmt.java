package bling;

public class PrintStmt implements Statement {

	Expr expr;

	PrintStmt(Expr expr) {
		this.expr = expr;
	}

	@Override
	public void execute() {
		System.out.println(expr.evaluate());
	}

	@Override
	public void accept(ASTVisitor visitor) {
        visitor.visitPrintStmt(this);
	}

}
