#!/bin/bash
set -e

ROOT_FOLDER="$(pwd)"

buildMessages() {
  cd "$ROOT_FOLDER"/messages
  sh build.sh
}

buildProducerImage() {
  cd "$ROOT_FOLDER"/producer
  sh build.sh
}

buildConsumerImage() {
  cd "$ROOT_FOLDER"/consumer
  sh build.sh
}

buildServices() {
  buildMessages
  buildProducerImage
  buildConsumerImage
}

run() {
  buildServices
  docker-compose up -d
}

run
