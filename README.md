 # Insurance Management Application assignment

## Running Application

To run the application, I have provided source code and compiled package at [github](https://github.com/lnxbsh/InsuranceManagementAssignment/master) 

> Download and unzip https://drive.google.com/file/d/1Dx8aAbqzw3xSC_PP4mtfzMqcDxc1XEDV/view?usp=sharing


```sh
cd target
java -jar InsuranceManagementPlatform-0.0.1-SNAPSHOT.jar

```

## API Endpoints 

- Clients is located at /api/clients 
- Policy is located at /api/policies
- Claim is located at /api/claim

API for Clients

```sh
GET /api/clients //to fetch all clients
POST /api/clients // it take json as input

{
  "name":"John",
  "address":"Tokiyo",
  "contact":9512364789,
  "dob":"2017-03-02"
}


GET /api/clients/31 // get client by id

PUT /api/clients/1 // to update clienta also take json

DELETE /api/clients/1 //to delete client with id 1

```

API for Policy

```sh
GET /api/policies

POST /api/policies //Take Json also clients id

{
    "insurancePolicyEntity": 
    {"type":"ywdsawdsay",
    "coverageAmount":105.5,
    "premiumAmount":11.5,
    "startDate":"2017-01-23",
    "endDate":"2018-01-01"
    },
    "client_id": 3153
}

GET /api/policies/1 //return policy by id

PUT /api/policies/1 //take json

DELETE /api/policies/1

```

API for Claims
```sh
GET /api/claims

POST /api/claim //take json with claim details with policy id
{
    "claimEntity":{
        "description": "asefs the claimEntity",
        "claimDate":"2017-07-05",
        "claimStatus": "Process"
    },
    "policy_id":7952
}

```
## Build application 

> change dir to project root directory
> Fetch dependency using
```sh
.\mvnw clean install
```
> To compile source code run 
```sh
  .\mvnw compile
```
> To build package
```sh
.\mvnw package
```
