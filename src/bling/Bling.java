package bling;

import java.io.File;
import java.io.FileInputStream;

public class Bling {
	static boolean printAST = false;

    public static void main(String[] argv) throws Exception{
    	if (argv.length < 1) {
    		System.err.println("Usage: bling program [args...]");
    		System.exit(1);
    	}
    	int i = 0;
    	boolean parsingArgs = true;

    	while (parsingArgs) {
    		String arg = argv[i];
    		switch (arg) {
                case "--print-ast":
                    printAST = true;
                    break;
                default:
                	parsingArgs = false;
    				break;
    		}
    		++i;
    	}
    	--i; // back up the arg

    	File file = new File(argv[i++]);
    	FileInputStream fis = new FileInputStream(file);
    	byte[] data = new byte[(int) file.length()];
    	fis.read(data);
    	fis.close();
    	String sourceCode = new String(data, "UTF-8");

    	scanner s = new scanner(sourceCode);
        Parser p = new Parser(s);
        p.symbolFactory = s.sf;
        java_cup.runtime.Symbol res = p.parse();
        Program program = (Program)res.value;
        if (printAST) {
        	(new ASTPrinter()).printProgram(program);
        } else {
            updateProgramState(program, argv, i);
            program.execute();
        }
    }
    
    public static void updateProgramState(Program p, String[] args, int i) {
    	for (; i < args.length; ++i) {
    		final String arg = args[i];
    		final String argName = "ARG" + i;

    		Value value;
    		if (arg.equals("true")) {
    			value = BoolValue.getBoolValue(true);
    		} else if (arg.equals("false")) {
    			value = BoolValue.getBoolValue(false);
    		} else {
    			try {
                    value = new IntValue(Integer.parseInt(arg));
    			} catch (Exception e) {
    				value = new StringValue(arg);
    			}
    		}
    		
    		Program.state.set(argName, value);
    	}
    }

}
