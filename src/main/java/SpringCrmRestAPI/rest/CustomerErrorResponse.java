package SpringCrmRestAPI.rest;

public class CustomerErrorResponse {
	
	private int status;
	private String messege;
	private long timeStamp;
	
	
	public CustomerErrorResponse() {
		
	}
	
	public CustomerErrorResponse(int theStatus, String theMessege, long theTimeStamp) {
		this.status = theStatus;
		this.messege = theMessege;
		this.timeStamp = theTimeStamp;
		
	}
	
	public int getStatus() {
		return this.status;
	}
	
	public void setStatus(int theStatus) {
		this.status = theStatus;
	}
	
	public String getMessege() {
		return messege;
	}
	
	public void setMessege(String theMessege) {
		this.messege = theMessege;
	}
	
	public long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(long theTimeStamp) {
		this.timeStamp = theTimeStamp;
	}

}
