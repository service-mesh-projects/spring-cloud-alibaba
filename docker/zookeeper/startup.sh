#!/usr/bin/env bash
docker run --name my-zookeeper -p 2181:2181 --restart always -d zookeeper
