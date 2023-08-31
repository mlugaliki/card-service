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
- Build and run the service ``./mvnw spring-boot:run``

### Testing the application
Users are created when the service starts using a runner. It checks whether there are existing users, if the exist then the runner ignore creating them else it created the users.
Check class ``com.logicea.cards.component.UserRunner``.

#### Get a token
- Endpoint: `localhost:8080/cards/auth/signin`
- Method: `POST`
- Request <br/>
  ``{
  "email":"admin@example.com",
  "password":"password"
  }``

#### Save card
- Endpoint: `http://localhost:8080/cards/`
- Method: `POST`
- Request
``{
  "name": "test",
  "colour": "#000000",
  "status": "TO_DO"
  }``

#### Update card
- Endpoint: `http://localhost:8080/cards/{id}`
- `{id}` - Card unique identifier
- Method: `PUT`
- Request
  ``{
  "id":1,
  "name": "test",
  "colour": "#000000",
  "status": "TO_DO"
  }``

#### Delete card
- Endpoint: `http://localhost:8080/cards/{id}`
- `{id}` - Card unique identifier
- Method: `DELETE`


#### Search card
- Endpoint: `http://localhost:8080/cards/search`
- Method: `POST`
- Request
``{
  "colour":"#000000",
  "name":"Gold",
  "status": "TO_DO",
  "createDate": "2023-08-01",
  "orderColumn": "name",
  "direction": "DESC"
  }``
### NB 
- For order column select from ``created_at, colour, name, status``
- For direction select from `` ASC, DESC``
