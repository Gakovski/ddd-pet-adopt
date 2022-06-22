FROM maven:3.8.2-openjdk-11-slim AS build

COPY /shared-kernel /home/app/shared-kernel

#COPY /pet-catalog /home/app/pet-catalog
COPY /adopter-management /home/app/adopter-management
#COPY /order-management /home/app/order-management


FROM openjdk:11.0-jre-slim

#COPY --from=build /home/app/pet-catalog/target/*.jar /pet-catalog.jar
COPY --from=build /home/app/adopter-management/target/*.jar /adopter-management.jar
#COPY --from=build /home/app/order-management/target/*.jar /order-management.jar

COPY --from=build /home/app/shared-kernel/target/*.jar /shared-kernel.jar
EXPOSE 9093
ENTRYPOINT ["java", "-cp", "shared-kernel.jar", "-jar", "adopter-management.jar"]