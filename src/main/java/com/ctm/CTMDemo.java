/**
 * 
 */
package com.ctm;


/**
 * A demo class for Conference track management
 * 
 * @author Kishor
 *
 */
public class CTMDemo {
	
	public static void main(String args[]) {
		String filelocation;
		if(args.length == 0) {
			filelocation = "TalkList.txt";
		} else {
			filelocation = new String(args[0]);
		}
		
		ConferenceTrackBuilder conferenceBuilder = new ConferenceTrackBuilder();
		String conferenceScdule = conferenceBuilder.buildConferenceTracks(filelocation);
		System.out.println(conferenceScdule);
		
	}

}
