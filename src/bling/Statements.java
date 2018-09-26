package bling;
import java.util.List;
import java.util.ArrayList;

public class Statements implements ASTNode {
	List<Statement> stmts;
	
	public Statements() {
		this.stmts = new ArrayList<>();
	}
	
	public void add(Statement s) {
		stmts.add(s);
	}
}
