#!/bin/bash

MAVEN_OPTS=-Djava.library.path=/usr/local/lib/R/site-library/rJava/jri mvn clean package exec:java

