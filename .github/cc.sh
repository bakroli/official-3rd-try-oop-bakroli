#!/usr/bin/env bash

url="${CCCLASSROOM_URL}?CI=${CI}&ASSESSMENT_ID=${ASSESSMENT_ID}&CHALLENGE_ID=${CHALLENGE_ID}&GITHUB_ACTOR=${GITHUB_ACTOR}&GITHUB_REPOSITORY=${GITHUB_REPOSITORY}&GITHUB_SERVER_URL=${GITHUB_SERVER_URL}"


for f in target/surefire-reports/*.txt
do
  if [[ -f $f ]]; then
  grep '^Tests run:.*Time elapsed:' "$f" | tee tmp.txt
  curl -m 2 -s -X POST -d @tmp.txt -H "Content-Type: application/json" "$url"
  else
    echo "Surefire reports were not found... Maybe project did not comply. Sending GET to CCClassroom server"
    curl -m 2 "$url"
  fi
done
rm tmp.txt
