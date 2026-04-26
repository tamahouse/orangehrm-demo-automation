#!/bin/bash

REPORT_DIR=$1

cd $REPORT_DIR || exit 1

ROWS=""

for dir in $(ls -dt */); do
  name=$(basename "$dir")
  time=$(stat -c %y "$dir" | cut -d'.' -f1)

  if [ "$name" = "latest" ]; then
    ROWS="$ROWS<tr><td><a class='latest' href=\"$name\">$name ⭐</a></td><td>$time</td></tr>"
  else
    ROWS="$ROWS<tr><td><a href=\"$name\">$name</a></td><td>$time</td></tr>"
  fi
done

sed "s|{{REPORT_ROWS}}|$ROWS|" index.template.html > index.html