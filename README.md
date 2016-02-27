# ngRESTTest
Spring MVC application with AngularJS Single page application on front-end.

### This is a test application combining angularJS and Java Spring MVC.
It consists of a "Companies" manager. You can CREATE, UPDATE and RETRIEVE a company.
You can also ADD beneficial owners to a company. To do this operations you can use
the REST api provided or use the web interface. The web interface is made using angularJS
in a Single Page Application pattern.


Usage
----

To access REST api you can use cURL or other client to do GET and POST requests for web services application,
all web services receives and returns JSON as communication pattern.

Api Web Services Methods:

Method call | Input | Response | Http Method
------------ |------------ | ------------- | -------------
/company/listall | - null |Lists all companies in the database | GET
/company/companyDetails/{id} | - {id} = company id | Retrieve a single company based on it's id | GET
/company/save | - data: JSON company | Returns inserted Company | POST
/company/addBeneficialOwner/{id} | - {id} = company id <br> - data: JSON owner | Returns a company with all Beneficial owners | POST



### Exemple of requests using cURL:
####List all companies

``curl http://localhost:8082/company/listall``

####Retrieve company details

``curl http://localhost:8082/company/companyDetails/1``

####Create company

``curl -H "Content-Type: application/json" -X POST -d '{"name":"Company One","address":"211, Street St.","city":"New Cit","country":"UK"}' http://localhost:8082/company/save``

####Update company

``curl -H "Content-Type: application/json" -X POST -d '{"id":"1","name":"Company One","address":"211, Street St.","city":"New Cit","country":"UK"}' http://localhost:8082/company/save``

####Add beneficial owner to company

``curl -H "Content-Type: application/json" -X POST -d '{"name":"John Doe"}' http://localhost:8082/company/addBeneficialOwner/1``


To access web client enter only the root url:
----
e.g: ``http://localhost:8082``
