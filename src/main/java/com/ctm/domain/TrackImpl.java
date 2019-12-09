package com.ctm.domain;

import java.util.List;

import com.ctm.abstraction.Session;
import com.ctm.abstraction.Track;
import com.ctm.types.SessionType;

public class TrackImpl extends Track {
	
	public TrackImpl(int id) {
		super(id);
	}

	@Override
	public void scheduleTrack(List<Talk> availableTalksForTrack) {
		Session mornginSession = new SessionImpl(SessionType.MORNING);
		mornginSession.scheduleSession(availableTalksForTrack);
		
		talksInThisTrack.addAll(mornginSession.getTalksInthisSession());
		talksInThisTrack.add(getLunchEvent());
		
		Session afterNoonSession = new SessionImpl(SessionType.AFTERNOON);
		afterNoonSession.scheduleSession(availableTalksForTrack);
		
		talksInThisTrack.addAll(afterNoonSession.getTalksInthisSession());		
		talksInThisTrack.add(getNetworkingEvent());	
		
	}
	


	
}
