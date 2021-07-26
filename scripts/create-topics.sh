echo "Waiting for Kafka to come online..."

cub kafka-ready -b kafka:9092 1 20

echo "Creating Kafka topics"
# create the tweets topic
kafka-topics \
  --bootstrap-server kafka:9092 \
  --topic tweets \
  --replication-factor 1 \
  --partitions 4 \
  --create

echo "Pre-populating Kafka topics"
# pre-populate the topic
kafka-console-producer \
  --bootstrap-server kafka:9092 \
  --topic tweets \
  --property 'parse.key=true' \
  --property 'key.separator=|' < /data/inputs.txt

sleep infinity
