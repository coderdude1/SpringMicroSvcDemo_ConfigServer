# Overview
Implements a springboot config server, intiallly created as part of the spring microservices demo.  For the
most part this can be used as is for any other project, you would just need to tweek the application.yml to
point to your git config repo. The default mode is to have the configs backed by git.  You can specify 
branches, and profiles.

A nice feature is if you make a change to a config file, then commit it, the changes will be read the very
next request.

This code was evolved from the spring blog tutorial on the spring config server, listed in the interesting
URLs

## Some URLS that are interesting:

2. https://github.com/spring-cloud-samples/configserver
2. http://cloud.spring.io/spring-cloud-config/spring-cloud-config.html
3. https://spring.io/blog/2015/01/13/configuring-it-all-out-or-12-factor-app-style-configuration-with-spring

# Creating and adding a config to the repo

## Using Profiles
Some good reading material [here](https://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-external-config.html)
Property files can have a profile in them, using a hyphen, ie 

    application-foo.properties
    
Where 'foo' is the profile name.  The syntax is application-profile.properties

You can specify branches too.

## Using Branches
TBD

# Microservice Clients
THe steps to enable a springboot/microservice to point in the config of a spring microservice, it has a 
name in the bootstrap.yml, ie :

    spring:
    	application:
    		name: config-client
    	cloud:
    		config:
    			uri: http://localhost:8888
    			failFast: false # If we can't talk to config server, die rather than keep trying to find it
                profile: alt # Used to show a profile config, comment out to show default profile

The client will pass along it's name 'config-client' to the uri specified.  The config server will return any 
'config-client'.(yml,properties).  You can specify a profile to use (ie dev, test, prod, etc).  I didn't
experiment using branches within the repo.

# Some interesting things
It's possible to do have a config server register with a eureka server so services and clients
can download the url from that.  Not sure how they know which eureka server to talk to (hardcoded?)
