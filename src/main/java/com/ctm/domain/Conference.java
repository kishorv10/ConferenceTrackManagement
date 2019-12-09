/**
 * 
 */
package com.ctm.domain;

import java.util.ArrayList;
import java.util.List;

import com.ctm.abstraction.Track;

/**
 * Conference contains list of tracks. All the available talks are scheduled into list of tracks
 * 
 * @author Kishor
 *
 */
public class Conference {
	
	private String name;
	private List<Track> tracks;
	
	public Conference(String name) {
		this.name = name;
		tracks = new ArrayList<Track>();
	}
	
	public List<Track> scheduleConference(List<Talk> availableTalks) {
		int trackCount = 1;
		while(!availableTalks.isEmpty()) {
			Track track = new TrackImpl(trackCount++);
			track.scheduleTrack(availableTalks);
			tracks.add(track);
		}
		return tracks;
	}

	public String getName() {
		return name;
	}
	
	public String printConferenceSchedule() {
		StringBuilder response = new StringBuilder();
		response.append("=========== " + name + " ===========\n");
		for(Track t : tracks) {			
			response.append(t.printTrack());
		}
		
		return response.toString();
	}

	
}
