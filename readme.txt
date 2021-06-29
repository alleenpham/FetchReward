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
 1) Calling http://localhost:8085/savePointTransaction to save (payer/point)
   Below are (payer/points) will be added into the resource by calling microservice "http://localhost:8085/savePointTransaction"
   { "payer": "DANNON", "points": 1000, "timestamp": "2020-11-02T14:00:00Z" }
   { "payer": "UNILEVER", "points": 200, "timestamp": "2020-10-31T11:00:00Z" }
   { "payer": "DANNON", "points": -200, "timestamp": "2020-10-31T15:00:00Z" }
   { "payer": "MILLER COORS", "points": 10000, "timestamp": "2020-11-01T14:00:00Z" }
   { "payer": "DANNON", "points": 300, "timestamp": "2020-10-31T10:00:00Z" }
 2) Calling http://localhost:8085/getPayerBalance to verfiy (payer/points) added into server resource successfully.
 3) Calling http://localhost:8085/spendPoints?points=5000 to reduct the points spent by the users,
    and verify point reduction rule (reduct points based on timestamp in order oldest to newer).
 4) Calling http://localhost:8085/getPayerBalance to verfiy (payer/points) after points reduction.
 Note: Response and result (see TestPlanAdResult.xlxs)
===================================================================================
Server.port: 8085
Testing Tool used for front-controller: Postman
===================================================================================
How to run the application
===================================================================================
Use Eclipse or Spring Tool Suite to run com.fetchreward.controller.FetchrewardPayerPointApplication as SpringBoot application

 
