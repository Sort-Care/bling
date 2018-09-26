package bling;
import java_cup.runtime.*;

public class scanner {

	String program;
	int idx;

	public scanner(String program) {
		this.program = program;
		idx = 0;
	}

    /* single lookahead character */
    protected int next_char;

    /* we use a SymbolFactory to generate Symbols */
    public SymbolFactory sf = new DefaultSymbolFactory();

    /* advance input by one character */
    protected void advance() throws java.io.IOException  { 
    	next_char = idx >= program.length() ? -1 : program.charAt(idx++);
    }

    /* initialize the scanner */
    public void init() throws java.io.IOException        { advance(); }

    /* recognize and return the next complete token */
    public Symbol next_token() throws java.io.IOException
    {
    for (;;)
        switch (next_char)
        {
        case '0': case '1': case '2': case '3': case '4': case '5': case '6': case '7': case '8': case '9':
            /* parse a decimal integer */
            int i_val = 0;
            do {
            i_val = i_val * 10 + (next_char - '0');
            advance();
            } while (next_char >= '0' && next_char <= '9');
            return sf.newSymbol("NUMBER",sym.NUMBER, new Integer(i_val));
        case 'a': case 'b': case 'c': case 'e': case 'd': case 'f': case 'g': case 'h': case 'i': case 'j': case 'k': case 'l': case 'm': case 'n': case 'o': case 'p': case 'q': case 'r': case 's': case 't': case 'u': case 'v': case 'w': case 'x': case 'y': case 'z': 
        case 'A': case 'B': case 'C': case 'E': case 'D': case 'F': case 'G': case 'H': case 'I': case 'J': case 'K': case 'L': case 'M': case 'N': case 'O': case 'P': case 'Q': case 'R': case 'S': case 'T': case 'U': case 'V': case 'W': case 'X': case 'Y': case 'Z':
        	/* parse a keyword or an id */
        	StringBuilder sb = new StringBuilder();
        	sb.append((char)next_char);
        	advance();

        	while (Character.isAlphabetic(next_char)) {
        		sb.append((char)next_char);
        		advance();
        	}

        	String id = sb.toString();

        	switch (id) {
                case "true":
                    return sf.newSymbol("TRUE", sym.TRUE);
                case "false":
                    return sf.newSymbol("FALSE", sym.FALSE);
                case "if":
                    return sf.newSymbol("IF", sym.IF);
                case "else":
                    return sf.newSymbol("ELSE", sym.ELSE);
                case "let":
                    return sf.newSymbol("LET", sym.LET);
                case "print":
                	return sf.newSymbol("PRINT", sym.PRINT);
                default:
                    return sf.newSymbol("ID", sym.ID, new Id(id));
        	}
        	

        case ';': advance(); return sf.newSymbol("SEMI",sym.SEMI);
        case '<': 
        	advance(); 
        	if (next_char == '=') {
        		advance();
        		return sf.newSymbol("LE",sym.LE);
        	}
        	return sf.newSymbol("LT", sym.LT);

        case '>': 
        	advance(); 
        	if (next_char == '=') {
        		advance();
        		return sf.newSymbol("LE",sym.GE);
        	}
        	return sf.newSymbol("LT", sym.GT);

        case '=': advance(); return sf.newSymbol("EQ",sym.EQ);
        case '&': advance(); return sf.newSymbol("AND",sym.AND);
        case '|': advance(); return sf.newSymbol("OR",sym.OR);
        case '!': advance(); return sf.newSymbol("NOT",sym.NOT);
        case '+': advance(); return sf.newSymbol("PLUS",sym.PLUS);
        case '-': advance(); return sf.newSymbol("MINUS",sym.MINUS);
        case '*': advance(); return sf.newSymbol("TIMES",sym.TIMES);
        case '/': advance(); return sf.newSymbol("DIVIDE",sym.DIVIDE);
        case '(': advance(); return sf.newSymbol("LPAREN",sym.LPAREN);
        case ')': advance(); return sf.newSymbol("RPAREN",sym.RPAREN);
        case '{': advance(); return sf.newSymbol("LBRACE",sym.LBRACE);
        case '}': advance(); return sf.newSymbol("RBRACE",sym.RBRACE);

        case -1: return sf.newSymbol("EOF",sym.EOF);

        default:
            /* in this simple scanner we just ignore everything else */
            advance();
            break;
        }
    }
}
