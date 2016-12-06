cd eveapi

# load bintray credentials
mkdir -p ~/.bintray
echo $BINTRAY_CREDENTIALS | sed 's/>/\n/g' > ~/.bintray/.credentials

# compile
sbt compile

# publish
sbt publish

# and push to bintrya
sbt bintrayRelease
