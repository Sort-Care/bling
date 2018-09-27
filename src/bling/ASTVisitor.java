package bling;

public abstract class ASTVisitor {
	void visitProgram(final Program p) {
		for (Statement s : p.stmts.stmts) {
			s.accept(this);
		}
	}
	
	void visitBlock(final Block b) {
		for (Statement s: b.stmts.stmts) {
			s.accept(this);
		}
	}
	
	void visitStatements(final Statements stmts) {
		for (Statement s: stmts.stmts) {
			s.accept(this);
		}
	}
	
	void visitAdd(final Add a) {
		a.lhs().accept(this);
		a.rhs().accept(this);
	}
	
	void visitBoolAnd(final BoolAnd b) {
		b.lhs().accept(this);
		b.rhs().accept(this);
	}

	void visitBoolOr(final BoolOr b) {
		b.lhs().accept(this);
		b.rhs().accept(this);
	}

	void visitBoolValue(final BoolValue b) {}
	
	void visitEQ(final EQ op) {
		op.lhs().accept(this);
		op.rhs().accept(this);
	}

	void visitGE(final GE op) {
		op.lhs().accept(this);
		op.rhs().accept(this);
	}

	void visitGT(final GT op) {
		op.lhs().accept(this);
		op.rhs().accept(this);
	}

	void visitLE(final LE op) {
		op.lhs().accept(this);
		op.rhs().accept(this);
	}

	void visitLT(final LT op) {
		op.lhs().accept(this);
		op.rhs().accept(this);
	}
	
	void visitIdExpr(final IdExpr id) {
		id.id.accept(this);
	}

	void visitId(final Id id) {}
	
	void visitIfStmt(final IfStmt s) {
		s.cond.accept(this);
		s.thenClause.accept(this);
		if (s.elseClause != null) {
			s.elseClause.accept(this);
		}
	}
	
	void visitIntDivide(final IntDivide d) {
		d.lhs().accept(this);
		d.rhs().accept(this);
	}
	
	
	void visitIntMinus(final IntMinus m) {
		m.lhs().accept(this);
		m.rhs().accept(this);
	}
	
	
	void visitIntMod(final IntMod m) {
		m.lhs().accept(this);
		m.rhs().accept(this);
	}
	
	
	void visitIntTimes(final IntTimes t) {
		t.lhs().accept(this);
		t.rhs().accept(this);
	}
	
	void visitIntValue(final IntValue v) {}
	
	void visitLetStmt(final LetStatement s) {
		s.expr.accept(this);
		s.id.accept(this);
	}
	
	void visitNeg(final Neg n) {
		n.expr.accept(this);
	}
	
	void visitNot(final Not n) {
		n.operand.accept(this);
	}
	
	void visitParenExpr(final ParenExpr p) {
		p.expr.accept(this);
	}
	
	void visitPrintStmt(final PrintStmt s) {
		s.expr.accept(this);
	}
	
	void visitStringValue(final StringValue s) { }
	
	void visitWhileLoop(final WhileLoop l) {
		l.cond.accept(this);
		l.body.accept(this);
	}
	
}
