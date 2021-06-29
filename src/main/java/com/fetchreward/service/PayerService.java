package com.fetchreward.service;

import java.util.List;
import java.util.Map;

import com.fetchreward.domain.Point;

public interface PayerService {
	public void savePointTransaction(Point point);
	public Map<String, Integer> spendPoint(int pointValue);
	public int getBalance();
	public Map<String, Integer> getAllPayerBalance();
}