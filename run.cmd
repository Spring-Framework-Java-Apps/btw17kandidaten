set JAVA_OPTIONS="-Xmx300m -Xss512k -Dfile.encoding=UTF-8"

set DATABASE_URL=jdbc:postgresql://localhost:5432/kandidaten?user=jdbc&password=jdbcpwd

call conf.cmd

mvnw clean spring-boot:run

exit 0
