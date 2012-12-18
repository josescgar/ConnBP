package connbp.exceptions;

public class ConnBPQuerySemanticException extends Exception {
	private static final long serialVersionUID = 1L;
	private String header;
	private String message; 
	
	public ConnBPQuerySemanticException(){
		super();
	}
	
	public ConnBPQuerySemanticException(String m){
		super(m);
		this.message = m;
		this.header="The following semantic errors have been detected in the QUERIES section\n";
		this.header+="=======================================================================\n";
	}

	public void printException() {
		System.err.println(header+message);
	}
}
