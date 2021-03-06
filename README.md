# RedditClone

<img width="1792" alt="RedditClonePreview" src="https://user-images.githubusercontent.com/23510777/83101994-6634ca00-a068-11ea-9466-20134fd195d6.png">

A Reddit like clone built using Angular, Spring Boot, Hibernate, and MySQL. It makes use of Angular features such as lazy loading to delay loading modules until necessary, Spring Boot Rest Controller to handle API calls, Spring Security to handle basic authentication using cookies and JWS, and Hibernate for object relational mapping. This app uses JUnit 5 to test for Java and Spring code.

## Prerequisites

npm https://www.npmjs.com/get-npm \
angular cli https://cli.angular.io/ \
mysql https://dev.mysql.com/downloads/mysql/ 

## Installing and Running

**Step 1:**
```
git clone https://github.com/vincendp/Reddit-Clone.git
```

### Client 

**Step 2:**
Open a new terminal

**Step 3:**
```
cd Reddit-Clone/client
```

**Step 4:**
```
npm install
```

**Step 5:**
```
ng serve
```

### Database

**Step 6:**
Start MySQL server, setup database, and run `redditdb.sql` and then `data.sql` SQL scripts under Reddit-Clone/server/src/main/resources/sql/

### Server

**Step 7:**
Edit `application.properties` at Reddit-Clone/server/src/main/resources/ to match your database. 
  + Edit **spring.datasource.url** where it says **YOURDBHERE** and replace with your database name 
  + Edit **spring.datasource.username** where it says **YOURUSERNAMEHERE** and replace with your database username 
  + Edit **spring.datasource.password** where it says **YOURPASSWORDHERE** and replace with your database password 

**Step 8:**
Open another new terminal

**Step 9:**
```
cd Reddit-Clone/server
```

**Step 10:**
```
./mvnw spring-boot:run 
```

**Step 11:**
Go to your browser at localhost:4200/ to view app


## Testing

**Step 1:**
To run Java unit tests and integration tests, open up a terminal

**Step 2:**
```
cd Reddit-Clone/server
```

**Step 3:**
```
./mvnw test
```

## To-Do
  + Sort by Top and New
