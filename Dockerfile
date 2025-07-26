# pulling an image the has java 21
FROM bellsoft/liberica-openjdk-alpine:21.0.1
# install curl jq
RUN apk add curl jq
#setting the work directory
WORKDIR /home/automation-docker
#adding required files //use "." to add the files in the workdirectory
ADD target/docker-resources ./
ADD runner.sh   runner.sh
# Fix for windows
RUN dos2unix runner.sh
#Run the tests
ENTRYPOINT exec sh runner.sh
