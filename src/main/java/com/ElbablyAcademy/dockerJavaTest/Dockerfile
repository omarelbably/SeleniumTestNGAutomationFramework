FROM alpine
RUN  apk add openjdk17
ENV PATH $PATH:/usr/lib/jvm/java17-openjdk/bin
WORKDIR /a/b/c
ADD DockerTest.java DockerTest.java
ENTRYPOINT javac DockerTest.java && java DockerTest