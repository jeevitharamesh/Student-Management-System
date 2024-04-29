This is Student management and Fee collection application built using
spring boot with in built h2 database. 

Swagger URL :
http://localhost:8080/swagger-ui/index.html

student-controller
get: /students


post: /students

{
"id":5,
"name":"Zakir",
"grade":"Grade 3",
"mobile" : "123456789",
"schoolName":"Skiply School"
}

post :  /receipts

{
    "student": {
        "id": 1
    },
    "cardNo": "123456",
    "cardType": "MasterCard",
    "amount": 12.0
}
get : /receipts/{id}



