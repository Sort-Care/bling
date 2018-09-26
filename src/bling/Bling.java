package bling;

import java.io.File;
import java.io.FileInputStream;

public class Bling {

    public static void main(String[] argv) throws Exception{
    	if (argv.length != 1) {
    		System.err.println("Usage: bling program");
    		System.exit(1);
    	}

    	File file = new File(argv[0]);
    	FileInputStream fis = new FileInputStream(file);
    	byte[] data = new byte[(int) file.length()];
    	fis.read(data);
    	fis.close();
    	String program = new String(data, "UTF-8");

    	scanner s = new scanner(program);
        Parser p = new Parser(s);
        p.symbolFactory = s.sf;
        Object ast = p.parse().value;
        System.out.println(ast);
    }

}
