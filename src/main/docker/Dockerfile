FROM registry.cn-hangzhou.aliyuncs.com/wowealth/jdk1.8
VOLUME /tmp
ADD webcollector_boot-0.0.1-SNAPSHOT.jar app.jar
RUN sh -c 'touch /app.jar'
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]

