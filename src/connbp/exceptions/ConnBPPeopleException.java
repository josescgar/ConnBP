package connbp.exceptions;

public class ConnBPPeopleException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String header;
	private String message; 
	
	public ConnBPPeopleException(){
		super();
	}
	
	public ConnBPPeopleException(String m){
		super(m);
		this.message = m;
		this.header="The following semantic errors have been detected in the PEOPLE section:\n";
		this.header+="=======================================================================\n";
	}

	public void printException() {
		System.err.println(header+message);
	}
}