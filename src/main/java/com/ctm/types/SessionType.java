package com.ctm.types;

/**
 * 
 * @author Kishor
 *
 */
public enum SessionType {
	
	MORNING (180, 9, "Morning"),
	AFTERNOON (240, 13, "Afternoon");
	
	private String type;
	private int maxDuration;
	private int sessionStartHour;
	
	public String getType() {
		return type;
	}

	public int getMaxDuration() {
		return maxDuration;
	}
	
	private SessionType(int maxDuration, int startHour, String type) {
		this.type = type;
		this.maxDuration = maxDuration;
		this.sessionStartHour = startHour;
	}

	public int getSessionStartHour() {
		return sessionStartHour;
	}

}
