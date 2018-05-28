set PORT=8080
set JAVA_OPTS=-Xmx350m -Xss512k

export DATABASE_URL=jdbc:postgresql://localhost:5432/kandidatenheroku?user=jdbc&password=jdbcpwd

call conf.cmd

mvnw clean install

java -Dserver.port=$PORT $JAVA_OPTS -jar target/kandidaten-0.0.18-SNAPSHOT.jar