package connbp.tree;

import antlr.CommonAST;
import antlr.Token;

public class PositionedAST extends CommonAST {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int line = 0;
    private int column = 0;
    
    public void initialize(Token tok) {
        super.initialize(tok);
        line=tok.getLine();
        column=tok.getColumn();
    }
    
    public int getLine() { 
    	return line; 
    }
    
    public int getColumn() { 
    	return column; 
    }
}
