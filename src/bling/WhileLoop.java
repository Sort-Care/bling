package bling;

public class WhileLoop implements Statement {
	
	final Expr cond;
	final Expr body;
	
	public WhileLoop(Expr cond, Expr body) {
		this.cond = cond;
		this.body = body;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}

}
