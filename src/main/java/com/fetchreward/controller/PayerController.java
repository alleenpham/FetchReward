package com.fetchreward.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fetchreward.domain.Point;
import com.fetchreward.service.PayerService;

@RestController
public class PayerController {

	@Autowired
	PayerService payerService;
	
	@PostMapping(value="savePointTransaction")
	public ResponseEntity<?> savePointTransaction(@RequestBody JsonNode node ){
		String payer = node.get("payer").asText();
		int points = node.get("points").asInt();
		String timestamp = node.get("timestamp").asText();
		Point point = new Point(payer, points, timestamp);
		payerService.savePointTransaction(point);
		return new ResponseEntity<String> ("points was saved", HttpStatus.OK);
	}
	
	
	@GetMapping(value="spendPoints")
	public ResponseEntity<?> savePointTransaction(@RequestParam int points ){
		Map<String, Integer> spendLog = payerService.spendPoint(points);

        if (spendLog!=null) {		
        	ObjectMapper objMapper = new ObjectMapper();
	        
			JsonNode[] response = new JsonNode[spendLog.size()];
			int i=0;
			for(String payer: spendLog.keySet()) {
				int takenPoints = spendLog.get(payer);
				ObjectNode node = objMapper.createObjectNode();
				node.put("payer", payer);
				node.put("points", takenPoints*(-1));
				JsonNode jsonNode = objMapper.convertValue(node, JsonNode.class);
				response[i]=jsonNode;
				i++; 
			}
			return new ResponseEntity<JsonNode[]> (response, HttpStatus.OK);
        } else {
        	return new ResponseEntity<String> ("resource is empty", HttpStatus.NOT_FOUND);
        }
	}
	
	@GetMapping(value="getPayerBalance")
	public ResponseEntity<?> getPayerBalance(){
		Map<String, Integer>  payerPointBalance = payerService.getAllPayerBalance();
		ObjectMapper objMapper = new ObjectMapper();

		JsonNode[] response = new JsonNode[payerPointBalance.size()];
		int i=0;
		for(String payer: payerPointBalance.keySet()) {
			int points = payerPointBalance.get(payer);
			ObjectNode node = objMapper.createObjectNode();
			node.put("payer", payer);
			node.put("points", points);
			JsonNode jsonNode = objMapper.convertValue(node, JsonNode.class);
			response[i]=jsonNode;
			i++;
		}
		return new ResponseEntity<JsonNode[]> (response, HttpStatus.OK);
	}
	
}
