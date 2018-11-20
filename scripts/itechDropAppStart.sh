#!/bin/bash

projectDir=$HOME/itech/itech-dropwizard-example

echo "start jar in folder ${projectDir}/target"
echo "use following yml-Configuration: "
cat ${projectDir}/conf/itechDropConf.yml
java -jar ${projectDir}/target/dropwizard-example-1.0-SNAPSHOT.jar server ${projectDir}/conf/itechDropConf.yml

# Heap-Speicher beeinflussen
#java -Xms16m -Xmx16m -XX:+CMSClassUnloadingEnabled -jar ${projectDir}/target/dropwizard-example-1.0-SNAPSHOT.jar server /Users/heiko/itech/itech-dropwizard-example/conf/itechDropConf.yml

