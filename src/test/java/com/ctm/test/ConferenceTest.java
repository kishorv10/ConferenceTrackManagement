/**
 * 
 */
package com.ctm.test;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import com.ctm.CTMUtils;
import com.ctm.domain.Conference;

/**
 * @author Kishor
 *
 */
public class ConferenceTest {

	
	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	@Test
	public void testConference_happyPath() throws NumberFormatException, IOException {
		Conference c = new Conference("ConferenceTrackManagement");	
		c.scheduleConference(CTMUtils.getTalksFromFile(new File("TalkList.txt")));
		System.out.println(c.printConferenceSchedule());
	}

	
}
