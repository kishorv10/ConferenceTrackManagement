/**
 * 
 */
package com.ctm.abstraction;

import java.util.ArrayList;
import java.util.List;

import com.ctm.CTMUtils;
import com.ctm.domain.Talk;
import com.ctm.types.SessionType;

/**
 * An Abstract implementation of a session. Session contains list of talks with definite start time and end time. 
 * 
 * @author Kishor
 *
 */
public abstract class Session {

	protected SessionType sessionType;
	protected int sessionDuration;
	protected List<Talk> talksInSession;
	
	public Session(SessionType type) {
		this.sessionType = type;
		talksInSession = new ArrayList<Talk>();
	}
	
	/**
	 * Schedule the session with the available talks
	 * 
	 * @param availableTalksForSession
	 * @return
	 */
	public abstract List<Talk> scheduleSession(List<Talk> availableTalksForSession);
	
	/**
	 * Returns list of talks present in the session
	 * 
	 * @return
	 */
	public List<Talk> getTalksInthisSession() {
		return talksInSession;
	}
	
	/**
	 * Write the session details 
	 * 
	 * @return
	 */
	public String printSession() {
		StringBuilder response = new StringBuilder();
		return CTMUtils.printTalks(response, talksInSession);
	}


	
}
