/**
 * 
 */
package com.ctm;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.ctm.domain.Conference;
import com.ctm.domain.Talk;

/**
 * Main class to do conference track management. This class reads the list of talks form file and schedules the conference
 * 
 * @author Kishor
 *
 */
public class ConferenceTrackBuilder {
	
	
	public ConferenceTrackBuilder() {
	}
	
	public String buildConferenceTracks(String talksFileLocation) {
		StringBuilder response = new StringBuilder();
		File talksFile = new File(talksFileLocation);
		List<Talk> availableTalkList = null;
		try {
			TalkFileReader talkFileReader = new TalkFileReader(talksFile);
			availableTalkList = talkFileReader.getTalks();
		} catch (NumberFormatException e) {
			response.append("Error while processing talk file. "+ e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			response.append("Error while reading talk file. "+ e.getMessage());
			e.printStackTrace();
		}
		
		if(availableTalkList == null || availableTalkList.isEmpty()) {
			response.append("No talks available to schedule conference");
		} else {
			Conference conference = new Conference("ConferenceTrackManagement");
			conference.scheduleConference(availableTalkList);
			response.append(conference.printConferenceSchedule());
		}
		
		return response.toString();
		
	}
	

}
