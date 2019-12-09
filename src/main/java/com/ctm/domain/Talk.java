/**
 * 
 */
package com.ctm.domain;

import com.ctm.types.TalkScheduledTime;




/**
 * @author kvasant
 *
 */
public class Talk implements Comparable<Talk> {

	
	private String name;
	private int duration;
	
	private TalkScheduledTime startTime;
	private TalkScheduledTime endTime;
	
	
	public TalkScheduledTime getStartTime() {
		return startTime;
	}

	public void setStartTime(TalkScheduledTime startTime) {
		this.startTime = startTime;
	}

	public TalkScheduledTime getEndTime() {
		return endTime;
	}

	public void setEndTime(TalkScheduledTime endTime) {
		this.endTime = endTime;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public Talk(String talkName, int talkDuration) {		
		this.name = talkName;
		this.duration = talkDuration;
	}
	
	public Talk(String talkName) {		
		this.name = talkName;		
	}
	
	public int compareTo(Talk tl) {
		int compareDuration = tl.getDuration();
		return compareDuration - this.duration;		
	}
		
}
