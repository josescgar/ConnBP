package connbp.exceptions;

public class ConnBPSemanticException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message; 
	
	public ConnBPSemanticException(){
		super();
	}
	
	public ConnBPSemanticException(String m){
		super(m);
		this.message = m;
	}

	public void printException() {
		System.err.println(message);
	}
}
