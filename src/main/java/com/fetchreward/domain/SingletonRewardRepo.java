package com.fetchreward.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SingletonRewardRepo {
	
	private static SingletonRewardRepo singletonRewardRepo = new SingletonRewardRepo();
	
	private List<Point> rewardAccum = new ArrayList<>();
	
	private SingletonRewardRepo() {	
	}
	
	public static SingletonRewardRepo getRewardRepo() {
		return singletonRewardRepo;
	}

	public void addPoint(Point point) {
		rewardAccum.add(point);
	}

	public Map<String,Integer> spendPoint(int pointValue) {
		
		if (getPointBalance()<pointValue) return null;
		
		Integer value = pointValue;
		Map<String, Integer> spendProjection = new HashMap<>();
		rewardAccum.sort(Comparator.naturalOrder());
	    for(int i=0; i<rewardAccum.size();i++) {
	    	String fromPayer = rewardAccum.get(i).getPayer();
	    	int spendValue = value;
	    	int credit = rewardAccum.get(i).getPoints();
	    		if (spendValue < credit) {
	    			spendProjection.compute(fromPayer,(k,v)->v==null?spendValue:v+spendValue);
	    			rewardAccum.get(i).setPoints(credit-spendValue);
	    			break;
	    		} else {
	    			spendProjection.compute(fromPayer,(k,v)->v==null?credit:v+credit);
	    			rewardAccum.get(i).setPoints(0);
	    			value = value-credit;
	    		}
	     }
	     return spendProjection;
	}
	
	
	public int getPointBalance() {
		return rewardAccum.stream().mapToInt(p->p.getPoints()).reduce(0,(a,b)->a+b);
	}
	
	public List<Point> getRewardAccum() {
		return rewardAccum;
	}

	public void setRewardAccum(List<Point> rewardAccum) {
		this.rewardAccum = rewardAccum;
	}

	@Override
	public String toString() {
		return " rewardAccum="
				+ rewardAccum + "]";
	}
	
	
	
	
	
}
