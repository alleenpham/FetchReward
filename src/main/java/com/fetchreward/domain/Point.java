package com.fetchreward.domain;

import java.util.ArrayList;
import java.util.List;

public class Point implements Comparable<Point> {
	
	private String payer;
	private int points;
	
	private String timeStamp;

	public String getPayer() {
		return payer;
	}
	public void setPayer(String payer) {
		this.payer = payer;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	public String getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
	public Point() {
	}
	
	public Point(String payer, int points, String timeStamp) {
		super();
		this.payer = payer;
		this.points = points;
		this.timeStamp = timeStamp;
	}
	
	@Override
	public int compareTo(Point other) {
	
		return this.getTimeStamp().compareToIgnoreCase(other.getTimeStamp());
	}
	
	@Override
	public String toString() {
		return "Payer [ payer=" + payer + ", points=" + points + ", timeStamp=" + timeStamp + "]";
	}



	
	

	
}
