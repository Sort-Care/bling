package bling;

public class Block extends Statement {
	public Statements stmts;
	public Block(Statements stmts) {
		this.stmts = stmts;
	}
}
