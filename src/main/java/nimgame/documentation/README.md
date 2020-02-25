Nim game documentation

This is a standalone Spring-boot application for a nim game.  

The ruleset is under [Game rules](GameRules.pdf)

##ENDPOINTS

All the API is accessible under /api/

If you start it locally, it would be  
localhost:8080/api/

###swagger

The endpoints are accessible with swagger under /swagger-ui.html

If you start it locally, it would be  
http://localhost:8080/swagger-ui.html  
There you can see the endpoints and accepted model examples.

###start
Under /start you can start new game  
http://localhost:8080/swagger-ui.html#/game-controller/startUsingPOST

Necessary parameters are 

  "firstTurn": "PLAYER", "COMPUTER" ([FirstTurn](../model/FirstTurn.java))  
  "strategy": "RANDOM", "WIN" ([Strategy](../model/Strategy.java))
  
###play
Under /play you can play a started game  
http://localhost:8080/swagger-ui.html#/game-controller/playUsingPOST    
Necessary parameters are 

  "matchesToTake": values 1-3 but maximal the amount of matches in game ([PlayersMove](../model/PlayersMove.java))

###status
Under /status you can get the status of currently running game  
http://localhost:8080/swagger-ui.html#/game-controller/statusUsingGET

There are no parameter needed

##Gameflow

The game has no session handling and is always having maximal one game running.

You don't have to finish a game to start it over. Every call to /start with valid parameters 
will restart the game.

If the parameters are not valid, you can customize error handling in 
[RestExceptionHandler](../exceptions/RestExceptionHandler.java)






  
