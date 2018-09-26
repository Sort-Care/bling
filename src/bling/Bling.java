package bling;

import java.io.File;
import java.io.FileInputStream;

public class Bling {

    public static void main(String[] argv) throws Exception{
    	if (argv.length < 1) {
    		System.err.println("Usage: bling program [args...]");
    		System.exit(1);
    	}

    	File file = new File(argv[0]);
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
        updateProgramState(program, argv);
        program.execute();
    }
    
    public static void updateProgramState(Program p, String[] args) {
    	// Skip the first argument, it's the program name
    	for (int i = 1; i < args.length; ++i) {
    		final String arg = args[i];
    		final String argName = "ARG" + i;

    		Value value;
    		if (arg.equals("true")) {
    			value = BoolValue.getBoolValue(true);
    		} else if (arg.equals("false")) {
    			value = BoolValue.getBoolValue(false);
    		} else {
    			value = new IntValue(Integer.parseInt(arg));
    		}
    		
    		Program.state.set(argName, value);
    	}
    }

}
