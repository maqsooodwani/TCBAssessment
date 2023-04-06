API Description*******************

1. POST: http://localhost:9090/api/v1/createUser
Body: {
    "firstName": "Tabida",
    "lastName": "Maqsood",
    "gender": "F",
    "dateOfBirth": "27-06-2022",
    "address": [{
    	"addressType":"RESIDENTIAL",
    	"line1":"GR Residency",
    	"line2":"Arvind Nagar",
    	"postcode":"500008",
    	"city":"Hyderabad",
    	"state":"Talengana" 
    },
    {
    	"addressType":"WORK",
    	"line1":"Hi Tech",
    	"line2":"Cyber City",
    	"postcode":"500008",
    	"city":"Hyderabad",
    	"state":"Talengana" 
    }]
}

2. PUT: http://localhost:9090/api/v1/updateUser
Body: {
    "userId":4,
    "firstName": "Razia",
    "gender": "F"
}

3. GET: http://localhost:9090/api/v1/user/1
