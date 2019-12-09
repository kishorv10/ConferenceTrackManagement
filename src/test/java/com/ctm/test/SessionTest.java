package com.ctm.test;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import com.ctm.CTMUtils;
import com.ctm.domain.SessionImpl;
import com.ctm.types.SessionType;

public class SessionTest {
	
	public static final String LIGHTNING = "lightning";
	
	@Test
	public void testSession_HappyPath() throws NumberFormatException, IOException {
		SessionImpl s = new SessionImpl(SessionType.MORNING);
		s.scheduleSession(CTMUtils.getTalksFromFile(new File("TalkList.txt")));
		System.out.println(s.printSession());
	}
	

}
