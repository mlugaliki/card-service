# Card services
### Environment setup
#### Pre-requisites
- Java 17
- Maven 3.6
- Mysql 8

### Building the service
- Clone the repo from Github
- change directory to csrd-service
- Create mysql database called ``cards``
- Run maven command to download dependencies ``mvn verify`` 
- update database connection url in ``application.yml``. ``url: jdbc:mysql://127.0.01:3306/cards?useSSL=true``. Change the IP & port for the databse
- Update database username & password<br/>
``username: root``<br/>
``password: root``
- Build and run the service ``mvn ``
