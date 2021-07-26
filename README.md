# Kafka Streams Application
A template for a brand new Kafka Streams application. Includes:

- Docker Compose configurations for running a local Kafka cluster
- A customizable bootstrap script for pre-creating and pre-populating the Kafka topics needed by your application
- Bundled build tooling (via Gradle Wrapper) so you don't need to worry about installing build tools

# Usage
```sh
# clone the repo
git clone https://github.com/mitch-seymour/kafka-streams-template.git

cd kafka-streams-template/

# reinit git
rm -rf .git && git init

# start the local Kafka cluster
docker-compose up -d

# run your Kafka Streams application
cd app/
./gradlew run --info

# you should see the test data get printed to your screen
```

# Customizing
- The script for pre-creating and pre-populating topics can be found in [/scripts/bootstrap-topics.sh](/scripts/bootstrap-topics.sh)
- The root directory for the Kafka Streams app can be found in the [/app](/app) directory
- Dependencies can be updated and added to [/app/build.gradle](/app/build.gradle)
- Your Kafka Streams topology can be updated in [/app/src/main/java/com/example/MyTopology.java](/app/src/main/java/com/example/MyTopology.java)

# Gradle commands
- Build the project with `./gradlew build --info`
- Run the application with `./gradlew run --info`
- View the dependencies using `./gradlew dependencies`
