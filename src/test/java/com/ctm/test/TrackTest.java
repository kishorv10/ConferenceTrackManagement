package com.ctm.test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.ctm.CTMUtils;
import com.ctm.domain.Talk;
import com.ctm.domain.TrackImpl;

public class TrackTest {
	
	public static final String LIGHTNING = "lightning";
	
	public void testTrack_HappyPath() throws NumberFormatException, IOException {
		TrackImpl t = new TrackImpl(1);
		List<Talk> availableTalks = CTMUtils.getTalksFromFile(new File("TalkList.txt")); 
		t.scheduleTrack(availableTalks);		
		System.out.println(t.printTrack());
		System.out.println("after 1st track");

		TrackImpl t1 = new TrackImpl(2);
		 
		t1.scheduleTrack(availableTalks);		
		t1.printTrack();
		
	}	

}
