package com.fetchreward.service;

import java.util.Map;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.fetchreward.domain.Point;
import com.fetchreward.domain.SingletonRewardRepo;

@Service
public class PayerServiceImpl implements PayerService {
	
	private SingletonRewardRepo rewardRepo = SingletonRewardRepo.getRewardRepo();

	@Override
	public void savePointTransaction(Point point) {
		rewardRepo.getRewardAccum().add(point);	
	}

	@Override
	public Map<String, Integer> spendPoint( int pointValue) {
		return rewardRepo.spendPoint(pointValue);
	}

	@Override
	public int getBalance() {
			return rewardRepo.getPointBalance();
	}

	@Override
	public Map<String, Integer> getAllPayerBalance() {
		Stream<Point> pool =rewardRepo.getRewardAccum().stream();
		return pool.collect(Collectors.groupingBy(Point::getPayer,Collectors.summingInt(p->p.getPoints())));

	}

}
