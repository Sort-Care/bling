package bling;

public class Id implements ASTNode {
	public final String name;
	
	public Id(String name) {
		this.name = name;
	}

	@Override
	public void accept(ASTVisitor visitor) {
		visitor.visitId(this);
		
	}
}
