#!/bin/sh
mkdir -p xml/src/main/resources/xsd/eve
mkdir -p xml/src/main/resources/xsd/char
mkdir -p xml/src/main/resources/xsd/corp
mkdir -p xml/src/main/resources/xsd/account
mkdir -p xml/src/main/resources/xsd/map
mkdir -p xml/src/main/resources/xsd/server
for xml in `find xml/src/main/resources/raw/ -name '*.xml'`;
do
    input=$xml;
    output=`echo $xml | sed 's/raw/xsd/g' | sed 's/\.xml/\.xsd/g'`;
    java -jar xml/util/trang.jar $input $output 2>/dev/null;
    echo "$output";
done
for xsd in `find xml/src/main/resources/xsd/ -name '*.xsd'`;
do
    p=`echo $xsd | sed 's/.*xsd\//eveapi.xml./' | sed 's:/:.:' | sed 's/\.xsd$//g'`;
    java -jar xml/util/scalaxb.jar $xsd -p $p --package-dir --protocol-package $p -d xml/src/main/scala/ > /dev/null 2>/dev/null;
done
find xml/src/main/scala/ -name *.scala
