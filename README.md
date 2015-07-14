Step by step... oh baby...

upload:

curl -XPOST --data-binary @target/scala-2.11/meetup-assembly-0.1.jar localhost:8090/jars/meetup

curl -d 'input.string=word1 word2 word1 word3 word4' 'http://localhost:8090/jobs?appName=meetup&classPath=com.avenida.meetup.sugar.WordCountExample&sync=true' -XPOST -w "@curl-format.txt"

create context:
curl -XPOST localhost:8090/contexts/test

