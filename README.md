Quarkus Rules Event
=====================================================================

Example of event driven decisioning using Kogito Rules on Quarkus


```sh
curl -X POST "http://localhost:8090/event" -H  "accept: */*" -H  "Content-Type: application/json" -d "{\"readingDateTime\":\"2021-03-13T11:00:00.000Z\",\"temperature\":0}"
curl -X POST "http://localhost:8090/event" -H  "accept: */*" -H  "Content-Type: application/json" -d "{\"readingDateTime\":\"2021-03-13T11:00:10.000Z\",\"temperature\":10}"
```
