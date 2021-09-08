## USale

Usale is an e-commerce web application that facilitates consumer to consumer sales. Sellers are free to post items they are willing to sell on the platform. When posting an item, the seller needs to categorize their item and price their item. Buyers are able to search through categories or directly by the name of the item. This platform supports login, payment, and potentially bidding functionalities. 


## Module Deployment
### Heroku
- Create a maven project in terminal: 
  #### 'mvn archetype:generate -DarchetypeArtifactId=maven-archetype-webapp'  
-	Configure the pom.xml file to include the webapp-runner as an artifact item
-	Create a Procfile: 
  #### 'web: java $JAVA_OPTS -jar target/dependency/webapp-runner.jar --port $PORT target/*.war'
-	Commit to Git with:
  #### Git init
  #### Git  add .
  #### Git commit -m “message”
-	Create the Heroku app:
  #### 'heroku create'
-	deploy the code: 
 #### 'git push heroku master'





