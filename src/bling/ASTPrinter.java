package bling;

import java.util.Collections;

public class ASTPrinter extends ASTVisitor {
	StringBuilder sb;
	int depth = 0;

	public String getNodeString(ASTNode n) {
		sb = new StringBuilder();
		depth = 0;
		n.accept(this);
		assert depth == 0;
		return sb.toString();
	}
	
	public String getProgramString(Program p) {
		return getNodeString(p);
	}
	
	public void printProgram(Program p) {
		System.out.println(getProgramString(p));
	}

	void open(String s) {
		sb.append('\n');
		sb.append(indentString());
		sb.append(s);
		++depth;
	}
	
	void close() {
		close("");
	}

	void close(String s) {
		--depth;
		sb.append(s);
		sb.append(')');
	}
	
	String indentString() {
		if (depth > 0) return String.join("", Collections.nCopies(depth, "  "));
		return "";
	}

	@Override
	void visitProgram(Program p) {
		open("(program");
		super.visitProgram(p);
		close();
		assert depth == 0;
	}

	@Override
	void visitBlock(Block b) {
		open("(block");
		super.visitBlock(b);
		close();
	}

	@Override
	void visitStatements(Statements stmts) {
		open("(stmts");
		super.visitStatements(stmts);
		close();
	}

	@Override
	void visitAdd(Add a) {
		open("(+");
		super.visitAdd(a);
		close();
	}

	@Override
	void visitBoolAnd(BoolAnd b) {
		open("(and");
		super.visitBoolAnd(b);
		close();
	}

	@Override
	void visitBoolOr(BoolOr b) {
		open("(or");
		super.visitBoolOr(b);
		close();
	}

	@Override
	void visitBoolValue(BoolValue b) {
		open(String.format("(%s", b.value));
		super.visitBoolValue(b);
		close();
	}

	@Override
	void visitEQ(EQ op) {
		open("(=");
		super.visitEQ(op);
		close();
	}

	@Override
	void visitGE(GE op) {
		open("(>=");
		super.visitGE(op);
		close();
	}

	@Override
	void visitGT(GT op) {
		open("(>");
		super.visitGT(op);
		close();
	}

	@Override
	void visitLE(LE op) {
		open("(<=");
		super.visitLE(op);
		close();
	}

	@Override
	void visitLT(LT op) {
		open("(<");
		super.visitLT(op);
		close();
	}

	@Override
	void visitIdExpr(IdExpr id) {
		open(String.format("(id-expr", id.id.name));
		super.visitIdExpr(id);
		close();
	}

	@Override
	void visitId(Id id) {
		open(String.format("(id [%s]", id.name));
		super.visitId(id);
		close();
	}

	@Override
	void visitIfStmt(IfStmt s) {
		open("(if");
		super.visitIfStmt(s);
		close();
	}

	@Override
	void visitIntDivide(IntDivide d) {
		open("/");
		super.visitIntDivide(d);
		close();
	}

	@Override
	void visitIntMinus(IntMinus m) {
		open("(-");
		super.visitIntMinus(m);
		close();
	}

	@Override
	void visitIntMod(IntMod m) {
		open("(%");
		super.visitIntMod(m);
		close();
	}

	@Override
	void visitIntTimes(IntTimes t) {
		open("(*");
		super.visitIntTimes(t);
		close();
	}

	@Override
	void visitIntValue(IntValue v) {
		open(String.format("(int [%d]", v.value));
		super.visitIntValue(v);
		close();
	}

	@Override
	void visitLetStmt(LetStatement s) {
		open("(let");
		s.id.accept(this);
		s.expr.accept(this);
		close();
	}

	@Override
	void visitNeg(Neg n) {
		open("(neg");
		super.visitNeg(n);
		close();
	}

	@Override
	void visitNot(Not n) {
		open("(not");
		super.visitNot(n);
		close();
	}

	@Override
	void visitParenExpr(ParenExpr p) {
		open("(paren-expr");
		super.visitParenExpr(p);
		close();
	}

	@Override
	void visitPrintStmt(PrintStmt s) {
		open("(print ");
		super.visitPrintStmt(s);
		close();
	}

	@Override
	void visitStringValue(StringValue s) {
		open( String.format("(string [%s]", s.value));
		super.visitStringValue(s);
		close();
	}

	@Override
	void visitWhileLoop(WhileLoop l) {
		open("(while");
		super.visitWhileLoop(l);
		close();
	}

}
