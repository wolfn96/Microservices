#!/bin/bash
echo "Projektseminar Microservices"
echo "Dozent: Dr Soddemann, Autor: Niclas Alexander Wolf"
echo "Discovery-Service wird gestartet"
java -jar "../Discovery/build/libs/discovery-0.0.1-SNAPSHOT.jar" > /dev/null 2>&1 &
echo "Gateway wird gestartet"
java -jar "../Gateway/build/libs/gateway-0.0.1-SNAPSHOT.jar" > /dev/null 2>&1 &
echo "Factory wird gestartet"
java -jar "../Factory/build/libs/factory-0.0.1-SNAPSHOT.jar" > /dev/null 2>&1 &
echo "Erster Service wird mit zufälligem Port gestartet"
java -jar "../Service/build/libs/service-0.0.1-SNAPSHOT.jar" > /dev/null 2>&1 & 
echo "Zweiter Service wird mit zufälligem Port gestartet"
java -jar "../Service/build/libs/service-0.0.1-SNAPSHOT.jar" > /dev/null 2>&1 &
echo "Dritter Service wird mit zufälligem Port gestartet"
java -jar "../Service/build/libs/service-0.0.1-SNAPSHOT.jar" > /dev/null 2>&1 &
