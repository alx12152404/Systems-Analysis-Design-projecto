package session;

import java.util.Date;
import java.util.UUID;

public class Session {
	
	private UUID sessionID;
	private Date sessionTime;
	private boolean isSessionActive;
	public Session()
	{
		UUID.randomUUID();
		this.sessionTime = new Date();
		this.isSessionActive = true;
		
	}
	
	public boolean verifySessionIntegrity()
	{
		long difference;
		Date currentTime = new Date();
		difference = currentTime.getTime() - sessionTime.getTime();
		
		if (difference < 45000)
		{
			this.sessionTime = currentTime; 
			return true;
		}
		else 
	    {
			System.out.println("SESSION TIMEOUT");
			this.isSessionActive = false;
			return false;
	    }
	}
	
	public boolean getIsSessionActive()
	{
		return this.isSessionActive;
	}
	
	public UUID getSessionID()
	{
		return this.sessionID;
	}
	

}
