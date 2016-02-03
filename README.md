Experiments driven from several spring demos.  Initially I split off the eureka server, just wanting to explore
the spring config portion seperatly for now.

Some URLS

1 https://github.com/spring-cloud-samples/configserver


# Using Profiles
Some good reading material [here](https://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-external-config.html)
Property files can have a profile in them, using a hyphen, ie 

    application-foo.properties
    
Where 'foo' is the profile name.  The syntax is application-profile.properties


# Microservice Clients
in the config of a spring microservice, it has a name in the bootstrap.yml, ie :

    spring:
    	application:
    		name: config-client
    		cloud:
    			config:
    				uri: http://localhost:8888
The client will pass along it's name 'config-client' to the uri specified.  The config server will return any 
'config-client'.(yml,properties).  I think if an profile is active for the microservive, that gets pass too