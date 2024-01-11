mvn clean install -DskipTests
mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)
docker build --platform linux/amd64 -t spring/service-b:base-inst .
