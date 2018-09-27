package bling;

/**
 * This acts as an addition node for multiple types. INT + INT  => INT
 * STRING + T => STRING
 * T + STRING => STRING
 * anything else => ERROR
 * @author ben
 *
 */
public class Add implements Expr {
	protected final Expr lhs;
	protected final Expr rhs;
	

	public Add(Expr lhs, Expr rhs) {
		this.lhs = lhs; this.rhs = rhs;
	}

	/**
	 * Return the left operand of this binop expr
	 * @return
	 */
	public Expr lhs() {
		return lhs;
	}

	/**
	 * Return the right operand of this binop expr
	 * @return
	 */
	public Expr rhs() {
		return rhs;
	}

	@Override
	public Value evaluate() {
		Object l = lhs.evaluate().baseValue();
		Object r = rhs.evaluate().baseValue();
		
		if (lhs.type() == Type.STRING) {
			return new StringValue(compute((String)l, r));
		}
		if (rhs.type() == Type.STRING) {
			return new StringValue(compute(l, (String)r));
		}
		if (lhs.type() == Type.INT && rhs.type() == Type.INT) {
			return new IntValue(compute((Long)l, (Long)r));
		}
		throw new bling.exception.TypeError("Bad Addition node types");
		
	}

	protected Long compute(Long l, Long r) {
		return l + r;
	}
	
	protected String compute(String l, Object r) {
		return l + r.toString();
	}
	
	protected String compute(Object l, String r) {
		return l.toString() + r;
	}

	@Override
	public Type type() {
		Type ltype = lhs.type();
		if (ltype == Type.STRING) {
			return ltype;
		}
		Type rtype = rhs.type();
		if (rtype == Type.STRING) {
			return rtype;
		}
		if (ltype == Type.INT && rtype == Type.INT) {
			return ltype;
		}
		
		throw new bling.exception.TypeError("Bad Addition node types");
	}

	@Override
	public void accept(ASTVisitor visitor) {
		visitor.visitAdd(this);
	}
}
