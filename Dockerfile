# Se crea la primera etapa que se encarga de la compilacion para generar el .jar necesario
FROM maven:3.6.3-jdk-8 AS MAVEN_BUILD
# Se copia el codigo y el pom en nuestro contenedor
COPY ./ ./
# Se ejecuta el comando clean para limpiar lo que esta construido y ejecuta install para empaquetar y generar el jar (sin pruebas)
RUN mvn clean install -DskipTests
# Se crea la segunda etapa que se encarga de la ejecucion de nuestra app (.jar)
FROM openjdk:8-jdk-alpine
# Se copia el .jar generado dentro de la primera etapa de maven en un un jar que podemos gestionar (/app.jar)
COPY --from=MAVEN_BUILD /prueba-tecnica/target/*.jar /app.jar
# configurar el comando de inicio para ejecutar el jar
ENTRYPOINT ["java","-jar","/app.jar"]