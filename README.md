How to make this application run E2E?

Start the Eureka Server Application : https://github.com/naveenluhach/EurekaServer
Start this application(as many instances as you want) at a different port(s) than above application. You can change the port in application.yml.


High Level Diagram:

https://app.diagrams.net/#G1sd6eNXGbbStOIRZmICgysz-MObFZYhMM

Data and Communication Flow:

Ingestion application is meant to ingest different types/formats of feedback from different sources for a client and make this data available for analysis.
Example: Myntra as a client may want to collect feedback on their products from Twitter, Google Play Store app reviews section etc.


