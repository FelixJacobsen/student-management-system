![Repo size](https://img.shields.io/github/repo-size/FelixJacobsen/student-management-system)
![Last_commit](https://img.shields.io/github/last-commit/FelixJacobsen/student-management-system)
# <img src="https://user-images.githubusercontent.com/89127725/154549539-4ac9c2e2-9207-4d80-bace-1425452fc839.svg" width="100" height="100"> student-management-system

Simple JAX-RS application that runs on a Payara local server. Includes a "student" entity with CRUD functionality.
To use this application you simply need to clone/fork this projekt, download Payara and add it to the project configuration. Insomnia can be used for sending requests and alternate the data. 


# Endpoints
POST
```
- api/v1/students

{
	"email": "johan.andersson@hotmail.com",
	"firstName": "Johan",
	"id": 1,
	"lastName": "Andersson",
	"phoneNumber": "123456"
}
Response code: 200 OK
```
GET ONE
```
-api/v1/students/{id}
Response code: 200 OK
```
GET ALL
```
-api/v1/students
Response code: 200 OK
```

GET BY LASTNAME
```
-api/v1/students/search?lastName={surname}
Example: api/v1/students/search?lastName=Eriksson

Response code: 200 OK
```


DELETE
```
-api/v1/students/{id}
Response code: 200 OK
```
PUT
```
-api/v1/students/{id}
{
	"id":"1",
	"email": "niklas.eriksson@gmail.com",
	"firstName": "Niklas",
	"lastName": "Eriksson",
	"phoneNumber": "98765"
}
Response code: 201 Created	
```

PATCH
-api/v1/students/{id}
```
{
    "phoneNumber": "98765"
}
Response code: 200 OK
```



Made by Felix Jacobsen
