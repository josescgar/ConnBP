package connbp.exceptions;

public class ConnBPConnectionException extends Exception{
	private static final long serialVersionUID = 1L;
	private String header;
	private String message; 
	
	public ConnBPConnectionException(){
		super();
	}
	
	public ConnBPConnectionException(String m){
		super(m);
		this.message = m;
		this.header="The following semantic errors have been detected in the CONNECTIONS section:\n";
		this.header+="============================================================================\n";
	}

	public void printException() {
		System.err.println(header+message);
	}
}
