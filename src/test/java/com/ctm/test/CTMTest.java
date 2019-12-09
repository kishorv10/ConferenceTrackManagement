/**
 * 
 */
package com.ctm.test;

import org.junit.Assert;
import org.junit.Test;

import com.ctm.ConferenceTrackBuilder;

/**
 * @author Kishor
 *
 */
public class CTMTest {
	
	
	@Test
	public void test1_happyPath() {
		ConferenceTrackBuilder confFact = new ConferenceTrackBuilder();
		String response = confFact.buildConferenceTracks("TalkList.txt");
		System.out.println("#### TEST CASE - TALKS TO SCHEDULE #####");
		System.out.println(response);
		Assert.assertEquals(response.contains("Lunch"), Boolean.TRUE);
		Assert.assertEquals(response.contains("Networking Event"), Boolean.TRUE);
		
	}
	
	@Test
	public void test2_nodata() {
		
		ConferenceTrackBuilder confFact = new ConferenceTrackBuilder();
		System.out.println("#### TEST CASE - NO TALKS TO SCHEDULE #####");
		String response = confFact.buildConferenceTracks("NoTalkList.txt");	
		
		System.out.println(response);
		
		Assert.assertEquals(response.contains("No talks available to schedule conference"), Boolean.TRUE);
		Assert.assertEquals(response.contains("Networking Event"), Boolean.FALSE);		
	}
}
