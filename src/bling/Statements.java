package bling;
import java.util.List;
import java.util.ArrayList;

public class Statements implements ASTNode {
	List<Statement> stmts;
	
	public Statements(List<Statement> stmts) {
		this.stmts = stmts;
	}
	
	public Statements() {
		this.stmts = new ArrayList<>();
	}
	
	public Statements(Statement s) {
		(stmts = new ArrayList<>(1)).add(s);
	}
}
