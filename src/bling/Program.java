package bling;

/**
 * Represents the entirety of the program. This is the top level parse
 * object. It consists of a list of statements and a global state. To
 * keep APIs simple we mark the state {@code static} so that a simple
 * reference to {@code Program.state} will suffice for any of our stateful
 * ops. This, of course, isn't a scalable solution; you should not use
 * Bling in production-level software.
 * 
 * @author ben
 *
 */
public class Program implements ASTNode {

	public static State state = new State();
	public Statements stmts;
	
	public Program(Statements stmts) {
		this.stmts = stmts;
	}
	
	public void execute() {
		stmts.execute();
	}

}
