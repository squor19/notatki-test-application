#!/bin/bash
# Wait for a TCP service to be available

set -e

host="$1"
port="$2"
shift 2
cmd="$@"

until nc -z -v -w30 "$host" "$port"; do
  echo "Waiting for $host:$port..."
  sleep 2
done

>&2 echo "$host:$port is available, executing command: $cmd"
exec $cmd