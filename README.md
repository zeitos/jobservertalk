Step by step... oh baby...

upload:
```
curl -XPOST --data-binary @target/scala-2.11/meetup-assembly-0.1.jar localhost:8090/binaries/meetup -H "Content-Type: application/java-archive"
```
Call
```
curl -d 'input.string=word1 word2 word1 word3 word4' 'http://localhost:8090/jobs?appName=meetup&classPath=com.jampp.meetup.bigdata.WordCountExample&sync=true' -XPOST -w "@curl-format.txt"
```
or with the new API
```
curl -d 'input.string=word1 word2 word1 word3 word4' 'http://localhost:8090/jobs?appName=meetup&classPath=com.jampp.meetup.bigdata.WordCountExampleiNewApi&sync=true' -XPOST -w "@curl-format.txt"
```

create context:
```
curl -XPOST localhost:8090/contexts/test
```
Call with context
```
curl -d 'input.string=word1 word2 word1 word3 word4' 'http://localhost:8090/jobs?appName=meetup&classPath=com.jampp.meetup.bigdata.WordCountExampleiNewApi&sync=true&context=test' -XPOST -w "@curl-format.txt"
```
