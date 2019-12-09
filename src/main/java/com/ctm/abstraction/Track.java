package com.ctm.abstraction;

import java.util.ArrayList;
import java.util.List;

import com.ctm.CTMUtils;
import com.ctm.domain.Talk;
import com.ctm.types.TalkScheduledTime;

/**
 * An abstract implementation of Track. 
 * Track contains morning session and afternoon session along with lunch break and networking event
 * 
 * @author Kishor
 *
 */
public abstract class Track {
	protected int trackId;
	protected List<Talk> talksInThisTrack;
	
	protected static final String LUNCH_TALK = "Lunch";
	protected static final String NETWORKING_EVENT = "Networking Event";
	protected static final int  LUNCH_DURATION = 60;
	protected static final int  NETWROKING_EVENT_DURATION = 60;
	protected static final int  LUNCH_START_TIME_HR = 12; 
	protected static final int  LUNCH_START_TIME_MIN = 0;
	protected static final int  LUNCH_END_TIME_HR = 13; 
	protected static final int  LUNCH_END_TIME_MIN = 0;
	protected static final int  NETWROKING_EVENT_START_TIME_HR = 17;
	protected static final int  NETWROKING_EVENT_START_TIME_MIN = 0;
	
	
	
	public Track(int id) {
		this.trackId = id;
		talksInThisTrack = new ArrayList<Talk>();
	}
	
	public String printTrack() {
		StringBuilder response = new StringBuilder();
		response.append("======== Track " + trackId + "==========\n");
		CTMUtils.printTalks(response, talksInThisTrack);
		return response.toString();
	}
	
	protected Talk getLunchEvent() {
		Talk lunchTalk = new Talk(LUNCH_TALK, LUNCH_DURATION);
		TalkScheduledTime startTime = new TalkScheduledTime(LUNCH_START_TIME_HR, LUNCH_END_TIME_MIN);
		
		lunchTalk.setStartTime(startTime);
		
		TalkScheduledTime endTime = new TalkScheduledTime(LUNCH_END_TIME_HR, LUNCH_END_TIME_MIN);
		lunchTalk.setEndTime(endTime);
		
		return lunchTalk;
	}
	
	protected Talk getNetworkingEvent() {
		Talk networkingEvent = new Talk(NETWORKING_EVENT);		
		
		networkingEvent.setStartTime(new TalkScheduledTime(NETWROKING_EVENT_START_TIME_HR, NETWROKING_EVENT_START_TIME_MIN));
		
		return networkingEvent;
	}
	
	protected Talk getNetworkingEvent(int startTimeHr, int startTimeMin) {
		Talk networkingEvent = new Talk(NETWORKING_EVENT);		
		
		networkingEvent.setStartTime(new TalkScheduledTime(startTimeHr, startTimeMin));
		
		return networkingEvent;
	}
	
	/**
	 * Schedules a available talks into a track
	 * 
	 * @param availableTalksForTrack
	 */
	public abstract void scheduleTrack(List<Talk> availableTalksForTrack);
	
	
	

}
