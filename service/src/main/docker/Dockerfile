FROM java:7
VOLUME /tmp
ADD fixed-asset.jar app.jar
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-jar","/app.jar"]