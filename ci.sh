# compile
sbt compile

# load bintray credentials
mkdir -p ~/.bintray
echo $BINTRAY_CREDENTIALS | sed 's/>/\n/g' > ~/.bintray/.credentials

# publish
sbt publish
