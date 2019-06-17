FROM tomcat

MAINTAINER gary <huangfei_aj@163.com>

EXPOSE 8080

RUN	rm -rf /usr/local/tomcat/webapps/*

ADD ROOT /usr/local/tomcat/webapps/ROOT

ENV JAVA_OPTS=""

ENTRYPOINT [ "/usr/local/tomcat/bin/catalina.sh" , "run" ]