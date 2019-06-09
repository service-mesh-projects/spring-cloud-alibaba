#!/usr/bin/env bash
docker run --name some-zookeeper -p 2181:2181 --restart always -d zookeeper
