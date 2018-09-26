package bling;

public class WhileLoop implements Statement {
	
	final Expr cond;
	final Statement body;
	
	public WhileLoop(Expr cond, Statement body) {
		this.cond = cond;
		this.body = body;
	}

	@Override
	public void execute() {
		while(true) {
			if (cond.type() != Type.BOOL) {
				throw new bling.exception.TypeError("while loop Conditional must be a boolean");
			}
			if (!((BoolValue)cond.evaluate()).value) {
				break;
			}
			body.execute();
		}
		
	}

}
