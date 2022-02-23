**How to make this application run E2E?**

Start the Eureka Server Application : https://github.com/naveenluhach/EurekaServer
Start this application(as many instances as you want) at a different port(s) than above application. You can change the port in application.yml.


**High Level Diagram:**

https://app.diagrams.net/#G1sd6eNXGbbStOIRZmICgysz-MObFZYhMM

**Design **

a.Pull Based Model:
Scheduler - every X hours (configurable)
OnDemand via Rest client (Rare usage/ one time usage)

b.Push Based Model:
Stream APIs from different sources will be integrated.


**Data and Communication Flow:**
Ingestion application is meant to ingest different types/formats of feedback from different sources for a client and make this data available for analysis.
Example: Myntra as a client may want to collect feedback on their products from Twitter, Google Play Store app reviews section etc.


**Functional Requirements:**
1. Acquire, Clean and Ingest Data from a sources and store in a way which can be consumed easily later on.
  
Before storage, we have to perform data cleaning:
a.outliers - different from the rest of the data
b.duplicates- if hash is same
c.rule-violation - contains banned words
d.pattern violation- spelling mistakes

2. Onboarding of a new client should have minimal changes.(Used strategy pattern here)

**Non Functional Requirements:**
1. High Availability. (Made the application eureka client to load balance and scale out)


**Modeling:**

1.feedback

  `id` int NOT NULL AUTO_INCREMENT,
  `type` varchar(20) DEFAULT NULL,
  `language` varchar(20) DEFAULT NULL,
  `sourceid` int DEFAULT NULL,
  `tenantid` int DEFAULT NULL,
  `content` varchar(1000) DEFAULT NULL,
  `metadataid` int unsigned DEFAULT NULL,
  `hash` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unq_feedback_1` (`hash`)
  
2. sources

   `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)

3. tenant
   
   `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `sourceid` int DEFAULT NULL,
  `userid` int DEFAULT NULL,
  PRIMARY KEY (`id`)


4. twittermetadata

`id` int NOT NULL AUTO_INCREMENT,
  `country` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)


**CHANGES IN VERSION 2:**

Everything is derived through the data store MySQL. I have identified few use cases wherein we can move some load from MySQL to cache layer.
