package bling;

public interface ASTNode {
	void accept(ASTVisitor visitor);
}
