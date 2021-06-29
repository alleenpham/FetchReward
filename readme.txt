===================================================================================
Language, Framework, and Data Storage
===================================================================================
Language: Java SE 11
Framework: SpringBoot 2.5.2 and it key dependencies (spring-boot-starter-web)

Testing Tool used for front-controller: Postman

In-memory Data Storage: Java List Collection.
===================================================================================
RESTFul API
===================================================================================
RESTful Microservices API:
   POST /savePointTransaction
   GET  /getPayerBalance
   GET  /spendPoints
===================================================================================
Unit Test:
 1) Settings
 2) Request data
 3) Response and result (see TestPlanAdResult.xlxs)
===================================================================================
Server.port: 8085

Testing Tool used for front-controller: Postman

http://localhost:8085/savePointTransaction

 { "payer": "DANNON", "points": 1000, "timestamp": "2020-11-02T14:00:00Z" }

 { "payer": "UNILEVER", "points": 200, "timestamp": "2020-10-31T11:00:00Z" }

 { "payer": "DANNON", "points": -200, "timestamp": "2020-10-31T15:00:00Z" }

 { "payer": "MILLER COORS", "points": 10000, "timestamp": "2020-11-01T14:00:00Z" }

 { "payer": "DANNON", "points": 300, "timestamp": "2020-10-31T10:00:00Z" }
 
http://localhost:8085/getPayerBalance
http://localhost:8085/spendPoints?points=5000
http://localhost:8085/getPayerBalance
===================================================================================
How to run the application
===================================================================================
Use Eclipse or Spring Tool Suite to run com.fetchreward.controller.FetchrewardPayerPointApplication as SpringBoot application

 