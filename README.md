# Overview
Experiments driven from several spring demos.  Initially I split off the eureka server, just wanting to explore
the spring config portion seperatly for now.

SpringBoot provides a means of having a way to centralized config.  The default mode is to have
the configs backed by git.  You can specify branches, and other things

This code was evolved from the spring blog tutorial on the spring config server.

## Some URLS that are interesting:

1. https://github.com/spring-cloud-samples/configserver
2. http://cloud.spring.io/spring-cloud-config/spring-cloud-config.html
3. https://spring.io/blog/2015/01/13/configuring-it-all-out-or-12-factor-app-style-configuration-with-spring

# Creating and adding a config to the repo

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

# Some interesting things
It's possible to do have a config server register with a eureka server so services and clients
can download the url from that.  Not sure how they know which eureka server to talk to (hardcoded?)
