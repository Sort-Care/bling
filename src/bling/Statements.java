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
	
	public void execute() {
		for (Statement s : stmts) {
			s.execute();
		}
	}

	@Override
	public void accept(ASTVisitor visitor) {
		visitor.visitStatements(this);
		
	}
}
