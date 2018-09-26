package bling;

/**
 * To make our type system a little nicer we create the Value type. This
 * allows us to specify that certain operations must return a <em>value</em>
 * rather than an unevaluated expression.
 * 
 * The interface could be enriched but this isn't necessary.
 * 
 * This is a little kludgy, so I will note explicitly that any class implementing
 * Value must be an Expr. In particular, all Values have types, but this typing
 * data is derived from the Expr typing data. The kludgyness comes from
 * a multiple inheritance issue. There is probably an elegant solution but
 * I couldn't find it in the five minutes I thought about it :D
 * 
 * @author ben
 */
public interface Value {
	/**
	 * Get the java-construct that we are using to represent our value. Note that
	 * when this method is implemented we should use type covariance to refine
	 * the return type (i.e., IntValue.baseValue will have return type Integer,
	 * etc).
	 * @return
	 */
	Object baseValue();
}
