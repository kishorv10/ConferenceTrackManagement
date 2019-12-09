/**
 * 
 */
package com.ctm.types;

/**
 * @author Kishor
 *
 */
public class TalkScheduledTime {
	
	private int hour;	
	private int min;
	
	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}
	
	public TalkScheduledTime(int pHour, int pMin) {
		
		this.hour = pHour + (pMin/60);
		this.min = pMin%60;		
		
	}
	
	
	public TalkScheduledTime addTime(TalkScheduledTime pTime, int mins) {
		int totalMin = pTime.getMin() + mins;
		int hour = pTime.hour + (totalMin/60);
		int min = totalMin%60;
		return new TalkScheduledTime(hour, min);
	}
	

	
	public String toString() {
		String minString = String.valueOf(min);
		minString = (minString.length() == 1) ? ("0" + minString):minString;
		
		
		int newHour = (hour>12)?hour-12:hour;
		String hourString = String.valueOf(newHour);
		hourString = hourString.length() == 1 ? ("0" + hourString) : hourString;
		
		return hourString + ":" + minString + " " + ((hour>12)?"PM":"AM");
			
	}

}
