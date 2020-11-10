# Client for E-HTL Restful Hotel Booking API

[E-HTL](https://www.e-htl.com.br) is a hotel booking Restful API where you can search for hotel avaiabilities, room details, book and cancel hotel reservation.

It's documentation can be found on this [link](http://integration-quasar.e-htl.com.br/api-reference#!/OAuth/post_oauth_access_token).

This project was built with Spring webclient to make the requests and Jackson Object Mapper to deserialize E-htl response to Java objects.

There are Junit tests to token requests, get destination ID, search hotel availabilities, get details about hotel availabilities, create and cancel 
hotel reservation.

All request calls are done using a test credential.

