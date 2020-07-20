#spring-boot-microservices

This application demonstrates how to create microservices using spring boot.
It has three spring boot applications and one discovery server application.

Movie-Catalog-Service application is the main API application which interacts with other two microservices movie-info-service and ratings-data-service

User calls movie-catalog-service API by passing userId and this API internally invokes ratings-data-service to get all the movies rated by user and for each movie this API calls another API movie-info-service to get the details about movie. 

Movie-info-service calls external API themoviedb.org to get the movie details. 

All these three microservices are registered with Eureka server so that they can be discovered. Eureka server is using default port 8761.
