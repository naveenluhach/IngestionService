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
Database used : MySQL
Tables involved:

1.feedback

  id: int
  type: string //represents tweet, play store review review, comment, article
  language: string //represents english, hindi etc
  sourceid: int 
  tenantid: int 
  content: string // represents actual content
  metadataid: int // represent foreign key of meta data table specific to source (twitter, google etc)
  hash: string //represents sha256 hash of above fields to check for duplicacy
  Primary key: id
  Unique key: hash
  
2. sources

  id: int
  name: string 
  PRIMARY KEY: id

3. tenant
   
  id: int 
  name: string
  sourceid: int
  userid: int 
  Primay key: id


4. twittermetadata

id: int
country: string 
Primary Key: id


**CHANGES IN VERSION 2:**

Everything is derived through the data store MySQL. I have identified few use cases wherein we can move some load from MySQL to cache layer.
