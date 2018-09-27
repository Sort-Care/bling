package bling;

public class Block implements Statement {
	public Statements stmts;
	public Block(Statements stmts) {
		this.stmts = stmts;
	}
	
	@Override
	public void execute() {
		for (Statement s : stmts.stmts) {
			s.execute();
		}
	}

	@Override
	public void accept(ASTVisitor visitor) {
		visitor.visitBlock(this);
	}
}
