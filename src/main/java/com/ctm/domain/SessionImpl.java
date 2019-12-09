/**
 * 
 */
package com.ctm.domain;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import com.ctm.abstraction.Session;
import com.ctm.types.SessionType;
import com.ctm.types.TalkScheduledTime;

/**
 * @author Kishor
 *
 */
public class SessionImpl extends Session {
	
	public SessionImpl(SessionType type) {
		super(type);		
	}

	/**
	 * Available Talks are sorted in descending order. Talks are assigned into session based on the available
	 * session duration. Once a talk is selected for any session then it is removed from the the availabletalks list
	 */
	public List<Talk> scheduleSession(List<Talk> availableTalks) {		
		Collections.sort(availableTalks);		
		int sessionMaxDuration = this.sessionType.getMaxDuration();
		int sessionDuration = 0;
		
		Iterator<Talk> talkIterator = availableTalks.iterator();
		
		while(talkIterator.hasNext() && sessionDuration <= sessionMaxDuration) {			
			Talk currentTalk = talkIterator.next();
			// Check if current talk duration exceeds the remaining session duration 
			if(sessionDuration + currentTalk.getDuration() <= sessionMaxDuration) {
				TalkScheduledTime startTime = new TalkScheduledTime(sessionType.getSessionStartHour(), sessionDuration);			
				sessionDuration = sessionDuration + currentTalk.getDuration();
				TalkScheduledTime endTime = new TalkScheduledTime(sessionType.getSessionStartHour(),  sessionDuration);
				currentTalk.setStartTime(startTime);
				currentTalk.setEndTime(endTime);			
				talksInSession.add(currentTalk);
				talkIterator.remove();
			}			
		}		
		
		return talksInSession;
	}

}
